package com.example.abdulkarem_alkhamis;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login, newaccount;
    EmployeeDao employeeDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.usernameid);
        password = findViewById(R.id.passwordid);
        login = findViewById(R.id.loginid);
        newaccount = findViewById(R.id.newaccountid);

        EmployeeDataBase employeeDataBase = EmployeeDataBase.getInstance(this);
        employeeDao = employeeDataBase.getEmployeeDao();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                checkEmployee(user, pass);
            }
        });

        newaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);
            }
        });
    }

    private void checkEmployee(String username, String password) {
        if (employeeDao == null) {
            Toast.makeText(Login.this, "Database not initialized", Toast.LENGTH_SHORT).show();
            return;
        }

        Employee employee = employeeDao.getEmployee(username, password);
        if (employee != null) {
            Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Login.this, MainActivity.class);
            intent.putExtra("employee_id", employee.getId());
            startActivity(intent);
        } else {
            Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }
}
