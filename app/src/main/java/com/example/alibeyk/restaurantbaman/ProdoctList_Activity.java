package com.example.alibeyk.restaurantbaman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class ProdoctList_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prodoct_list_);
        final Category category=(Category) getIntent().getSerializableExtra("cat");

                RecyclerView recyclerView=findViewById(R.id.recycler_Prodoct);
                AdapterProdoct adapterProdoct=new AdapterProdoct(ProdoctList_Activity.this,category.getProductList());
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(ProdoctList_Activity.this,LinearLayoutManager.VERTICAL,false);
                recyclerView.setAdapter(adapterProdoct);
                recyclerView.setLayoutManager(linearLayoutManager);



    }
}
