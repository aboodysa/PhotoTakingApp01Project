package com.shaheen.phototakingapp01;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shaheen.dto.Employee;
import com.shaheen.dto.PageListTask;
import com.shaheen.dto.Task;
import com.shaheen.requests.GsonGetRequest;
import com.shaheen.requests.RequestManager;
import com.shaheen.services.AuthService;
import com.shaheen.services.EmployeeService;
import com.shaheen.services.TaskService;
import com.shaheen.utils.NetDateTimeAdapter;
import com.shaheen.utils.SystemConstants;
import com.shaheen.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * Created by shaheen on 11/5/13.
 */
//review string.format
//http://stackoverflow.com/questions/3695230/how-to-use-java-string-format
public class RestTest extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rest_test);
        //RequestManager.init(this);
        final EditText listEditText = (EditText) findViewById(R.id.listEditText);
        final TextView resultView1 = (TextView) findViewById(R.id.resultTextView);
        Button button = (Button) findViewById(R.id.button);
        Button addButton = (Button) findViewById(R.id.addButton);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        Button checkButton = (Button) findViewById(R.id.checkButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public static final String TAG = "Login Test";
            @Override
            public void onClick(View v) {
                AuthService authService = new AuthService("mrshaheen2012","123456");
                resultView1.setText(authService.Authenticate());
            }
        });
        checkButton.setOnClickListener(new View.OnClickListener() {
            public static final String TAG = "test login" ;

            @Override
            public void onClick(View v) {
                EmployeeService employeeService = new EmployeeService();
                //employeeService.getAll(0,1);
                employeeService.get(1,new Response.Listener<Employee>() {
                    @Override
                    public void onResponse(Employee employee) {
                        Gson g = new Gson();
                        String jsonString = g.toJson(employee);

                        Log.v(TAG, "data loaded...."+jsonString);
                        Toast.makeText(RestTest.this,"data loaded....",Toast.LENGTH_LONG).show();
                        resultView1.setText(jsonString);
                    }
                },new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                Toast.makeText(RestTest.this,volleyError.getMessage(),Toast.LENGTH_LONG).show();
                                volleyError.printStackTrace();
                                Log.v(TAG, "error data loaded" + volleyError.getCause().toString());
                            }
                        });
            }
        });
        addButton.setOnClickListener( new View.OnClickListener() {
            public static final String TAG = "Test Rest";

            @Override
            public void onClick(View v) {
                resultView1.setText("hi");

                String dotNetDate = Utils.setDateToNetDate(Calendar.getInstance().getTime(), TimeZone.getDefault());
                Log.v("Dot Net Date",dotNetDate);
                resultView1.setText(dotNetDate);


                Uri.Builder uriBuilder = Uri.parse(SystemConstants.URL+"/api/tasks").buildUpon()
                        .appendQueryParameter("format", "json");
//                        .appendQueryParameter("pageSize","1")
//                        .appendQueryParameter("pageIndex","0");
                String uri = uriBuilder.build().toString();
                Log.i(TAG, "insert or update task: uri = " + uri);
//https://android.googlesource.com/platform/frameworks/volley/+/e48f4430bfd3030350aa5ba827b449c37e2fadc9/src/com/android/volley/toolbox/JsonRequest.java
                String lisName = listEditText.getText().toString();

                Task task = new Task("1",1, lisName, 100,0, 1,1,1,2,3);
                Gson g = new Gson();
                String jsonString = g.toJson(task);
                Toast.makeText(RestTest.this,jsonString,Toast.LENGTH_LONG);
                try {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, uri, jsonObject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                try {
                                    Gson gson = new GsonBuilder().registerTypeAdapter(Date.class,
                                            new NetDateTimeAdapter()).create();
                                    Date myDate = Utils.getDateFromNetDate(jsonObject.getString("DateModified"));
                                    Toast.makeText(RestTest.this,jsonObject.getString("Description"), Toast.LENGTH_LONG).show();
                                    String jsonResult = jsonObject.toString();
                                    resultView1.setText("Id: " + jsonObject.getInt("Id") + " Date:" + myDate);
                                    Log.v(TAG, "Results are ..." + jsonResult);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                Toast.makeText(RestTest.this,volleyError.getMessage(), Toast.LENGTH_LONG).show();
                                volleyError.printStackTrace();
                                Log.v(TAG, "error data loaded" + volleyError.getCause().toString());

                            }
                        }){
                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            Map<String,String> headers = super.getHeaders();
                            if (headers == null
                                    || headers.equals(Collections.emptyMap())) {
                                headers = new HashMap<String, String>();
                            }

                            MainApplication.get().addSessionCookie(headers);
                            Log.v(TAG+":jsonObject:headers",headers.toString());
                            return headers;

                        }
                    };

                  Log.v(TAG, request.toString());

                    RequestManager.getRequestQueue().add(request);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
            button.setOnClickListener( new View.OnClickListener() {
            public static final String TAG = "Test Rest";

            @Override
            public void onClick(View v) {
                TaskService t = new TaskService();
                t.getAll(0,1);

                Uri.Builder uriBuilder = Uri.parse(SystemConstants.URL+"/api/tasks").buildUpon()
                        .appendQueryParameter("format", "json")
                        .appendQueryParameter("pageSize","1")
                        .appendQueryParameter("pageIndex","0");
                String uri = uriBuilder.build().toString();
                Log.i(TAG, "click here : uri = " + uri);
                GsonGetRequest<PageListTask> request = new GsonGetRequest<PageListTask>(Request.Method.GET
                        , uri
                        , PageListTask.class
                        , new Response.Listener<PageListTask>() {
                    @Override
                    public void onResponse(PageListTask pageList) {
                        Gson g = new Gson();
                        String jsonString = g.toJson(pageList);

                        Log.v(TAG, "data loaded...."+jsonString);
                        Toast.makeText(RestTest.this,"data loaded....",Toast.LENGTH_LONG).show();
                        //resultView1.setText(jsonString+""+Utils.getDateFromNetDate(pageList.getList().get(0).getDateCreated()));
                    }
                }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(RestTest.this,volleyError.getMessage(),Toast.LENGTH_LONG).show();
                        volleyError.printStackTrace();
                        Log.v(TAG, "error data loaded" + volleyError.getCause().toString());
                    }
                });

                RequestManager.getRequestQueue().add(request);

            }
        });

    }
}

