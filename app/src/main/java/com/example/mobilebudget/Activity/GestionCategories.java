package com.example.mobilebudget.Activity;

import android.os.Bundle;

import com.example.mobilebudget.Fragments.CategorieRevenues;
import com.example.mobilebudget.Fragments.categorie_depenses;
import com.example.mobilebudget.Fragments.fragment_depenses;
import com.example.mobilebudget.Fragments.fragment_revenues;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mobilebudget.databinding.ActivityGestionCategoriesBinding;

import com.example.mobilebudget.R;

public class GestionCategories extends AppCompatActivity {
    Button revenues, depenses ;
    private AppBarConfiguration appBarConfiguration;
    private ActivityGestionCategoriesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gestion_categories);
        revenues = findViewById(R.id.frag1);
        depenses = findViewById(R.id.frag2);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new CategorieRevenues()).commit();


        revenues.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new CategorieRevenues()).commit();


        });
        depenses.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new categorie_depenses()).commit();


        });

     /*   NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_gestion_categories);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_gestion_categories);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();*/
    }
}