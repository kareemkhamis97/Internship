package com.example.abdulkarem_alkhamis;


import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Employee {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String username;
    private String password;
    private int birthYear;
    private String surname;


    public Employee(String name, String username, String password, String surname, int birthYear){
        if (name.isEmpty() || username.isEmpty() || password.isEmpty() || surname.isEmpty()) {
            throw new IllegalArgumentException("Name, username, password and surname cannot be empty");
        }
        this.name = name;
        this.username = username;
        this.password = password;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void deleteById(int employeeId) {
    }
}
