package com.shaheen.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.shaheen.dto.JobTitle;

import java.util.List;

/**
 * Created by shaheen on 11/12/13.
 */
//http://stackoverflow.com/questions/7498657/different-views-for-spinner-and-spinner-item
    // TODO use to string to describe object ==> implement it in your pojos
    // TODO learn how to make generic class that can help you just write single line instead of code duplication
    //use to string to describe object
public class jobTitleSpinnerAdapter extends ArrayAdapter<JobTitle> {

    // Your sent context
    private Context context;
    // Your custom values for the spinner (User)
    private List<JobTitle> values;

    public jobTitleSpinnerAdapter(Context context, int textViewResourceId,
                                  List<JobTitle> values) {
        super(context, textViewResourceId, values);
        this.context = context;
        this.values = values;
    }

    public int getCount(){
        return values.size();
    }

    public JobTitle getItem(int position){
        return values.get(position);
    }

    public long getItemId(int position){
        return position;
    }


    // And the "magic" goes here
    // This is for the "passive" state of the spinner
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // I created a dynamic TextView here, but you can reference your own  custom layout for each spinner item
        TextView label = new TextView(context);
        label.setTextColor(Color.BLACK);
        // Then you can get the current item using the values array (Users array) and the current position
        // You can NOW reference each method you has created in your bean object (User class)
        label.setText(values.get(position).toString());

        // And finally return your dynamic (or custom) view for each spinner item
        return label;
    }

    // And here is when the "chooser" is popped up
    // Normally is the same view, but you can customize it if you want
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = new TextView(context);
//            label.setTextColor(Color.BLACK);
        label.setText(values.get(position).getDescription());

        return label;
    }
}

//public class Main extends Activity {
//    // You spinner view
//    private Spinner mySpinner;
//    // Custom Spinner adapter (ArrayAdapter<User>)
//    // You can define as a private to use it in the all class
//    // This is the object that is going to do the "magic"
//    private SpinAdapter adapter;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//
//        // Create the Users array
//        // You can get this retrieving from an external source
//        User[] users = new User[2];
//
//        users[0] = new User();
//        users[0].setId(1);
//        users[0].setName("Joaquin");
//
//        users[1] = new User();
//        users[1].setId(2);
//        users[1].setName("Alberto");
//
//        // Initialize the adapter sending the current context
//        // Send the simple_spinner_item layout
//        // And finally send the Users array (Your data)
//        adapter = new SpinAdapter(Main.this,
//                android.R.layout.simple_spinner_item,
//                users);
//        mySpinner = (Spinner) findViewById(R.id.miSpinner);
//        mySpinner.setAdapter(adapter); // Set the custom adapter to the spinner
//        // You can create an anonymous listener to handle the event when is selected an spinner item
//        mySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view,
//                                       int position, long id) {
//                // Here you get the current item (a User object) that is selected by its position
//                User user = adapter.getItem(position);
//                // Here you can do the action you want to...
//                Toast.makeText(Main.this, "ID: " + user.getId() + "\nName: " + user.getName(),
//                        Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapter) {  }
//        });
//    }
//}
