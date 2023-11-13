package com.example.mobilebudget.Activity;

import android.content.Context;
import android.os.Bundle;

import com.example.mobilebudget.Database.AppDataBase;
import com.example.mobilebudget.Session.SessionManager;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mobilebudget.databinding.ActivityMonCompteBinding;

import com.example.mobilebudget.R;

public class MonCompte extends AppCompatActivity {
    AppDataBase database;
    private Context context;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMonCompteBinding binding;
private TextView email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_compte);

        SessionManager sessionManager = new SessionManager(this);

        context = MonCompte.this;
        database = AppDataBase.getAppDatabase(context);

        email = findViewById(R.id.email_profile);
        email.setText(sessionManager.getUserName());


    }
    private void showToast(String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}