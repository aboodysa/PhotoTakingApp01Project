package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class EmployeesTasksData {
	@SerializedName("EmployeesTasks")
	private Task employeesTasks;
	public EmployeesTasksData (Task employeesTasks) {
		this.employeesTasks = employeesTasks;
	} 
	public Task getEmployeesTasks(){
		return employeesTasks;
	} 
	
	public void setEmployeesTasks(Task employeesTasks){
		this.employeesTasks = employeesTasks ;
	} 

}

