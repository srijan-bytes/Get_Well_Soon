package com.example.get_well_soon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    EditText name;
    EditText degree;
    EditText college;
    EditText fees;
    EditText opentime;
    EditText closetime;
    EditText email;
    EditText pass;
    EditText city;
    Button next,previous;
    String name1,degree1,college1,fees1,opentime1,closetime1,email1,pass1,city1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        name=(EditText)findViewById(R.id.name_doctor);
        degree=(EditText)findViewById(R.id.degree_doctor);
        college=(EditText)findViewById(R.id.college_doctor);
        fees=(EditText)findViewById(R.id.fees_doctor);
        opentime=(EditText)findViewById(R.id.opentime_doctor);
        closetime=(EditText)findViewById(R.id.closetime_doctor);
        email=(EditText)findViewById(R.id.email_doctor);
        pass=(EditText)findViewById(R.id.pass_doctor);
        city=(EditText)findViewById(R.id.city_doctor);

        next=(Button)findViewById(R.id.b22);
        previous=(Button)findViewById(R.id.b21);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });



    }
    private void next()
    {
        name1=name.getText().toString();
        degree1=degree.getText().toString();
        college1=college.getText().toString();
        fees1=fees.getText().toString();
        opentime1=opentime.getText().toString();
        closetime1=closetime.getText().toString();
        email1=email.getText().toString();
        pass1=pass.getText().toString();
        city1=city.getText().toString().trim().toLowerCase();
        Intent intent = new Intent(getApplicationContext(), Activity2_1.class);
        intent.putExtra("name",name1);
        intent.putExtra("degree",degree1);
        intent.putExtra("college", college1);
        intent.putExtra("fees", fees1);
        intent.putExtra("opentime", opentime1);
        intent.putExtra("closetime", closetime1);
        intent.putExtra("email" ,email1);
        intent.putExtra("pass", pass1);
        intent.putExtra("city", city1);

        startActivity(intent);
    }

    private void previous()
    {
        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
