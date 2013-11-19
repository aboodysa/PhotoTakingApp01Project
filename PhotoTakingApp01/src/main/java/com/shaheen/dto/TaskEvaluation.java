package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class TaskEvaluation {
	@SerializedName("DateCreated")
	private String dateCreated;
	@SerializedName("DateModified")
	private String dateModified;
	@SerializedName("Deleted")
	private boolean deleted;
	@SerializedName("EmployeeId")
	private int employeeId;
	@SerializedName("Grade")
	private int grade;
	@SerializedName("Id")
	private int id;
	@SerializedName("Remarks")
	private String remarks;
	@SerializedName("TaskId")
	private int taskId;
	public TaskEvaluation (int employeeId, int grade, int id, String remarks, int taskId) {
		this.employeeId = employeeId;

		this.grade = grade;

		this.id = id;

		this.remarks = remarks;

		this.taskId = taskId;
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


	public int getGrade(){
		return grade;
	} 
	
	public void setGrade(int grade){
		this.grade = grade ;
	} 


	public int getId(){
		return id;
	} 
	
	public void setId(int id){
		this.id = id ;
	} 


	public String getRemarks(){
		return remarks;
	} 
	
	public void setRemarks(String remarks){
		this.remarks = remarks ;
	} 


	public int getTaskId(){
		return taskId;
	} 
	
	public void setTaskId(int taskId){
		this.taskId = taskId ;
	} 

	}

