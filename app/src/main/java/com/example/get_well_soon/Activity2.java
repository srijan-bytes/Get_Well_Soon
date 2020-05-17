package com.example.get_well_soon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    EditText name;
    EditText degree;
    EditText college;
    EditText fees;
    EditText opentime;
    EditText closetime;
    EditText email;
    EditText pass;
    String name1="",degree1="",college1="",fees1="",opentime1="",closetime1="",email1="",pass1="";
    Button next,previous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        name=(EditText)findViewById(R.id.name);
        degree=(EditText)findViewById(R.id.degree);
        college=(EditText)findViewById(R.id.college);
        fees=(EditText)findViewById(R.id.fees);
        opentime=(EditText)findViewById(R.id.opentime);
        closetime=(EditText)findViewById(R.id.closetime);
        email=(EditText)findViewById(R.id.mail);
        pass=(EditText)findViewById(R.id.pass);

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

        Intent intent = new Intent(getApplicationContext(), Activity4.class);
        intent.putExtra("name",name1);
        intent.putExtra("degree",degree1);
        intent.putExtra("college", college1);
        intent.putExtra("fees", fees1);
        intent.putExtra("opentime", opentime1);
        intent.putExtra("closetime", closetime1);
        intent.putExtra("email" ,email1);
        intent.putExtra("pass", pass1);


        Intent i=new Intent(this, Activity2_1.class);
        startActivity(i);
    }

    private void previous()
    {
        Intent i=new Intent(this, Activity1.class);
        startActivity(i);
    }
}
