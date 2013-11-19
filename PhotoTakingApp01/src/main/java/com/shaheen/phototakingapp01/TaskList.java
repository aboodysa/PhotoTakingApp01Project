package com.shaheen.phototakingapp01;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.shaheen.adapter.TaskListAdapter;
import com.shaheen.dto.PageListTask;
import com.shaheen.services.TaskService;
import com.shaheen.utils.SystemConstants;

public class TaskList extends Activity {

    //todo add layout id hint to string resource files
    private static final String TAG = "Task List";
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        mListView = (ListView)findViewById(R.id.taskListView);
        registerForContextMenu(mListView);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //return super.onContextItemSelected(item);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        boolean handled = false;
        switch(item.getItemId())
        {
            case R.id.openEntity:
                Log.v(TAG,String.format("open ...%d::%d"+info.position,info.id));
                break;
            case R.id.deleteEntity:
                Log.v(TAG,String.format("delete ...%d::%d"+info.position,info.id));
                break;
            //case R.id.
        }

        //notes.remove(info.position);
        //populateNotesListView();
        return handled;
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(mListView.getAdapter() == null) {
            // Get the first page
            TaskService.getInstance().getAll(0, SystemConstants.DEFAULT_PAGE_SIZE,createMyReqSuccessListener(),createMyReqErrorListener());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.emplyee_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private Response.Listener<PageListTask> createMyReqSuccessListener() {
        return new Response.Listener<PageListTask>() {
            @Override
            public void onResponse(PageListTask response) {
                Log.v(TAG, "Employees data loaded");
                mListView.setAdapter(new TaskListAdapter(TaskList.this, response));
            }
        };
    }

    private Response.ErrorListener createMyReqErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Tweet data failed to load");
            }
        };
    }

}
