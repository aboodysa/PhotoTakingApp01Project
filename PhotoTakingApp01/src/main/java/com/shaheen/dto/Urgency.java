package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class Urgency {
	@SerializedName("DateCreated")
	private String dateCreated;
	@SerializedName("DateModified")
	private String dateModified;
	@SerializedName("Deleted")
	private boolean deleted;
	@SerializedName("Description")
	private String description;
	@SerializedName("Id")
	private int id;
	public Urgency (String description, int id) {
		this.description = description;

		this.id = id;
	} 
	public String getDateCreated(){
		return dateCreated;
	} 
	
	public void setDateCreated(String dateCreated){
		this.dateCreated = dateCreated ;
	} 


	public String getDateModified(){
		return dateModified;
	} 
	
	public void setDateModified(String dateModified){
		this.dateModified = dateModified ;
	} 


	public boolean getDeleted(){
		return deleted;
	} 
	
	public void setDeleted(boolean deleted){
		this.deleted = deleted ;
	} 


	public String getDescription(){
		return description;
	} 
	
	public void setDescription(String description){
		this.description = description ;
	} 


	public int getId(){
		return id;
	} 
	
	public void setId(int id){
		this.id = id ;
	} 

	}

