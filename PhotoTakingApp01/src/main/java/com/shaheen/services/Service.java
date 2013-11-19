package com.shaheen.services;

import android.net.Uri;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.shaheen.dto.Entity;
import com.shaheen.requests.GsonGetRequest;
import com.shaheen.requests.MyJsonRequest;
import com.shaheen.requests.RequestManager;
import com.shaheen.utils.SystemConstants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
* Created by shaheen on 11/7/13.
*/

public class Service<T,AllT> {

    private List<T> list;
    private  MyJsonRequest _myJsonRequest;
    private GsonGetRequest _myGsonGetRequest;
    private Class<T> tClass;
    private Class<AllT> allClass;
    private AllT _results;
    private T _result;
    private String path;
    private Gson mGson;
    private String base_url;
    //private static Service instance;


    public Service()
    {
        mGson = new Gson();
    }


    public Service(String path)
    {
        this.path = path;
        base_url = SystemConstants.URL+"/api/"+path;
        mGson = new Gson();
    }


    public Service(String path,Class<T> tClass, Class<AllT> allClass)
    {
        this.tClass = tClass;
        this.allClass = allClass;
        this.path = path;
        base_url = SystemConstants.URL+"/api/"+path;
        mGson = new Gson();

    }



    public AllT getAll(int pageIndex, int pageSize, Response.Listener<AllT> listener , Response.ErrorListener errorListener)
    {
        final String TAG = String.format("%s:Service.GetAll()",path);
        Log.v(TAG,"at begining");
        String url = Uri.parse(base_url).buildUpon()
                .appendQueryParameter("pageIndex",pageIndex+"")
                .appendQueryParameter("pageSize",pageSize+"").toString();
        Log.v(TAG,"url "+url);

        _myGsonGetRequest = new GsonGetRequest<AllT>(Request.Method.GET, url, allClass,listener,errorListener);
        RequestManager.getRequestQueue().add(_myGsonGetRequest);
        return _results;
    }
    public AllT getAll(int pageIndex, int pageSize)
    {
       final String TAG = String.format("%s:Service.GetAll()",path);
        Log.v(TAG,"at begining");
        String url = Uri.parse(base_url).buildUpon()
                .appendQueryParameter("pageIndex",pageIndex+"")
                .appendQueryParameter("pageSize",pageSize+"").toString();
        Log.v(TAG,"url "+url);

        _myGsonGetRequest = new GsonGetRequest<AllT>(Request.Method.GET, url, allClass,
                new Response.Listener<AllT>() {
                    @Override
                    public void onResponse(AllT allTResponse) {
                        Log.v(TAG, "data loaded...." +allTResponse.toString());
                        _results = allTResponse;
                    }},
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        volleyError.printStackTrace();
                        Log.v(TAG, "error during data loading..." + volleyError.getCause().toString());
                    }
                });
        RequestManager.getRequestQueue().add(_myGsonGetRequest);
        return _results;
    }
    public T get(int id,Response.Listener<T> listener , Response.ErrorListener errorListener)
    {
        final String TAG = String.format("%s:Service.Get(%d)",path,id);
        String url = base_url+"/"+id;
        _myGsonGetRequest = new GsonGetRequest<T>(Request.Method.GET, url, tClass,listener,errorListener);
        Log.v(TAG,String.format("Get id = %d with listeners as parameters",id));
        RequestManager.getRequestQueue().add(_myGsonGetRequest);
        return _result;
    }
    public T get(int id)
    {
        final String TAG = String.format("%s:Service.Get(%d)",path,id);
        String url = base_url+"/"+id;

        _myGsonGetRequest = new GsonGetRequest<T>(Request.Method.GET, url, tClass,
                new Response.Listener<T>() {
                    @Override
                    public void onResponse(T tResponse) {
                        Log.v(TAG, "data loaded...." +tResponse.toString());
                        _result = tResponse;
                    }},
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        volleyError.printStackTrace();
                        Log.v(TAG, "error data loaded" + volleyError.getCause().toString());
                    }
                });
        RequestManager.getRequestQueue().add(_myGsonGetRequest);
        return _result;
    }

    public T Post(T input)
    {
        final String TAG = String.format("%s:Service.Get(%d)",path,input.toString());
        Gson g = new Gson();
        //Entity request = new Entity(id);
        String jsonString = g.toJson(input);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            Log.v(TAG,"JsonObject Error");
            e.printStackTrace();
        }
        _myJsonRequest = new MyJsonRequest(Request.Method.POST, base_url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Gson g = new Gson();
                        String jsonString = g.toJson(jsonObject);
                        Log.v(TAG, "data loaded...." +jsonString);
                        _result = g.fromJson(jsonString,tClass);
                    }},
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        volleyError.printStackTrace();
                        Log.v(TAG, "error data loaded" + volleyError.getCause().toString());
                    }
                });
        RequestManager.getRequestQueue().add(_myJsonRequest);
        return _result;
    }

    public T Post(T input,Response.Listener<JSONObject> listener,Response.ErrorListener errorListener)
    {
        final String TAG = String.format("%s:Service.Get(%d)",path,input.toString());
        Gson g = new Gson();
        //Entity request = new Entity(id);
        String jsonString = g.toJson(input);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            Log.v(TAG,"JsonObject Error");
            e.printStackTrace();
        }
        _myJsonRequest = new MyJsonRequest(Request.Method.POST, base_url, jsonObject,
                listener,
                errorListener);
        RequestManager.getRequestQueue().add(_myJsonRequest);
        return _result;
    }
    public T Put(T input,Response.Listener<JSONObject> listener,Response.ErrorListener errorListener)
    {
        final String TAG = String.format("%s:Service.Get(%d)",path,input.toString());
        Gson g = new Gson();
        //Entity request = new Entity(id);
        String jsonString = g.toJson(input);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            Log.v(TAG,"JsonObject Error");
            e.printStackTrace();
        }
        _myJsonRequest = new MyJsonRequest(Request.Method.PUT, base_url, jsonObject,
                listener, errorListener);
        RequestManager.getRequestQueue().add(_myJsonRequest);
        return _result;
    }
    public T Put(T input)
    {
        final String TAG = String.format("%s:Service.Get(%d)",path,input.toString());
        Gson g = new Gson();
        //Entity request = new Entity(id);
        String jsonString = g.toJson(input);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            Log.v(TAG,"JsonObject Error");
            e.printStackTrace();
        }
        _myJsonRequest = new MyJsonRequest(Request.Method.PUT, base_url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Gson g = new Gson();
                        String jsonString = g.toJson(jsonObject);
                        Log.v(TAG, "data loaded...." +jsonString);
                        _result = g.fromJson(jsonString,tClass);
                    }},
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        volleyError.printStackTrace();
                        Log.v(TAG, "error data loaded" + volleyError.getCause().toString());
                    }
                });
        RequestManager.getRequestQueue().add(_myJsonRequest);
        return _result;
    }
