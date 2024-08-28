package com.example.healthify.pages;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthify.database.Database;
import com.example.healthify.R;

import java.util.ArrayList;
import java.util.HashMap;

public class CartLabActivity extends AppCompatActivity {
    TextView tvTotal;
    HashMap<String, String> item;
    SimpleAdapter sa;
    ArrayList list;
    Button btnCheckout;

    private String[][] packages = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart_lab);

        btnCheckout = findViewById(R.id.checkOutBtn);
        tvTotal = findViewById(R.id.textViewCartCost);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","").toString();

        Database db =new Database(getApplicationContext(),"healthcare",null,1);

        float totalAmount= 0;
        ArrayList dbData = db.getCartData(username,"lab");

        packages = new String[dbData.size()][];
        for(int i=0;i<packages.length;i++){
            packages[i]= new String[5];
        }

        for (int i=0;i<dbData.size();i++){
            String arrData = dbData.get(i).toString();
            String[] strData = arrData.split(java.util.regex. Pattern.quote("$"));
            packages[i][0] = strData[0];
            packages [i][4] = "Cost: "+strData[1]+"/-";
            totalAmount = totalAmount + Float.parseFloat(strData[1]);
        }

        tvTotal.setText("Total Cost : "+totalAmount);

        list = new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String ,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5",packages[i][4]);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.lime_a,R.id.lime_b,R.id.lime_c,R.id.lime_d,R.id.lime_e});
        ListView lst= findViewById(R.id.listViewCart);
        lst.setAdapter(sa);
    }
}