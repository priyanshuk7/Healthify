package com.example.healthify.pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthify.R;

import java.util.ArrayList;
import java.util.HashMap;


public class DoctorDetails extends AppCompatActivity {
    private String[][] doctorDetail1 = {
            {"Dr. Ajit Singh", "Address : Gobindpur", "Exp : 4yrs", "Contact : 9865324578", "800"},
            {"Dr. Rahul Sharma", "Address : Bankmore", "Exp : 3yrs", "Contact : 8521346792", "950"},
            {"Dr. Rohit kumar", "Address : Hirapur", "Exp : 5yrs", "Contact : 9000423650", "700"},
            {"Dr. Deepak Raj", "Address : ISM Campus", "Exp : 8yrs", "Contact : 7000088521", "1000"},
            {"Dr. Jeet Lodhi", "Address : Bus Stand", "Exp : 5yrs", "Contact : 7845123692", "1800"},
    };

    private String[][] doctorDetail2 = {
            {"Dr. Manish Kumar", "Address : Hirak Road", "Exp : 3yrs", "Contact : 9865324578", "600"},
            {"Dr. Arvind Singh", "Address : Chachalani Colony", "Exp : 4yrs", "Contact : 8521346792", "950"},
            {"Dr. Vishwas Sharma", "Address : Bartand", "Exp : 5yrs", "Contact : 9000423650", "1700"},
            {"Dr. Rajat Gupta", "Address : Hirapur", "Exp : 3yrs", "Contact : 7000088521", "1100"},
            {"Dr. Manas Malviya", "Address : Ozone Galleria", "Exp : 4yrs", "Contact : 7845123692", "800"},
    };

    private String[][] doctorDetail3 = {
            {"Dr. Navjot Singh", "Address : Gobindpur", "Exp : 5yrs", "Contact : 9865324578", "800"},
            {"Dr. Rohit Raj", "Address : Hirapur", "Exp : 5yrs", "Contact : 8521346792", "900"},
            {"Dr. Avinash Sahu", "Address : Bankmore", "Exp : 5yrs", "Contact : 9000423650", "1700"},
            {"Dr. Himanshu Kumar", "Address : Bartand", "Exp : 5yrs", "Contact : 7000088521", "600"},
            {"Dr. Amrit Raj", "Address : Hirakroad", "Exp : 5yrs", "Contact : 7845123692", "1300"},
    };

    private String[][] doctorDetail4 = {
            {"Dr. Satvik Asthana", "Address : Hirapur", "Exp : 5yrs", "Contact : 9865324578", "1000"},
            {"Dr. Medha Mishra", "Address : Railays Colony", "Exp : 5yrs", "Contact : 8521346792", "500"},
            {"Dr. Pranjal Pandey", "Address : Hirapur", "Exp : 5yrs", "Contact : 9000423650", "1700"},
            {"Dr. Yatharth Sharma", "Address : City Center", "Exp : 5yrs", "Contact : 7000088521", "2000"},
            {"Dr. Anshuman Ojha", "Address : Bus Stand", "Exp : 5yrs", "Contact : 7845123692", "800"},
    };

    private String[][] doctorDetail5 = {
            {"Dr. Prem Pal", "Address : Bus Stand", "Exp : 5yrs", "Contact : 9865324578", "1100"},
            {"Dr. Vicky Singh", "Address : City Center", "Exp : 5yrs", "Contact : 8521346792", "1950"},
            {"Dr. Himanshu Panwar", "Address : Hirapur", "Exp : 5yrs", "Contact : 9000423650", "5500"},
            {"Dr. Anirudh Naik", "Address : Lal Chowk", "Exp : 5yrs", "Contact : 7000088521", "2500"},
            {"Dr. Deepika Gupta", "Address : Bankmore", "Exp : 5yrs", "Contact : 7845123692", "1700"},
    };

    TextView tv;
    Button btn;
    String[][] doctorDetails= {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        Intent it = getIntent();
        String title= it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("General Physician")==0){
            doctorDetails = doctorDetail1;
        }else if(title.compareTo("Dietician")==0){
            doctorDetails = doctorDetail2;
        }else if(title.compareTo("Dentist")==0){
            doctorDetails = doctorDetail3;
        }else if(title.compareTo("Surgeon")==0){
            doctorDetails = doctorDetail4;
        }else{
            doctorDetails = doctorDetail5;
        }


        ArrayList list = new ArrayList();
        for (int i=0;i<doctorDetails.length; i++){
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("line1", doctorDetails[i][0]);
            item.put("line2", doctorDetails[i][1]);
            item.put("line3", doctorDetails[i][2]);
            item.put("line4", doctorDetails[i][3]);
            item.put("line5", "Cons Fees: "+doctorDetails[i][4]+"/-");
            list.add(item);
        }

        SimpleAdapter sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.lime_a, R.id.lime_b, R.id.lime_c, R.id.lime_d, R.id.lime_e}
        );

        ListView lst = findViewById(R.id.ListDocDeatails);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetails.this, BookAppointement.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctorDetails[i][0]);
                it.putExtra("text3", doctorDetails[i][1]);
                it.putExtra("text4", doctorDetails[i][3]);
                it.putExtra("text5", doctorDetails[i][4]);
                startActivity(it);
            }
        });
    }
}