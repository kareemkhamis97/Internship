package com.example.abdulkarem_alkhamis;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Employee.class}, version = 1, exportSchema = false)
public abstract class EmployeeDataBase extends RoomDatabase {
    public static EmployeeDao getEmployeeDao() {
        return null;
    }

    private static volatile EmployeeDataBase INSTANCE;

    public static EmployeeDataBase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context,EmployeeDataBase.class,"employee_database").build();
        }
        return INSTANCE;
    }
}
