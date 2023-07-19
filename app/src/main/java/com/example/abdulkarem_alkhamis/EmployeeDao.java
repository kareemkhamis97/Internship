package com.example.abdulkarem_alkhamis;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
@Dao
public interface EmployeeDao {

    @Query("SELECT * FROM Employee WHERE username= :username AND password= :password")
    Employee getEmployee(String username, String password);

    @Query("SELECT * FROM Employee WHERE username = :username")
    Employee getUserByUsername(String username);

    @Insert
    void insert(Employee employee);

    @Update
    void update(Employee employee);



    @Query
            ("DELETE FROM Employee WHERE id = :employeeId")
    void deleteById(int employeeId);

    @Query("SELECT * FROM Employee WHERE id = :id")
    Employee getEmployeeById(int id);

    @Query("SELECT * FROM Employee WHERE id = :employeeId")
    Employee getById(int employeeId);


}
