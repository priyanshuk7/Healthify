package com.example.healthify.pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.healthify.HomeActivity;
import com.example.healthify.R;

public class FindDocActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_find_doc);


        CardView exit = findViewById(R.id.cardBackBtn);
        CardView familyPhysician = findViewById(R.id.cardDoc1);
        CardView dentist = findViewById(R.id.cardDoc2);
        CardView dietician = findViewById(R.id.cardDoc3);
        CardView surgeon = findViewById(R.id.cardDoc5);
        CardView cardio = findViewById(R.id.cardDoc4);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindDocActivity.this, HomeActivity.class));
            }
        });

        familyPhysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDocActivity.this, DoctorDetails.class);
                it.putExtra("title", "General Physician");
                startActivity(it);
            }
        });

        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDocActivity.this, DoctorDetails.class);
                it.putExtra("title", "Dietician");
                startActivity(it);
            }
        });

        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDocActivity.this, DoctorDetails.class);
                it.putExtra("title", "Dentist");
                startActivity(it);
            }
        });

        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDocActivity.this, DoctorDetails.class);
                it.putExtra("title", "Surgeon");
                startActivity(it);
            }
        });

        cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDocActivity.this, DoctorDetails.class);
                it.putExtra("title", "Cardio");
                startActivity(it);
            }
        });


    }
}