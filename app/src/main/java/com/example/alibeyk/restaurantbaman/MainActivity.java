package com.example.alibeyk.restaurantbaman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView resName;
    TextView retAbout;
    TextView restPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resName = findViewById(R.id.rest_Name);
        retAbout = findViewById(R.id.rest_About);
        restPhone = findViewById(R.id.rest_PhoneNumber);
        Api.getModelList(this, new Response.Listener<ModelRestaurant>() {
            @Override
            public void onResponse(ModelRestaurant response) {
                resName.setText(response.getName());
                retAbout.setText("درباره ما :  " + response.getAbout());
                restPhone.setText("شماره تلفن  :  " + response.getPhone());
                RecyclerView recyclerView = findViewById(R.id.RecyclerMain);
                AdapterMain adapterMain = new AdapterMain(MainActivity.this, response.getCategoryList());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                recyclerView.setAdapter(adapterMain);
                recyclerView.setLayoutManager(linearLayoutManager);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


    }
}
