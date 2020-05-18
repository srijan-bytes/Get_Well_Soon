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
        closetime1=getIntent().getStringExtra("closetime");
        pass1=getIntent().getStringExtra("pass");
        description1=getIntent().getStringExtra("description");
        specialization1=getIntent().getStringExtra("specialization");
        location1=getIntent().getStringExtra("location");
        phone1=getIntent().getStringExtra("phone");
        email1=getIntent().getStringExtra("email");
        if(name1==null)
            name1="";
        if(degree1==null)
            degree1="";
        if(college1==null)
            college1="";
        if(fees1==null)
            fees1="";
        if(opentime1==null)
            opentime1="";
        if(closetime1==null)
            closetime1="";
        if(pass1==null)
            pass1="";
        if(description1==null)
            description1="";
        if(specialization1==null)
            specialization1="";
        if(location1==null)
            location1="";
        if(phone1==null)
            phone1="";
        if(email1==null)
            email1="";
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
        reff.child(phone1).setValue(doctor);
    }
}
