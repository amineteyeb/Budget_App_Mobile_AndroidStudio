package com.example.mobilebudget.Activity;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mobilebudget.Session.SessionManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobilebudget.Database.AppDataBase;
import com.example.mobilebudget.Module.User;
import com.example.mobilebudget.R;

import java.util.List;

public class Login extends AppCompatActivity {
    private Button b;
    private EditText email, password;
    private TextView createAcc;
    private Context context;
    AppDataBase database;
    private List<User> personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SessionManager sessionManager = new SessionManager(this);

        context = Login.this;
        database = AppDataBase.getAppDatabase(context);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b = findViewById(R.id.loginBtn);
        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
        createAcc = findViewById(R.id.create);
        personList = database.userDao().getAll();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredEmail = email.getText().toString();
                String enteredPassword = password.getText().toString();

                // Check if the entered credentials are valid
                if (isCredentialsValid(enteredEmail, enteredPassword)) {
                    sessionManager.setLoggedIn(true);
                    sessionManager.setUserName(enteredEmail);
                    // Credentials are valid, redirect to MainActivity
                    Intent intent = new Intent(Login.this, mainActivity.class);
                    startActivity(intent);
                } else {
                    // Wrong credentials, show a toast
                    showToast("Wrong credentials. Please try again.");
                }
            }
        });
        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(Login.this, register.class);
                    startActivity(intent);

            }
        });

    }
    private boolean isCredentialsValid(String email, String password) {
            // Check if the entered credentials match any user in the database
            for (User person : personList) {
                if (person.getFirstName() != null && person.getPassword() != null &&
                        person.getFirstName().equals(email) && person.getPassword().equals(password)) {
                    return true; // Credentials are valid
                }
            }
            return false; // Credentials are not valid
        }
    private void listUpdate(){
        personList.clear();
        personList.addAll(database.userDao().getAll());
    }
    private void showToast(String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}