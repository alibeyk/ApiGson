package com.maxis7567.msapirequest;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class RequestQueueContainer {
    private static RequestQueue requestQueueContainer;
    public static RequestQueue getRequestQueueContainer(Context context){
        if (requestQueueContainer==null){
            requestQueueContainer= Volley.newRequestQueue(context);
        }
        return requestQueueContainer;
    }
    public static void ResetQueue(){
        requestQueueContainer.cancelAll("reset");
    }

}
