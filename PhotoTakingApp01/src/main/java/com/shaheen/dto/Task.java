package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class Task {
	@SerializedName("BarCode")
	private String barCode;
	@SerializedName("CreatorId")
	private int creatorId;
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
	@SerializedName("ImportanceId")
	private int importanceId;
	@SerializedName("InitialEstimatedHours")
	private int initialEstimatedHours;
	@SerializedName("StatusId")
	private int statusId;
	@SerializedName("TaskCoordinator")
	private int taskCoordinator;
	@SerializedName("TimeInHours")
	private int timeInHours;
	@SerializedName("UrgencyId")
	private int urgencyId;
	public Task (String barCode, int creatorId, String description, int id, int importanceId, int initialEstimatedHours, int statusId, int taskCoordinator, int timeInHours, int urgencyId) {
		this.barCode = barCode;

		this.creatorId = creatorId;

		this.description = description;

		this.id = id;

		this.importanceId = importanceId;

		this.initialEstimatedHours = initialEstimatedHours;

		this.statusId = statusId;

		this.taskCoordinator = taskCoordinator;

		this.timeInHours = timeInHours;

		this.urgencyId = urgencyId;
	} 
	public String getBarCode(){
		return barCode;
	} 
	
	public void setBarCode(String barCode){
		this.barCode = barCode ;
	} 


	public int getCreatorId(){
		return creatorId;
	} 
	
	public void setCreatorId(int creatorId){
		this.creatorId = creatorId ;
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


	public int getImportanceId(){
		return importanceId;
	} 
	
	public void setImportanceId(int importanceId){
		this.importanceId = importanceId ;
	} 


	public int getInitialEstimatedHours(){
		return initialEstimatedHours;
	} 
	
	public void setInitialEstimatedHours(int initialEstimatedHours){
		this.initialEstimatedHours = initialEstimatedHours ;
	} 


	public int getStatusId(){
		return statusId;
	} 
	
	public void setStatusId(int statusId){
		this.statusId = statusId ;
	} 


	public int getTaskCoordinator(){
		return taskCoordinator;
	} 
	
	public void setTaskCoordinator(int taskCoordinator){
		this.taskCoordinator = taskCoordinator ;
	} 


	public int getTimeInHours(){
		return timeInHours;
	} 
	
	public void setTimeInHours(int timeInHours){
		this.timeInHours = timeInHours ;
	} 


	public int getUrgencyId(){
		return urgencyId;
	} 
	
	public void setUrgencyId(int urgencyId){
		this.urgencyId = urgencyId ;
	} 

	}

