package com.example.mvvmpattern.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserRepository {

    private String url = "https://api.github.com/users";

    private Application application;

    private User[] users;

    private MutableLiveData<User[]> userMutableLiveData;

    public UserRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData getUserData() {

        if (userMutableLiveData == null){
            userMutableLiveData = new MutableLiveData<>();
        }


        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(application);


        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        users = gson.fromJson(response, User[].class);

                        // set users data
                        userMutableLiveData.setValue(users);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        // Add the request to the RequestQueue.

        queue.add(stringRequest);

        return userMutableLiveData;
    }
}
