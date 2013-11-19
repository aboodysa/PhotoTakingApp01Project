package com.shaheen.phototakingapp01;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.NetworkImageView;
import com.google.gson.Gson;
import com.shaheen.requests.MultipartRequest;
import com.shaheen.requests.RequestManager;
import com.shaheen.services.FileService;
import com.shaheen.utils.SystemConstants;
import com.shaheen.utils.Utils;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class MainActivity extends ActionBarActivity {

    private static final int PHOTO_INTENT_SIMPLE = 1000;
    private static final int PHOTO_INTENT_WITH_FILENAME = 1001;
    private static final String TAG = "Photo management";
    Uri _photoFileUri;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final NetworkImageView testImageView = (NetworkImageView) findViewById(R.id.testImage);
        Button button = (Button) findViewById(R.id.loadImageButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileService.getInstance().downloadImageUsingCache("IMG_201311316_225032.jpg",getImageView());
            }
        });
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                handleSendText(intent); // Handle text being sent
            } else if (type.startsWith("image/")) {
                handleSendImage(intent); // Handle single image being sent
            }
        } else if (Intent.ACTION_SEND_MULTIPLE.equals(action) && type != null) {
            if (type.startsWith("image/")) {
                handleSendMultipleImages(intent); // Handle multiple images being sent

            }
        } else {
            // Handle other intents, such as being started from the home screen
        }
    }
//http://stackoverflow.com/questions/9396243/how-to-save-the-image-to-sd-card-on-button-click-android

    private void handleSendMultipleImages(Intent intent) {

    }

    private void handleSendImage(Intent intent) {
        Bundle extras = intent.getExtras();

                Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
                if (imageUri != null) {
//                    Bitmap imageBitMap = BitmapFactory.decodeFile(imageUri.getPath());
                    try {
                        Bitmap imageBitMap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                        getImageView().setImageBitmap(imageBitMap);
                        Uri fileUri = Utils.generateTimeStampPhotoFileUri();
                        //Utils.s
                        Utils.saveJPGFromBitMap(imageBitMap, fileUri, MainActivity.this);
                        File f = new File(fileUri.getPath());
                        MultipartRequest mr = new MultipartRequest(SystemConstants.URL+"/api/files",
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError volleyError) {
                                        Log.v(TAG, "erorr occured while uploading image!");
                                    }
                                },
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                Gson mGson = new Gson();
                                Log.v(TAG, "uploading image succeed");
                                Log.v(TAG,jsonObject.toString());
                            }
                        },f,"photo");
                        RequestManager.getRequestQueue().add(mr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }


    }
    void takePhoto(Uri photoOut)
    {
        Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoOut);
        startActivityForResult(intent, PHOTO_INTENT_WITH_FILENAME);
    }

    private void handleSendText(Intent intent) {
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void onActivityResult(int requestCode, int resultCode, Intent resultIntent) {
        Bundle extras = null;
        Bitmap imageBitMap = null;
        imageView = getImageView();
        if(resultCode == RESULT_CANCELED)
        {
            Toast.makeText(this , "User Cancelled", Toast.LENGTH_LONG).show();
            return;
        }
        switch (requestCode)
        {
            case PHOTO_INTENT_SIMPLE:
                extras = resultIntent.getExtras();
                imageBitMap = (Bitmap) extras.get("data");
                imageView.setImageBitmap(imageBitMap);
                break;
            case PHOTO_INTENT_WITH_FILENAME:
                imageBitMap = BitmapFactory.decodeFile(_photoFileUri.getPath());
                imageView.setImageBitmap(imageBitMap);
                break;
        }
        Uri fileUri = Utils.generateTimeStampPhotoFileUri();
        try {
            Utils.saveJPGFromBitMap(imageBitMap, fileUri, MainActivity.this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File f = new File(fileUri.getPath());
        MultipartRequest mr = new MultipartRequest(SystemConstants.URL+"/api/files",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.v(TAG, "erorr occured while uploading image!");
                    }
                },
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Gson mGson = new Gson();
                        Log.v(TAG, "uploading image succeed");
                        Log.v(TAG,jsonObject.toString());
                    }
                },f,"photo");
        RequestManager.getRequestQueue().add(mr);
        //this broadcast is used to ask system to refresh as the sd card inserted again
        this.sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://"+Environment.getExternalStorageDirectory())));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            case R.id.action_get_picture:
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent,PHOTO_INTENT_SIMPLE);
                break;
            case R.id.action_take_high_quality_picture:
                _photoFileUri = Utils.generateTimeStampPhotoFileUri();
                if(_photoFileUri != null)
                    takePhoto(_photoFileUri);
                break;
            case R.id.rest_test:
                Intent intent01 = new Intent(this,RestTest.class );
                startActivity(intent01);
                Toast toast = Toast.makeText(this,"Opening restTest...",Toast.LENGTH_LONG);
                toast.show();
                break;
            case R.id.employeeList:
                Intent employeeListIntent = new Intent(this,EmployeeList.class );
                startActivity(employeeListIntent);
                Toast.makeText(this,"Opening employees...",Toast.LENGTH_LONG).show();
                break;
            case R.id.taskList:
                Intent taskListIntent = new Intent(this,TaskList.class );
                startActivity(taskListIntent);
                Toast.makeText(this,"Opening tasks...",Toast.LENGTH_LONG).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public ImageView getImageView( ) {
        if(imageView != null)
            return imageView;
        else
        return (ImageView) findViewById(R.id.imageView);
    }
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            return rootView;
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent resultIntent) {
            Bundle extras = null;
            Bitmap imageBitMap = null;
            ImageView imageView =(ImageView) getView().findViewById(R.id.imageView);
            if(resultCode == RESULT_CANCELED)
            {
                Toast.makeText(getActivity() , "User Cancelled", Toast.LENGTH_LONG).show();
                return;
            }
            switch (resultCode)
            {
                case PHOTO_INTENT_SIMPLE:
                extras = resultIntent.getExtras();
                imageBitMap = (Bitmap) extras.get("data");
                imageView.setImageBitmap(imageBitMap);
                    break;

            }
        }

    }

}
