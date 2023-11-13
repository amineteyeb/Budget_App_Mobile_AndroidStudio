package com.example.mobilebudget.Activity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobilebudget.Database.AppDataBase;
import com.example.mobilebudget.R;
import com.example.mobilebudget.Session.SessionManager;

public class mainActivity extends AppCompatActivity {
    Button frg1, frg2, frg3;
    AppDataBase database;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        SessionManager sessionManager = new SessionManager(this);

        context = mainActivity.this;
        database = AppDataBase.getAppDatabase(context);
        showToast("Welcome "+sessionManager.getUserName());
        showToast(sessionManager.getUserName());
        Button buttonNavigate = findViewById(R.id.buttonNavigatetoGestionBudget);
     /*   frg2 = findViewById(R.id.fragment2);
        frg3 = findViewById(R.id.fragment3);*/
        buttonNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity.this, GestionBudget.class);
                startActivity(intent);
            }
        });

        Button buttonNavigatetostat = findViewById(R.id.buttonNavigatetoStats);
     /*   frg2 = findViewById(R.id.fragment2);
        frg3 = findViewById(R.id.fragment3);*/
        buttonNavigatetostat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity.this, StatActivity.class);
                startActivity(intent);
            }
        });
        Button buttonCategorie = findViewById(R.id.buttonCategorie);

        buttonCategorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity.this, GestionCategories.class);
                startActivity(intent);
            }
        });
        Button buttonFacture = findViewById(R.id.buttonFacture);

        buttonFacture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity.this, GestionFactures.class);
                startActivity(intent);
            }
        });

        Button buttonCompte = findViewById(R.id.buttonCompte);

        buttonCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity.this, MonCompte.class);
                startActivity(intent);
            }
        });
      /*  frg2.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new Fragment2()).commit();


        });
        frg3.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new Fragment3()).commit();


        });


*/
    }
    private void showToast(String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
