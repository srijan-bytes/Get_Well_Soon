package com.example.get_well_soon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Activity7_1 extends AppCompatActivity {
    Button previous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity7_1);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous();
            }
        });
        RecyclerView programmingList = (RecyclerView) findViewById(R.id.programmingList);
        programmingList.setLayoutManager(new LinearLayoutManager(this));
    }
    private void previous()
    {
        Intent i=new Intent(this, Activity7.class);
        startActivity(i);
    }
}
