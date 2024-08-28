package com.example.healthify.pages;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.healthify.R;

public class ArticlesDeatils extends AppCompatActivity {

    TextView tv1;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_articles_deatils);

        tv1 = findViewById(R.id.textViewHA);
        img= findViewById(R.id.imageViewA);

        Intent intent = getIntent();
        tv1.setText(intent.getStringExtra( "text1"));
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int resId = bundle.getInt("text2");
            img.setImageResource(resId);
        }
    }
}