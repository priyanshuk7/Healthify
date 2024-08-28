package com.example.healthify.pages;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthify.R;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderActivity extends AppCompatActivity {
    private String[][] orderDetails={};

    ListView lst;
    ArrayList list;
    HashMap<String, String>items;
    SimpleAdapter sa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order);

//        lst=findViewById(R.id.listOrders);
//
//        Database db = new Database(getApplicationContext(), "healthcare", null, 1);
//        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
//        String username =sharedPreferences.getString("username", "").toString();
//        ArrayList dbData= db.getOrderData(username);

    }
}