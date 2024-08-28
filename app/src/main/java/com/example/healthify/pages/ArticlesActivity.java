package com.example.healthify.pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthify.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ArticlesActivity extends AppCompatActivity {

    private String[][] packageArticles={
                    {"Walking Daily", "","","", "Click More Details"},
                    {"Home care of COVID-19","","","", "Click More Details"},
                    {"Stop Smoking","","","", "Click More Details"},
                    {"Menstrual Cramps", "","","", "Click More Details"},
                    {"Healthy Gut","","","", "Click More Details"}
    };
    private int[] images = {
            R.drawable.health1,
            R.drawable.health2,
            R.drawable.health3,
            R.drawable.health4,
            R.drawable.health5
    };

    HashMap<String, String> item;
    ArrayList lst;
    SimpleAdapter sa;
    ListView mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_articles);
        mylist=findViewById(R.id.listViewHA);

        lst=new ArrayList<>();
        for(int i=0; i<packageArticles.length;i++){
            item = new HashMap<String, String>();
            item.put("line1", packageArticles[i][0]);
            item.put("line2", packageArticles[i][1]);
            item.put("line3", packageArticles[i][2]);
            item.put("line4", packageArticles[i][3]);
            item.put("line5", packageArticles[i][4]);
            lst.add(item);
        }

        sa = new SimpleAdapter(this, lst,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.lime_a,R.id.lime_b,R.id.lime_c,R.id.lime_d,R.id.lime_e });
        mylist.setAdapter(sa);

        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it= new Intent(ArticlesActivity.this, ArticlesDeatils.class);
                it.putExtra("text1", packageArticles[i][0]);
                it.putExtra("text2", images[i]);
                startActivity(it);
            }
        });
    }

}