package com.example.serverandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.serverandroid.Model.UsersModel;

public class DetailAcoout extends AppCompatActivity {
    UsersModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_acoout);
        savedInstanceState=getIntent().getExtras();
        model= (UsersModel) savedInstanceState.getSerializable("user");
        Log.d("TAG", "onCreate: "+model.getUsername());
        TextView tvname=findViewById(R.id.UserName);
        TextView tvEmail=findViewById(R.id.Email);
        tvname.setText(model.getUsername());
        tvEmail.setText(model.getEmail());
    }
}