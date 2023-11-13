package com.example.mobilebudget.Activity;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobilebudget.Database.AppDataBase;
import com.example.mobilebudget.Module.User;
import com.example.mobilebudget.R;

import java.util.List;

public class Login extends AppCompatActivity {
    private Button b;
    private EditText email, password;
    private Context context;
    AppDataBase database;
    private List<User> personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = Login.this;
        database = AppDataBase.getAppDatabase(context);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b = findViewById(R.id.loginBtn);
        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
        personList = database.userDao().getAll();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder = new StringBuilder();

                    User newPerson = new User();
                    newPerson.setFirstName(email.getText().toString());
                    newPerson.setPassword(password.getText().toString());
                    database.userDao().insertOne(newPerson);
                listUpdate();
                for(User person : personList){

                    stringBuilder.append(person.getFirstName()+"  "+person.getPassword() );
                    stringBuilder.append("\n");
                }
                String allData = stringBuilder.toString();
                showToast(allData);
            }
              //  Intent intent = new Intent(Login.this, mainActivity.class);
              //  startActivity(intent);
               // }

        });
    }
    private void listUpdate(){
        personList.clear();
        personList.addAll(database.userDao().getAll());
    }
    private void showToast(String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}