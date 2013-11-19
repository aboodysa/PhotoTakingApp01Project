package com.shaheen.services;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.google.gson.Gson;
import com.shaheen.dto.FilesResponse;
import com.shaheen.images.ImageCacheManager;
import com.shaheen.requests.GsonGetRequest;
import com.shaheen.requests.MultipartRequest;
import com.shaheen.requests.MyMultipartRequest;
import com.shaheen.requests.RequestManager;
import com.shaheen.utils.SystemConstants;

import org.json.JSONObject;

import java.io.File;

/**
* Created by shaheen on 11/9/2013.
*/

//todo implement paging in files
public class FileService {
    private static final String TAG = "File Service" ;
    private final Gson mGson;
    private final String path;
    private final String base_url;
    private GsonGetRequest<FilesResponse> _myGsonGetRequest;
    private ImageRequest imageRequest;
    private static FileService instance;

    public FileService() {
        this.path = "files";
        base_url = SystemConstants.URL+"/api/"+path;
        mGson = new Gson();
    }
    public static FileService getInstance()
    {
        if(instance == null)
            instance = new FileService();
        return instance;
    }

    public void getAll(Response.Listener<FilesResponse> listener , Response.ErrorListener errorListener)
    {
        final String TAG = String.format("%s:Service.GetAll()",path);
        Log.v(TAG, "at begining");
        String url = Uri.parse(base_url).buildUpon().toString();
//                .appendQueryParameter("pageIndex",pageIndex+"")
//                .appendQueryParameter("pageSize",pageSize+"").toString();
        Log.v(TAG,"url "+url);

        _myGsonGetRequest = new GsonGetRequest<FilesResponse>(Request.Method.GET, url, FilesResponse.class,listener,errorListener);
        RequestManager.getRequestQueue().add(_myGsonGetRequest);
    }
    public void get(String fileName,Response.Listener<FilesResponse> listener , Response.ErrorListener errorListener)
    {
        final String TAG = String.format("%s:Service.Get(fileName)",path);
        Log.v(TAG, "at begining");
        String url = Uri.parse(base_url).buildUpon().toString()+"/"+fileName;
//                .appendQueryParameter("pageIndex",pageIndex+"")
//                .appendQueryParameter("pageSize",pageSize+"").toString();
        Log.v(TAG,"url "+url);

        _myGsonGetRequest = new GsonGetRequest<FilesResponse>(Request.Method.GET, url, FilesResponse.class,listener,errorListener);
        RequestManager.getRequestQueue().add(_myGsonGetRequest);
    }
    public void downloadImage(String fileName, Response.Listener<Bitmap> listener, Response.ErrorListener errorListener)
    {
        final String TAG = String.format("%s:Service.downloadImage(fileName)",path);
        Log.v(TAG, "at begining");
        String url = Uri.parse(base_url).buildUpon().toString()+"/"+fileName+"?forDownload=true";
//                .appendQueryParameter("pageIndex",pageIndex+"")
//                .appendQueryParameter("pageSize",pageSize+"").toString();
        Log.v(TAG,"url "+url);

        imageRequest = new ImageRequest(url,listener,0,0,Bitmap.Config.RGB_565,errorListener);
        RequestManager.getRequestQueue().add(imageRequest);
    }

//    final ImageView networkImage =getImageView();
//    ImageLoader imageLoader = ImageCacheManager.getInstance().getImageLoader();
//    imageLoader.get(SystemConstants.URL+"/api/files/IMG_201311316_225032.jpg?fordownload=true", ImageLoader.getImageListener(networkImage,android.R.drawable.sym_action_call,android.R.drawable.stat_notify_error));
    public void downloadImageUsingCache(String imageName, ImageView imageView)
    {
        ImageLoader imageLoader = ImageCacheManager.getInstance().getImageLoader();
        imageLoader.get(base_url+"/"+imageName+"?forDownload=true", ImageLoader.getImageListener(imageView,android.R.drawable.sym_action_call,android.R.drawable.stat_notify_error));


    }

    public void uploadImage(File f,Response.ErrorListener errorListener,Response.Listener<JSONObject> listener)
    {
        MultipartRequest mr = new MultipartRequest(SystemConstants.URL+"/api/files",errorListener,listener,f,"photo");
        RequestManager.getRequestQueue().add(mr);
    }

    public void uploadImageObject(File f,Response.ErrorListener errorListener,Response.Listener<FilesResponse> listener)
    {
        MyMultipartRequest mr = new MyMultipartRequest<FilesResponse>(SystemConstants.URL+"/api/files",FilesResponse.class,errorListener,listener,f,"photo");
        RequestManager.getRequestQueue().add(mr);
    }
}


