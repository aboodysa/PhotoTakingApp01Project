package com.shaheen.phototakingapp01;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.shaheen.dto.Employee;
import com.shaheen.utils.Utils;

import java.io.Serializable;

/**
 * Created by shaheen on 11/17/13.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class EmployeeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_layout);
        TextView dateOfBirth = (TextView) findViewById(R.id.dateOfBirthTextView);
        EditText displayNameEditText = (EditText) findViewById(R.id.displayNameEditText);
        EditText emailEditText = (EditText) findViewById(R.id.emailEditText);
        CheckBox enabledCheckBox = (CheckBox) findViewById(R.id.enabledCheckBox);
        EditText firstNameEditText = (EditText) findViewById(R.id.firstNameEditText);
        EditText idEditText = (EditText) findViewById(R.id.idEditText);
        EditText lastNameEditText = (EditText) findViewById(R.id.lastNameEditText);
//        <Spinner
//        android:layout_width="wrap_content"
//        android:layout_height="wrap_content"
//        android:id="@+id/jobTitleIdSpinner" />


        EditText mobileEditText = (EditText) findViewById(R.id.mobileEditText);

        EditText secondNameEditText = (EditText) findViewById(R.id.secondNameEditText);

        EditText thirdNameEditText = (EditText) findViewById(R.id.thirdNameEditText);

        EditText userNameEditText = (EditText) findViewById(R.id.userNameEditText);

        Serializable extra = getIntent().getSerializableExtra("Employee");
        if(extra != null)
        {
            Employee employee = (Employee) extra;
            dateOfBirth.setText(Utils.getDateFromNetDate(employee.getDateOfBirth()).toString());
            displayNameEditText.setText(employee.getDisplayName());
            emailEditText.setText(employee.getEmail());
            enabledCheckBox.setEnabled(employee.getEnabled());
            firstNameEditText.setText(employee.getFirstName());
            idEditText.setText(employee.getId());
            lastNameEditText.setText(employee.getLastName());
            mobileEditText.setText(employee.getMobile());
            secondNameEditText.setText(employee.getSecondName());
            thirdNameEditText.setText(employee.getThirdName());
            userNameEditText.setText(employee.getUserName());
        }

    }

}
