package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class EmployeesAssignedTaskData {
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

	@SerializedName("InitialEstimatedHours")
	private int initialEstimatedHours;

	@SerializedName("StatusId")
	private int statusId;

	@SerializedName("TaskEstimatedHours")
	private int taskEstimatedHours;

	@SerializedName("TaskHours")
	private int taskHours;

	@SerializedName("TaskRoleDescription")
	private String taskRoleDescription;

	@SerializedName("TaskRoleId")
	private int taskRoleId;

	@SerializedName("TaskStatusDescription")
	private String taskStatusDescription;

	@SerializedName("TaskStatusId")
	private int taskStatusId;

	@SerializedName("TaskTeamStatusDescription")
	private String taskTeamStatusDescription;

	@SerializedName("TaskTeamStatusId")
	private int taskTeamStatusId;

	@SerializedName("TimeInHours")
	private int timeInHours;
	public EmployeesAssignedTaskData (int creatorId, String description, int id, int initialEstimatedHours, int statusId, int taskEstimatedHours, int taskHours, String taskRoleDescription, int taskRoleId, String taskStatusDescription, int taskStatusId, String taskTeamStatusDescription, int taskTeamStatusId, int timeInHours) {
		this.creatorId = creatorId;

		this.description = description;

		this.id = id;

		this.initialEstimatedHours = initialEstimatedHours;

		this.statusId = statusId;

		this.taskEstimatedHours = taskEstimatedHours;

		this.taskHours = taskHours;

		this.taskRoleDescription = taskRoleDescription;

		this.taskRoleId = taskRoleId;

		this.taskStatusDescription = taskStatusDescription;

		this.taskStatusId = taskStatusId;

		this.taskTeamStatusDescription = taskTeamStatusDescription;

		this.taskTeamStatusId = taskTeamStatusId;

		this.timeInHours = timeInHours;
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


	public int getTaskEstimatedHours(){
		return taskEstimatedHours;
	} 
	
	public void setTaskEstimatedHours(int taskEstimatedHours){
		this.taskEstimatedHours = taskEstimatedHours ;
	} 


	public int getTaskHours(){
		return taskHours;
	} 
	
	public void setTaskHours(int taskHours){
		this.taskHours = taskHours ;
	} 


	public String getTaskRoleDescription(){
		return taskRoleDescription;
	} 
	
	public void setTaskRoleDescription(String taskRoleDescription){
		this.taskRoleDescription = taskRoleDescription ;
	} 


	public int getTaskRoleId(){
		return taskRoleId;
	} 
	
	public void setTaskRoleId(int taskRoleId){
		this.taskRoleId = taskRoleId ;
	} 


	public String getTaskStatusDescription(){
		return taskStatusDescription;
	} 
	
	public void setTaskStatusDescription(String taskStatusDescription){
		this.taskStatusDescription = taskStatusDescription ;
	} 


	public int getTaskStatusId(){
		return taskStatusId;
	} 
	
	public void setTaskStatusId(int taskStatusId){
		this.taskStatusId = taskStatusId ;
	} 


	public String getTaskTeamStatusDescription(){
		return taskTeamStatusDescription;
	} 
	
	public void setTaskTeamStatusDescription(String taskTeamStatusDescription){
		this.taskTeamStatusDescription = taskTeamStatusDescription ;
	} 


	public int getTaskTeamStatusId(){
		return taskTeamStatusId;
	} 
	
	public void setTaskTeamStatusId(int taskTeamStatusId){
		this.taskTeamStatusId = taskTeamStatusId ;
	} 


	public int getTimeInHours(){
		return timeInHours;
	} 
	
	public void setTimeInHours(int timeInHours){
		this.timeInHours = timeInHours ;
	} 

}

