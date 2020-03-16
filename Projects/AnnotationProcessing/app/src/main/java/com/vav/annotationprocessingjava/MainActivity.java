package com.vav.annotationprocessingjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.vav.binder_annotations.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Log("Hello")
    public void goToHomePage(){

    }
}
