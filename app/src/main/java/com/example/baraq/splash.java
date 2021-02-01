package com.example.baraq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EasySplashScreen easySplashScreen= new EasySplashScreen(splash.this);
        easySplashScreen.withFullScreen();
        easySplashScreen.withTargetActivity(MainActivity.class);
        easySplashScreen.withSplashTimeOut(2000);
        easySplashScreen.withBackgroundColor(R.color.primaryLightColor);
        easySplashScreen.withLogo(R.mipmap.ic_launcher_round);
        View ev=easySplashScreen.create();
        setContentView(ev);
    }
}