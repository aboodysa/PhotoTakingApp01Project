package com.shaheen.requests;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.shaheen.phototakingapp01.MainApplication;

import org.json.JSONObject;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shaheen on 11/7/13.
 */
public class MyJsonRequest extends JsonObjectRequest {
    private static final String TAG ="MyJsonRequest" ;

    public MyJsonRequest(int method, String url, JSONObject jsonRequest, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    public MyJsonRequest(String url, JSONObject jsonRequest, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(url, jsonRequest, listener, errorListener);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String,String> headers = super.getHeaders();
        if (headers == null
                || headers.equals(Collections.emptyMap())) {
            headers = new HashMap<String, String>();
        }
        headers.put("Content-type", "application/json");
        headers.put("Accept", "application/json");
        MainApplication.get().addSessionCookie(headers);

        Log.v(TAG + ":getHeaders():", headers.toString());
        return headers;

    }
}
