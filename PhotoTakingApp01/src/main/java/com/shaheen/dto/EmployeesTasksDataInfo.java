package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class EmployeesTasksDataInfo {
	@SerializedName("EmployeesTasks")
	private EmployeesAssignedTaskData employeesTasks;
	public EmployeesTasksDataInfo (EmployeesAssignedTaskData employeesTasks) {
		this.employeesTasks = employeesTasks;
	} 
	public EmployeesAssignedTaskData getEmployeesTasks(){
		return employeesTasks;
	} 
	
	public void setEmployeesTasks(EmployeesAssignedTaskData employeesTasks){
		this.employeesTasks = employeesTasks ;
	} 

}

