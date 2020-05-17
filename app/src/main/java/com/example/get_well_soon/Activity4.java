package com.example.get_well_soon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity4 extends AppCompatActivity {
        DatabaseReference reff;
    protected String name1="",degree1="",college1="",fees1="",opentime1="",closetime1="",
            email1="",pass1="",specialization1="",description1="",location1="",phone1="";
    Doctor doctor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doctor=new Doctor();
        setContentView(R.layout.activity_4);
        reff= FirebaseDatabase.getInstance().getReference().child("Doctor");
        name1=getIntent().getStringExtra("name");
        degree1=getIntent().getStringExtra("degree");
        college1=getIntent().getStringExtra("college");
        fees1=getIntent().getStringExtra("fees");
        opentime1=getIntent().getStringExtra("opentime");
        college1=getIntent().getStringExtra("closetime");
        pass1=getIntent().getStringExtra("pass");
        description1=getIntent().getStringExtra("description");
        specialization1=getIntent().getStringExtra("specialization");
        location1=getIntent().getStringExtra("location");
        phone1=getIntent().getStringExtra("phone");
        email1=getIntent().getStringExtra("email");
        doctor.setName(name1);
        doctor.setDegree(degree1);
        doctor.setCollege(college1);
        doctor.setFees(fees1);
        doctor.setOpentime(opentime1);
        doctor.setClosetime(closetime1);
        doctor.setPass(pass1);
        doctor.setDescription(description1);
        doctor.setSpecialization(specialization1);
        doctor.setLocation(location1);
        doctor.setPhone(phone1);
        doctor.setEmail(email1);
        reff.child("doctor1").setValue(doctor);
    }
}
