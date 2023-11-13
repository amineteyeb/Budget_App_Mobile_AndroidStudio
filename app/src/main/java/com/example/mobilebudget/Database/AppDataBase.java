package com.example.mobilebudget.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;

import com.example.mobilebudget.DAO.UserDAO;
import com.example.mobilebudget.Module.User;

import java.util.List;
import java.util.Map;
import java.util.Set;


@Database(entities = {User.class  }
        , version = 1
        , exportSchema = false)
public abstract class  AppDataBase extends RoomDatabase {
    private static AppDataBase instance;



    public abstract UserDAO userDao();

    public static AppDataBase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "room_test_db")

                    .allowMainThreadQueries()
                    .build();

        }
        return instance;
    }
}