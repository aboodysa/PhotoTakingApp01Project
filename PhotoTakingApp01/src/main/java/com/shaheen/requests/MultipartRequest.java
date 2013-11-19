package com.shaheen.requests;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.shaheen.phototakingapp01.MainApplication;

import org.json.JSONException;
import org.json.JSONObject;

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
public class MultipartRequest extends Request<JSONObject> {

    private static final String TAG = "MultipartRequest" ;
    private MultipartEntity entity = new MultipartEntity();

    private static final String FILE_PART_NAME = "file";
    private static final String STRING_PART_NAME = "text";

    private final Response.Listener<JSONObject> mListener;
    private final File mFilePart;
    private final String mStringPart;

    public MultipartRequest(String url, Response.ErrorListener errorListener, Response.Listener<JSONObject> listener, File file, String stringPart)
    {
        super(Method.POST, url, errorListener);

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
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response)
    {
        String resp = new String(response.data);
        Log.d(TAG,String.format("response string %s",resp));
        JSONObject resultJson;
        try {
            resultJson = new JSONObject(resp);
        } catch (Exception e) {
            VolleyLog.e("ERROR", e.getMessage());
            return null;
        }
        try {
            Log.d(TAG,String.format("file %s uploaded successfully!",resultJson.getJSONObject("File").get("Name")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Response.success(resultJson, getCacheEntry());
    }

    @Override
    protected void deliverResponse(JSONObject response)
    {
        mListener.onResponse(response);
    }
}
