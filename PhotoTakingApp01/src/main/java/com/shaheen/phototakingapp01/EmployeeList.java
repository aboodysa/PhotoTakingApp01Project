package com.shaheen.phototakingapp01;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Build;
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
import com.shaheen.adapter.EmployeeListAdapter;
import com.shaheen.dto.Employee;
import com.shaheen.dto.PageListEmployee;
import com.shaheen.services.EmployeeService;
import com.shaheen.utils.SystemConstants;

public class EmployeeList extends Activity {

    //todo add layout id hint to string resource files
    //todo update rest service files not to show deleted one
    private static final String TAG = "Employee List";
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emplyee_list);
        mListView = (ListView)findViewById(R.id.employeesListView);
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
                Log.v(TAG,String.format("open ..."+info.position+"::"+info.id+"::"+((Employee) mListView.getAdapter().getItem(info.position)).getFirstName()+""));
                Intent editIntent = new Intent(EmployeeList.this,EmployeeActivity.class);
                editIntent.putExtra("Employee",(Employee) mListView.getAdapter().getItem(info.position));
                //editingNoteId = position;
                startActivityForResult(editIntent,1);
                break;
            case R.id.deleteEntity:
                Log.v(TAG,String.format("delete ..."+info.position+"::"+info.id+"::"+((Employee) mListView.getAdapter().getItem(info.position)).getFirstName()+""));
                EmployeeService.getInstance().delete(((Employee) mListView.getAdapter().getItem(info.position)).getId(), createMyEmployeeReqSuccessListener(), createMyReqErrorListener());
                break;
            //case R.id.
        }

        //notes.remove(info.position);
        //populateNotesListView();
        return handled;
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void onMenuDialogAdd(MenuItem item)
    {
        FragmentManager fm = getFragmentManager();
//        MyDialogFragment theFragment = new MyDialogFragment();
//
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.add(android.R.id.content, theFragment, "MyDialog");
//        ft.addToBackStack("DialogAsARegularFragment");
//        ft.commit();
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(mListView.getAdapter() == null) {
            // Get the first page
            EmployeeService.getInstance().getAll(0, SystemConstants.DEFAULT_PAGE_SIZE,createMyReqSuccessListener(),createMyReqErrorListener());
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
    private Response.Listener<PageListEmployee> createMyReqSuccessListener() {
        return new Response.Listener<PageListEmployee>() {
            @Override
            public void onResponse(PageListEmployee response) {
                Log.v(TAG, "Employees data loaded");
                mListView.setAdapter(new EmployeeListAdapter(EmployeeList.this, response));
            }
        };
    }
    private Response.Listener<Employee> createMyEmployeeReqSuccessListener() {
        return new Response.Listener<Employee>() {
            @Override
            public void onResponse(Employee response) {
                Log.v(TAG, "Employee deleted loaded");
                //mListView.setAdapter(new EmployeeListAdapter(EmployeeList.this, response));
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
