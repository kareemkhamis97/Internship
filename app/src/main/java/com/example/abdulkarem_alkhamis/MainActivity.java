package com.example.abdulkarem_alkhamis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView welcomeMessage;
    Button delete, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeMessage = findViewById(R.id.welcome_message);
        EmployeeDataBase employeeDataBase = EmployeeDataBase.getInstance(this);
        EmployeeDao employeeDao = employeeDataBase.getEmployeeDao();

        int employeeId = getIntent().getIntExtra("employee_id", -1);
        Employee employee = employeeDao.getById(employeeId);

        if(employee != null){

            TextView employeeNameTextView = findViewById(R.id.welcome_message);
            employeeNameTextView.setText(employee.getName() + " " + employee.getSurname());

            delete = findViewById(R.id.deleteid);
            logout = findViewById(R.id.logoutid);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int employeeId = getIntent().getIntExtra("employee_id", -1);
                    if(employeeId != -1){
                        Employee employeeDao = (Employee) EmployeeDataBase.getInstance(MainActivity.this).getEmployeeDao();

                        employeeDao.deleteById(employeeId);
                        Toast.makeText(MainActivity.this, "Account deleted", Toast.LENGTH_SHORT).show();
                    }

                }
            });
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                }
            });
        }
    }
}