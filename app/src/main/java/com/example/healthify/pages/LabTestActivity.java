package com.example.healthify.pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthify.R;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
    public String[][] packages=
            {
                    {"Package 1 : Full Body Checkup", "","","","1599"},
                    {"Package 2 : Complete Blood Count", "","","","1999"},
                    {"Package 3 : Blood Sugar Level Check", "","","","599"},
                    {"Package 4 : Thyroid Check", "","","","499"},
                    {"Package 5 : Blood Glucose Fasting", "","","","1999"},
            };
    public String[] packageDetails =
            {
                "Blood Glucose Fasting\n"+"Complete Hemogram\n"+
                        "HbA1c\n"+
                        "Iron Studies\n"+
                        "Kidney Function Test\n"+
                        "LDH lactate Dehydrogenase, serum\n"+
                        "Lipid Profile\n"+
                        "Liver Function Test",
                    "Complete Hemogram\n"+
                            "CRP (C Reactive Protein) Quantitative, Serum\n"+
                            "Iron Studies",
                    "Blood sugar level check",
                    "Thyroid Profile-Total (T3, T4 & TSH Ultra-sensitive)",
                    "Blood Glucose Fasting"
            };

    HashMap<String , String >items;
    ArrayList list;
    SimpleAdapter sa;
    Button goToCartBtn;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab_test);

        listView= findViewById(R.id.listViewLabT);
        goToCartBtn= findViewById(R.id.goToCartBtn);


        list = new ArrayList();
        for(int i=0;i<packages.length;i++){
            items = new HashMap<String ,String>();
            items.put("line1",packages[i][0]);
            items.put("line2",packages[i][1]);
            items.put("line3",packages[i][2]);
            items.put("line4",packages[i][3]);
            items.put("line5","Total cost : "+packages[i][4]+ "/-");
            list.add(items);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.lime_a,R.id.lime_b,R.id.lime_c,R.id.lime_d,R.id.lime_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it= new Intent(LabTestActivity.this, LabTestDeatilsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", packageDetails[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });

        goToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, CartLabActivity.class));
            }
        });
    }
}