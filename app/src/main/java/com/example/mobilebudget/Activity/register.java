package com.example.mobilebudget.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobilebudget.Database.AppDataBase;
import com.example.mobilebudget.Module.User;
import com.example.mobilebudget.R;

import java.util.List;

public class register extends AppCompatActivity {

    private Button b;
    private EditText email, password;
    private TextView btnforget;
    private Context context;
    AppDataBase database;
    private List<User> personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = register.this;
        database = AppDataBase.getAppDatabase(context);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration);
        b = findViewById(R.id.regBtn);

        email = findViewById(R.id.regEmail);
        password = findViewById(R.id.regPassword);
        personList = database.userDao().getAll();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredEmail = email.getText().toString();
                String enteredPassword = password.getText().toString();

                // Check if the email is already in use
                if (isEmailInUse(enteredEmail)) {
                    showToast("Email is already in use.");
                } else {
                    // Email is not in use, proceed to create the user
                    User newPerson = new User();
                    newPerson.setFirstName(enteredEmail);
                    newPerson.setPassword(enteredPassword);
                    database.userDao().insertOne(newPerson);
                    listUpdate();
                    showToast("User created successfully.");
                    Intent intent = new Intent(register.this, Login.class);
                    startActivity(intent);
                }
            }
        });
    }
    private boolean isEmailInUse(String email) {
                // Check if the email is in the list of existing users
                for (User person : personList) {
                    if (email != null && email.equalsIgnoreCase(person.getFirstName())) {
                        return true; // Email is already in use
                    }
                }
                return false; // Email is not in use
            }
    private void listUpdate(){
        personList.clear();
        personList.addAll(database.userDao().getAll());
    }
    private void showToast(String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }


}
