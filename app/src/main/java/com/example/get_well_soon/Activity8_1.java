package com.example.get_well_soon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Activity8_1 extends AppCompatActivity {
    DatabaseReference reff;
    FirebaseAuth mAuth;
    TextView t1,t2,t3,t4,t5,t6;
    Button appointment,previous,home,locate;
    String number="";
    String location="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity8_1);
        reff= FirebaseDatabase.getInstance().getReference();
        mAuth=FirebaseAuth.getInstance();
        number=getIntent().getStringExtra("phone");
        t1=(TextView)findViewById(R.id.textViewspecialization);
        t2=(TextView)findViewById(R.id.textViewdescription);
        t3=(TextView)findViewById(R.id.textViewphone);
        appointment=(Button)findViewById(R.id.appointment);
        previous=(Button)findViewById(R.id.buttonprevious);
        home=(Button)findViewById(R.id.button8);
        appointment=(Button)findViewById(R.id.appointment);
        locate=(Button)findViewById(R.id.buttonlocate);
        reff.child("allahabad").child("Doctor").child(number).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue()!=null) {
                    t1.setText("Specialization: "+dataSnapshot.child("specialization").getValue().toString());
                    t2.setText("Description: "+dataSnapshot.child("description").getValue().toString());
                    t3.setText("Phone number: "+dataSnapshot.child("phone").getValue().toString());
                    location=dataSnapshot.child("location").getValue().toString();

                }
                else
                {
                    Toast.makeText(Activity8_1.this, "No user Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Activity8_1.this, "No user Found", Toast.LENGTH_SHORT).show();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity8_1.this,MainActivity.class));
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity8_1.this, Activity8.class));
            }
        });
        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity8_1.this, "Appointment made Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Activity8_1.this, MapsActivity1.class);
                i.putExtra("location",location);
                startActivity(i);
            }
        });


    }
}
