package com.example.mobilebudget;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.mobilebudget.DAO.UserDAO;
import com.example.mobilebudget.Database.AppDataBase;
import com.example.mobilebudget.Module.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private AppDataBase appDatabase;
    private UserDAO userDao;
    private List<User> userList = new ArrayList<User>();



    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.mobilebudget", appContext.getPackageName());
    }
}