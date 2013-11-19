package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class GetAllTaskTeams {
	@SerializedName("PageIndex")
	private int pageIndex;

	@SerializedName("PageSize")
	private int pageSize;
	public GetAllTaskTeams (int pageIndex, int pageSize) {
		this.pageIndex = pageIndex;

		this.pageSize = pageSize;
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

