package com.example.serverandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.serverandroid.AllViewPager.ViewPgaerLogin;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class LoginApp extends AppCompatActivity {
    ViewPgaerLogin viewPgaerLogin;
    private ViewPager2 Vp_Login;
    private TabLayout tb_Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_app);
        Vp_Login=findViewById(R.id.Vp_Login);
        tb_Login=findViewById(R.id.Tb_Login);
        viewPgaerLogin=new ViewPgaerLogin(this);
        Vp_Login.setAdapter(viewPgaerLogin);
        new TabLayoutMediator(tb_Login, Vp_Login, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Login");
                        break;
                    case 1:
                        tab.setText("Register");
                        break;
                }
            }
        }).attach();
    }
    }
