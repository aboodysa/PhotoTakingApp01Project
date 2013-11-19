package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class TaskTeam {
	@SerializedName("DateCreated")
	private String dateCreated;
	@SerializedName("DateModified")
	private String dateModified;
	@SerializedName("Deleted")
	private boolean deleted;
	@SerializedName("EmployeeId")
	private int employeeId;
	@SerializedName("EstimatedHours")
	private int estimatedHours;
	@SerializedName("Id")
	private int id;
	@SerializedName("StatusId")
	private int statusId;
	@SerializedName("TaskId")
	private int taskId;
	@SerializedName("TaskRoleId")
	private int taskRoleId;
	@SerializedName("TimeInHours")
	private int timeInHours;
	public TaskTeam (int employeeId, int estimatedHours, int id, int statusId, int taskId, int taskRoleId, int timeInHours) {
		this.employeeId = employeeId;

		this.estimatedHours = estimatedHours;

		this.id = id;

		this.statusId = statusId;

		this.taskId = taskId;

		this.taskRoleId = taskRoleId;

		this.timeInHours = timeInHours;
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


	public int getEmployeeId(){
		return employeeId;
	} 
	
	public void setEmployeeId(int employeeId){
		this.employeeId = employeeId ;
	} 


	public int getEstimatedHours(){
		return estimatedHours;
	} 
	
	public void setEstimatedHours(int estimatedHours){
		this.estimatedHours = estimatedHours ;
	} 


	public int getId(){
		return id;
	} 
	
	public void setId(int id){
		this.id = id ;
	} 


	public int getStatusId(){
		return statusId;
	} 
	
	public void setStatusId(int statusId){
		this.statusId = statusId ;
	} 


	public int getTaskId(){
		return taskId;
	} 
	
	public void setTaskId(int taskId){
		this.taskId = taskId ;
	} 


	public int getTaskRoleId(){
		return taskRoleId;
	} 
	
	public void setTaskRoleId(int taskRoleId){
		this.taskRoleId = taskRoleId ;
	} 


	public int getTimeInHours(){
		return timeInHours;
	} 
	
	public void setTimeInHours(int timeInHours){
		this.timeInHours = timeInHours ;
	} 

	}

