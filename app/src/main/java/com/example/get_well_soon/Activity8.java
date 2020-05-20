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

public class Activity8 extends AppCompatActivity {

    DatabaseReference reff;
    FirebaseAuth mAuth;
    TextView t1,t2,t3,t4,t5,t6;
    Button next;
    String number="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_8);
        reff= FirebaseDatabase.getInstance().getReference();
        mAuth=FirebaseAuth.getInstance();
         number=getIntent().getStringExtra("phone");
        t1=(TextView)findViewById(R.id.textView4);
        t2=(TextView)findViewById(R.id.textView5);
        t3=(TextView)findViewById(R.id.textView6);
        t4=(TextView)findViewById(R.id.textView7);
        t5=(TextView)findViewById(R.id.textView8);
        t6=(TextView)findViewById(R.id.textView9);
        next=(Button)findViewById(R.id.button4);
        reff.child("allahabad").child("Doctor").child(number).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue()!=null) {
                                t1.setText("Name: "+dataSnapshot.child("name").getValue().toString());
                    t2.setText("Degree: "+dataSnapshot.child("degree").getValue().toString());
                    t3.setText("College: "+dataSnapshot.child("college").getValue().toString());
                    t4.setText("Expenses "+dataSnapshot.child("fees").getValue().toString());
                    t5.setText("Opentime: "+dataSnapshot.child("opentime").getValue().toString());
                    t6.setText("Closetime: "+dataSnapshot.child("closetime").getValue().toString());

                }
                else
                {
                    Toast.makeText(Activity8.this, "No user Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Activity8.this, "No user Found", Toast.LENGTH_SHORT).show();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity8.this, Activity8_1.class);
                intent.putExtra("phone",number);
                        startActivity(intent);
            }
        });
    }
}
