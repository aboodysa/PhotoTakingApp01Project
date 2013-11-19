package com.shaheen.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.shaheen.dto.Employee;
import com.shaheen.dto.PageListEmployee;
import com.shaheen.images.ImageCacheManager;
import com.shaheen.phototakingapp01.R;
import com.shaheen.services.EmployeeService;
import com.shaheen.utils.SystemConstants;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by shaheen on 11/12/13.
 */
public class EmployeeListAdapter extends ArrayAdapter<Employee> implements Response.Listener<PageListEmployee>, Response.ErrorListener
{

    private final String TAG = ((Object) this).getClass().getSimpleName();

    private static final SimpleDateFormat sdf = new SimpleDateFormat("M/d/yy h:mm a", Locale.US);

    /**
     *  The data that drives the adapter
     */
    private final List<Employee> mData;

    /**
     * The last network response containing twitter metadata
     */
    private PageListEmployee mEmployeeData;

    private boolean isLoading;


    /**
     * Flag telling us our last network call returned 0 results and we do not need to execute any new requests
     */
    private boolean moreDataToLoad;

    /**
     * @param context
     * 			The context
     *
     * 			Resource for the rows of the listview
     * @param newData
     * 			Initial dataset.
     */
    public EmployeeListAdapter(Context context, PageListEmployee newData) {
        super(context, R.layout.employee_list_item);
        mData = newData.getList();
        mEmployeeData = newData;

        moreDataToLoad = true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        ViewHolder viewHolder;


        //check to see if we need to load more data
        if(shouldLoadMoreData(mData, position) ) {
            loadMoreData();
        }

        if(v == null){
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.employee_list_item, null);

            viewHolder = new ViewHolder();
            viewHolder.employeeImage = (ImageView)v.findViewById(R.id.employeeUserImage);
            viewHolder.employeeNameTextView = (TextView)v.findViewById(R.id.employeeNameTextView);
            viewHolder.mobileTextView = (TextView)v.findViewById(R.id.mobileTextView);
            viewHolder.jobTitleTextView = (TextView)v.findViewById(R.id.jobTitleTextView);

            v.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) v.getTag();
        }

        Employee employee = mData.get(position);
        if(employee != null){
            //viewHolder.employeeImage//.setImageUrl(employee.getUserImageUrl(), ImageCacheManager.getInstance().getImageLoader());
            final ImageView networkImage = viewHolder.employeeImage;
            ImageLoader imageLoader = ImageCacheManager.getInstance().getImageLoader();
            imageLoader.get(SystemConstants.URL+"/api/files/IMG_201311316_225032.jpg?fordownload=true", ImageLoader.getImageListener(networkImage,android.R.drawable.sym_action_call,android.R.drawable.stat_notify_error));
            viewHolder.employeeNameTextView.setText(employee.toString());
            viewHolder.mobileTextView.setText(employee.getEmail());

            viewHolder.jobTitleTextView.setText(employee.getUserName()+"");
            viewHolder.destinationUrl = SystemConstants.URL;
        }
        //v.setOnCreateContextMenuListener((View.OnCreateContextMenuListener) this);
        return v;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Employee getItem(int position) {
        return mData.get(position);
    }

    private String formatDisplayDate(Date date){
        if(date != null){
            return sdf.format(date);
        }

        return "";
    }
    /**
     * Add the data to the current listview
     * @param newData
     * 			Data to be added to the listview
     */
    public void add(List<Employee> newData)
    {
        isLoading = false;
        if(!newData.isEmpty()){
            mData.addAll(newData);
            notifyDataSetChanged();
        }
    }

    /**
     * a new request.
     * @param data
     * 			Current list of data
     * @param position
     * 			Current view position
     * @return
     */
    private boolean shouldLoadMoreData(List<Employee> data, int position){
        // If showing the last set of data, request for the next set of data
        boolean scrollRangeReached = (position > (data.size() - SystemConstants.DEFAULT_PAGE_SIZE));
        return (scrollRangeReached && !isLoading && moreDataToLoad);
    }

    private void loadMoreData(){
        isLoading = true;
        Log.v(((Object) this).getClass().toString(), "Load more employees");
        EmployeeService.getInstance().getAll(mEmployeeData.getPageIndex()+1,mEmployeeData.getPageSize(),this,this);
    }




    /**
     * Viewholder for the listview row
     *
     * @author Trey Robinson
     *
     */
    static class ViewHolder{
        ImageView employeeImage;
        TextView employeeNameTextView;
        TextView mobileTextView;
        TextView jobTitleTextView;
        String destinationUrl;
    }

    @Override
    public void onResponse(PageListEmployee response) {
        if(response != null){
            mData.addAll(response.getList());
            mEmployeeData = response;

            if(mEmployeeData.getList() != null && mEmployeeData.getList().size() > 0) {
                moreDataToLoad = true;
            }
            else {
                moreDataToLoad = false;
            }

            notifyDataSetChanged();
            Log.v(TAG, "New Employees retrieved");
        }

        isLoading = false;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e(TAG, "Error retrieving additional tweets: " + error.getMessage());
        isLoading = false;
    }

}

