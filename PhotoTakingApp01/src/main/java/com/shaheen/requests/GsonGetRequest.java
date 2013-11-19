package com.shaheen.requests;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.shaheen.phototakingapp01.MainApplication;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Wrapper for Volley requests to facilitate parsing of json responses. 
 * 
 * @param <T>
 */
public class GsonGetRequest<T> extends Request<T>{

    private static final int MY_SOCKET_TIMEOUT_MS = 5000;
    private static final String TAG = "Gson Request" ;
    /**
	 * Gson parser 
	 */
	private final Gson mGson;
	
	/**
	 * Class type for the response
	 */
	private final Class<T> mClass;
	
	
	/**
	 * Callback for response delivery 
	 */
	private final Listener<T> mListener;
	
	/**
     * @param method
     * 		Request type.. Method.GET etc
     * @param url
     * 		path for the requests
     * @param objectClass
* 		expected class type for the response. Used by gson for serialization.
     * @param listener
* 		handler for the response
     * @param errorListener
     */
	public GsonGetRequest(int method
            , String url
            , Class<T> objectClass
            , Listener<T> listener
            , ErrorListener errorListener) {
		
		super(method, url, errorListener);

		this.mClass = objectClass;
		this.mListener = listener;
		mGson = new Gson();
        setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
	}

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String,String> headers = super.getHeaders();

        if (headers == null
                || headers.equals(Collections.emptyMap())) {
            headers = new HashMap<String, String>();
        }
        headers.put("Accept", "application/json");
        MainApplication.get().addSessionCookie(headers);
        Log.v(TAG,"headers: "+headers.toString());
        return headers;
    }

    @Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		try {
			String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
			return Response.success(mGson.fromJson(json, mClass),
					HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (JsonSyntaxException e) {
			return Response.error(new ParseError(e));
		}
	}

	@Override
	protected void deliverResponse(T response) {
		mListener.onResponse(response);
		
	}
		
}
