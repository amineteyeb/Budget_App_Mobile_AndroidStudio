package com.example.mobilebudget.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.mobilebudget.Fragments.fragment_depenses;
import com.example.mobilebudget.Fragments.fragment_revenues;
import com.example.mobilebudget.databinding.ActivityGestionBudgetBinding;

import com.example.mobilebudget.R;

public class GestionBudget extends AppCompatActivity {
    Button revenues, depenses ;
    private AppBarConfiguration appBarConfiguration;
    private ActivityGestionBudgetBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_budget);
        revenues = findViewById(R.id.fragment1);
        depenses = findViewById(R.id.fragment2);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new fragment_revenues()).commit();


        revenues.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new fragment_revenues()).commit();


        });
        depenses.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new fragment_depenses()).commit();


        });




    }
}