//    http://stackoverflow.com/questions/2779251/convert-json-to-hashmap-using-gson-in-java



    public void Delete(int id)
    {
        final String TAG = String.format("%s:Service.Delete(%d)",path,id);
        Gson g = new Gson();
        Entity request = new Entity(id);
        String jsonString = g.toJson(request);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            Log.v(TAG,"JsonObject Error");
            e.printStackTrace();
        }
        _myJsonRequest = new MyJsonRequest(Request.Method.DELETE, base_url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Gson g = new Gson();
                        String jsonString = g.toJson(jsonObject);
                        Log.v(TAG, "data loaded...." +jsonString);
                    }},
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        volleyError.printStackTrace();
                        Log.v(TAG, "error data loaded" + volleyError.getCause().toString());
                    }
                });
        RequestManager.getRequestQueue().add(_myJsonRequest);
    }
    public void Delete(int id, Response.ErrorListener errorListener)
    {
        final String TAG = String.format("%s:Service.Get(%d)",path,id);
        Gson g = new Gson();
        Entity request = new Entity(id);
        String jsonString = g.toJson(request);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            Log.v(TAG,"JsonObject Error");
            e.printStackTrace();
        }
        _myJsonRequest = new MyJsonRequest(Request.Method.DELETE, base_url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Gson g = new Gson();
                        String jsonString = g.toJson(jsonObject);
                        Log.v(TAG, "data loaded...." +jsonString);
                    }},errorListener);
        RequestManager.getRequestQueue().add(_myJsonRequest);
    }
    public T delete(int id,Response.Listener<T> listener , Response.ErrorListener errorListener)
    {
        final String TAG = String.format("%s:Service.Get(%d)",path,id);
        String url = base_url+"/"+id;
        _myGsonGetRequest = new GsonGetRequest<T>(Request.Method.DELETE, url, tClass,listener,errorListener);
        Log.v(TAG,String.format("Delete id = %d with listeners as parameters",id));
        RequestManager.getRequestQueue().add(_myGsonGetRequest);
        return _result;
    }

}

//        Map<String,Object> map = new HashMap<String,Object>();
//       PageRequest request = new PageRequest(pageIndex,pageSize);
//       String jsonString = mGson.toJson(request);
//        map = mGson.fromJson(jsonString,map.getClass());
//        String url = Utils.GetUrl(base_url,map).toString();