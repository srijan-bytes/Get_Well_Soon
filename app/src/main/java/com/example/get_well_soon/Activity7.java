package com.example.get_well_soon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Activity7 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    Button previous,next;
    TextView d1,d2,d3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7);
        previous=findViewById(R.id.b71);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous();
            }
        });

        spinner=(Spinner)findViewById(R.id.spinner71);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.specialization , android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        d1=findViewById(R.id.textView14);
        d2=findViewById(R.id.textView15);
        d3=findViewById(R.id.textView);
        Intent i=new Intent(Activity7.this, Activity8.class);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Activity7.this, Activity8.class);
                i.putExtra("phone", "8081360868");
                startActivity(i);

            }
        });
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Activity7.this, Activity8.class);
                i.putExtra("phone", "7310741353");
                startActivity(i);

            }
        });
        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Activity7.this, Activity8.class);
                i.putExtra("phone", "7007920906");
                startActivity(i);

            }
        });
    }
    private void previous()
    {

        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String s=parent.getItemAtPosition(position).toString();
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
