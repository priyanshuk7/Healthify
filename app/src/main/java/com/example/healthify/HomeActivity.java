package com.example.healthify;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.healthify.login_Signup.LoginActivity;
import com.example.healthify.pages.ArticlesActivity;
import com.example.healthify.pages.ChatBotActivity;
import com.example.healthify.pages.FindDocActivity;
import com.example.healthify.pages.LabTestActivity;
import com.example.healthify.pages.OrderActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);


        SharedPreferences sharedPreferences = getSharedPreferences("shared prefs", Context.MODE_PRIVATE);
        String username= sharedPreferences.getString("username", "").toString();
        Toast.makeText(this, "Welcome "+username, Toast.LENGTH_SHORT).show();

        CardView exit= findViewById(R.id.cardExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity (new Intent(HomeActivity.this, LoginActivity.class));
            }
        });

        CardView labTest = findViewById(R.id.cardLabTest);
        labTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LabTestActivity.class));
            }
        });

        CardView buyMeds = findViewById(R.id.cardButMeds);
        buyMeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ChatBotActivity.class));
            }
        });

        CardView findDoc= findViewById(R.id.cardFindDoc);
        findDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, FindDocActivity.class));
            }
        });

        CardView articles = findViewById(R.id.cardHealthDoc);
        articles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ArticlesActivity.class));
            }
        });

        CardView order = findViewById(R.id.cardOrderDetails);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, OrderActivity.class));
            }
        });

    }
}