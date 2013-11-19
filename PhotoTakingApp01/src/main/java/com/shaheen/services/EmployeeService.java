package com.shaheen.services;

import com.shaheen.dto.Employee;
import com.shaheen.dto.PageListEmployee;
/**
* Created by shaheen on 11/9/2013.
*/
public class EmployeeService extends Service<Employee,PageListEmployee> {
    private static EmployeeService instance;

    public EmployeeService()
	{ 
		super("employees",Employee.class,PageListEmployee.class);
	}
    public static EmployeeService getInstance()
    {
        if(instance == null)
            return new EmployeeService();
        else
            return instance;
    }
}


