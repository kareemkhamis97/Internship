package com.example.abdulkarem_alkhamis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {

    EditText name, surname, username, password, birthYear;
    Button register;

    EmployeeDao employeeDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = findViewById(R.id.rnameid);
        surname = findViewById(R.id.rsurnameid);
        username = findViewById(R.id.rusernameid);
        password = findViewById(R.id.rpasswordid);
        birthYear = findViewById(R.id.rbirthyearid);
        register = findViewById(R.id.registerid);

        EmployeeDataBase employeeDataBase = EmployeeDataBase.getInstance(this);
        employeeDao = employeeDataBase.getEmployeeDao();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDetails();
            }
        });
    }

    private void saveDetails() {
        String enteredUsername = username.getText().toString();
        Employee existingEmployee = employeeDao.getUserByUsername(enteredUsername);

        if (existingEmployee != null) {
            Toast.makeText(Registration.this, "The user already exists", Toast.LENGTH_SHORT).show();
        } else {
            String enteredName = name.getText().toString();
            String enteredSurname = surname.getText().toString();
            String enteredPassword = password.getText().toString();

            // Handle parsing exception for birthYear
            int enteredBirthYear = 0;
            try {
                enteredBirthYear = Integer.parseInt(birthYear.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(Registration.this, "Invalid birth year", Toast.LENGTH_SHORT).show();
                return;
            }

            Employee newEmployee = new Employee(enteredName, enteredUsername, enteredPassword, enteredSurname, enteredBirthYear);
            employeeDao.insert(newEmployee);

            Toast.makeText(Registration.this, "Registration successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Registration.this, Login.class);
            startActivity(intent);
        }
    }
}
