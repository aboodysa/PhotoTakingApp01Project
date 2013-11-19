package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class Intializer {
	@SerializedName("Done")
	private boolean done;

	@SerializedName("Message")
	private String message;
	public Intializer (boolean done, String message) {
		this.done = done;

		this.message = message;
	} 
	public boolean getDone(){
		return done;
	} 
	
	public void setDone(boolean done){
		this.done = done ;
	} 


	public String getMessage(){
		return message;
	} 
	
	public void setMessage(String message){
		this.message = message ;
	} 

}

