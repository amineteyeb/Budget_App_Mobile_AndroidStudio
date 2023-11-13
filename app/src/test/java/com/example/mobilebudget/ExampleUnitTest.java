package com.example.mobilebudget;

import static org.junit.Assert.assertEquals;
import androidx.test.core.app.ApplicationProvider;



import android.content.Context;

import androidx.room.Room;

import com.example.mobilebudget.DAO.UserDAO;
import com.example.mobilebudget.Database.AppDataBase;
import com.example.mobilebudget.Module.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExampleUnitTest {

    // You need to use the Application Context or an in-memory database for testing
private Context context;
   AppDataBase appDatabase;
    private UserDAO userDao;
    private List<User> userList = new ArrayList<User>();
    @Before
    public void setup() {
        Context context = ApplicationProvider.getApplicationContext();
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDataBase.class).build();
        userDao = appDatabase.userDao();
    }

    @After
    public void closeDatabase() throws IOException {
        appDatabase.close();
    }


    @Test
    public void aa() {


        User user = new User();
        user.setFirstName("aa");
        user.setPassword("aa");
        user.setUid(1);

        userDao.insertOne(user);
        List<User> items = userDao.getAll();

        assertEquals(1, items.size());
        for (User a : items) {
            System.out.println(a);
        }
}}
