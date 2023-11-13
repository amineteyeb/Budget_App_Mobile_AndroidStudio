package com.example.mobilebudget.Activity;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mobilebudget.databinding.ActivityMonCompteBinding;

import com.example.mobilebudget.R;

public class MonCompte extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMonCompteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_compte);



    }


}