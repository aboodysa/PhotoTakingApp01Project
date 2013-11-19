package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class GetAllTasksByStatus {
	@SerializedName("StatusId")
	private int statusId;
	public GetAllTasksByStatus (int statusId) {
		this.statusId = statusId;
	} 
	public int getStatusId(){
		return statusId;
	} 
	
	public void setStatusId(int statusId){
		this.statusId = statusId ;
	} 

}

