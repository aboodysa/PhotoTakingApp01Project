package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class GetAllTaskEvaluations {
	@SerializedName("PageIndex")
	private int pageIndex;

	@SerializedName("PageSize")
	private int pageSize;

	@SerializedName("TaskId")
	private int taskId;
	public GetAllTaskEvaluations (int pageIndex, int pageSize, int taskId) {
		this.pageIndex = pageIndex;

		this.pageSize = pageSize;

		this.taskId = taskId;
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


	public int getTaskId(){
		return taskId;
	} 
	
	public void setTaskId(int taskId){
		this.taskId = taskId ;
	} 

}

