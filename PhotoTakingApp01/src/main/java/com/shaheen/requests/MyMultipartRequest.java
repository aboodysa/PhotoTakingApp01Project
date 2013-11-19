package com.shaheen.requests;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.shaheen.phototakingapp01.MainApplication;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ch.boye.httpclientandroidlib.entity.mime.MultipartEntity;
import ch.boye.httpclientandroidlib.entity.mime.content.FileBody;
import ch.boye.httpclientandroidlib.entity.mime.content.StringBody;

/**
 * Created by shaheen on 10/30/13.
 */
public class MyMultipartRequest<T> extends Request<T> {

    private static final String TAG = "MyMultipartRequest" ;
    private MultipartEntity entity = new MultipartEntity();

    private static final String FILE_PART_NAME = "file";
    private static final String STRING_PART_NAME = "text";

    /**
     * Class type for the response
     */
    private final Class<T> mClass;

    private final Response.Listener<T> mListener;
    private final File mFilePart;
    private final String mStringPart;
    private Gson mGson;

    public MyMultipartRequest(String url, Class<T> objectClass ,Response.ErrorListener errorListener, Response.Listener<T> listener, File file, String stringPart)
    {
        super(Method.POST, url, errorListener);
        mClass = objectClass;
        mListener = listener;
        mFilePart = file;
        mStringPart = stringPart;
        buildMultipartEntity();
    }

    private void buildMultipartEntity()
    {
        entity.addPart(FILE_PART_NAME, new FileBody(mFilePart));
        try
        {
            entity.addPart(STRING_PART_NAME, new StringBody(mStringPart));
        }
        catch (UnsupportedEncodingException e)
        {
            VolleyLog.e("UnsupportedEncodingException");
        }
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
        Log.v(TAG + ":getHeaders():", headers.toString());
        return headers;
    }

    @Override
    public String getBodyContentType()
    {
        return entity.getContentType().getValue();
    }

    @Override
    public byte[] getBody() throws AuthFailureError
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try
        {
            entity.writeTo(bos);
        }
        catch (IOException e)
        {
            VolleyLog.e("IOException writing to ByteArrayOutputStream");
        }
        return bos.toByteArray();
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response)
    {
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
