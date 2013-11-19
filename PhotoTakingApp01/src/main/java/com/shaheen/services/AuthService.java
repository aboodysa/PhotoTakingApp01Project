package com.shaheen.services;

import android.net.Uri;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.shaheen.dto.Login;
import com.shaheen.requests.RequestManager;
import com.shaheen.requests.TokenRequest;
import com.shaheen.utils.SystemConstants;

import org.json.JSONException;
import org.json.JSONObject;

/**
* Created by shaheen on 11/9/2013.
*/
public class AuthService{
    private static final String TAG = "Authenticate Service" ;
    private String username;
    private String password;
    private String result;

    public AuthService(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String Authenticate()
    {
        Uri.Builder uriBuilder = Uri.parse(SystemConstants.URL+"/api/auth").buildUpon();
        String uri = uriBuilder.build().toString();
        Log.i(TAG, "insert or update task: uri = " + uri);
        Login login = new Login("mrshaheen2012","123456");
        Log.i(TAG, "login to " + uri);
        Gson g = new Gson();
        String jsonString = g.toJson(login);
        Log.v(TAG,jsonString);
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            TokenRequest request = new TokenRequest(Request.Method.POST,"mrshaheen2012","123456", uri,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            Log.v(TAG,s);
                            result = s;
                        }
                    }
                    ,
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            volleyError.printStackTrace();
                            Log.v(TAG, "error data loaded" + volleyError.getCause().toString());

                        }
                    });

            Log.v(TAG, request.toString());

            RequestManager.getRequestQueue().add(request);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }
}


