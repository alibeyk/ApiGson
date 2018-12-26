package com.example.alibeyk.restaurantbaman;

import android.content.Context;

import com.android.volley.Response;
import com.google.gson.reflect.TypeToken;
import com.maxis7567.msapirequest.GsonRequest;
import com.maxis7567.msapirequest.RequestQueueContainer;

import java.util.ArrayList;

public class Api {
    public static void getModelList (Context context, Response.Listener<ModelRestaurant> response, Response.ErrorListener errorListener){
        GsonRequest<ModelRestaurant> rq=new GsonRequest<>(GsonRequest.Method.GET,
                "http://app.hiriazi.ir/api/getMarketWithId/1",
                ModelRestaurant.class,response,errorListener);
        RequestQueueContainer.getRequestQueueContainer(context).add(rq);
    }
}
