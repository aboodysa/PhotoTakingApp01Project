package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class GetEmployeeAssignedTasksInfo {
	@SerializedName("EmployeeId")
	private int employeeId;

	@SerializedName("PageIndex")
	private int pageIndex;

	@SerializedName("PageSize")
	private int pageSize;
	public GetEmployeeAssignedTasksInfo (int employeeId, int pageIndex, int pageSize) {
		this.employeeId = employeeId;

		this.pageIndex = pageIndex;

		this.pageSize = pageSize;
	} 
	public int getEmployeeId(){
		return employeeId;
	} 
	
	public void setEmployeeId(int employeeId){
		this.employeeId = employeeId ;
	} 


	public int getPageIndex(){
		return pageIndex;
	} 
	
	public void setPageIndex(int pageIndex){
		this.pageIndex = pageIndex ;
	} 


	public int getPageSize(){
		return pageSize;
	} 
	
	public void setPageSize(int pageSize){
		this.pageSize = pageSize ;
	} 

}

