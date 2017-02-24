package com.example.faridfedora.sheypoortest;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;

import org.json.JSONArray;

/**
 * Created by faridfedora on 2/24/17.
 */

public class Server {

    private RequestQueue requestQueue;
    private static String TAG="Server";
    public Server(Context context) {

        this.requestQueue= Volley.newRequestQueue(context);

    }




    /**
     * requests movies in page
     * */
    public void getMoviesInPage(int page, Response.Listener<JSONArray> listener){
        String url=Static.API_MAIN_URL+Static.API_SHOW_INDEX+page;
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url, listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        requestQueue.add(jsonArrayRequest);
    }


}
