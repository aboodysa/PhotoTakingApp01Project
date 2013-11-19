package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class GetEmployeeAssignedTasks {
	@SerializedName("EmployeeId")
	private int employeeId;
	public GetEmployeeAssignedTasks (int employeeId) {
		this.employeeId = employeeId;
	} 
	public int getEmployeeId(){
		return employeeId;
	} 
	
	public void setEmployeeId(int employeeId){
		this.employeeId = employeeId ;
	} 

}

