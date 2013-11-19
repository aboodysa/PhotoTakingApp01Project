package com.shaheen.requests;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Base64;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;
import com.shaheen.phototakingapp01.MainApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shaheen on 11/6/13.
 */

public class TokenRequest extends StringRequest {

    private static final String TAG = "Token Request";
    private String userName;
    private String password;

    public TokenRequest(int method,String userName, String password ,String url, Listener<String> listener, ErrorListener errorListener) {
        super(method, url, listener, errorListener);
        this.userName = userName;
        this.password = password;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("grant_type", "client_credentials");
        return params;
    }

    @TargetApi(Build.VERSION_CODES.FROYO)
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-type", "application/json");
        headers.put("Accept", "application/json");
        String auth = "Basic "
                + Base64.encodeToString((getUserName() + ":" + getPassword()).getBytes(),
                Base64.NO_WRAP);
        headers.put("Authorization", auth);
        return headers;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /* (non-Javadoc)
* @see com.android.volley.toolbox.StringRequest#parseNetworkResponse(com.android.volley.NetworkResponse)
*/
    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        // since we don't know which of the two underlying network vehicles
        // will Volley use, we have to handle and store session cookies manually
        MainApplication.get().checkSessionCookie(response.headers);
        Log.v(TAG,"checking session cookie");
        return super.parseNetworkResponse(response);
    }

}
