package com.shaheen.requests;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.shaheen.phototakingapp01.MainApplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Map;

/**
 * Manager for the queue
 * 
 * @author Trey Robinson
 *
 */
public class RequestManager {
	
	/**
	 * the queue :-)
	 */
    private static final String SET_COOKIE_KEY = "Set-Cookie";
    private static final String COOKIE_KEY = "Cookie";
    private static final String SESSION_COOKIE = "X-UAId";

	private static RequestQueue mRequestQueue;


	/**
	 * Nothing to see here.
	 */
	private RequestManager() {

	 // no instances
	} 

	/**
	 * @param context
	 * 			application context
	 */
	public static void init(Context context) {
		mRequestQueue = Volley.newRequestQueue(context);
        //_instance = this;

	}

	/**
	 * @return
	 * 		instance of the queue
	 * @throws
	 * 		IllegalStatException if init has not yet been called
	 */
	public static RequestQueue getRequestQueue() {
	    if (mRequestQueue != null) {
	        return mRequestQueue;
	    } else {
	        throw new IllegalStateException("Not initialized");
	    }
	}
}
