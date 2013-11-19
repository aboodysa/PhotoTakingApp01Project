package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class TaskEvaluationData {
	@SerializedName("DateCreated")
	private String dateCreated;

	@SerializedName("DateModified")
	private String dateModified;

	@SerializedName("Deleted")
	private boolean deleted;

	@SerializedName("EmployeeDisplayName")
	private String employeeDisplayName;

	@SerializedName("EmployeeId")
	private int employeeId;

	@SerializedName("EmployeeJobTitle")
	private String employeeJobTitle;

	@SerializedName("Grade")
	private int grade;

	@SerializedName("Id")
	private int id;

	@SerializedName("Remarks")
	private String remarks;

	@SerializedName("TaskDescription")
	private String taskDescription;

	@SerializedName("TaskId")
	private int taskId;
	public TaskEvaluationData (String employeeDisplayName, int employeeId, String employeeJobTitle, int grade, int id, String remarks, String taskDescription, int taskId) {
		this.employeeDisplayName = employeeDisplayName;

		this.employeeId = employeeId;

		this.employeeJobTitle = employeeJobTitle;

		this.grade = grade;

		this.id = id;

		this.remarks = remarks;

		this.taskDescription = taskDescription;

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


	public String getEmployeeDisplayName(){
		return employeeDisplayName;
	} 
	
	public void setEmployeeDisplayName(String employeeDisplayName){
		this.employeeDisplayName = employeeDisplayName ;
	} 


	public int getEmployeeId(){
		return employeeId;
	} 
	
	public void setEmployeeId(int employeeId){
		this.employeeId = employeeId ;
	} 


	public String getEmployeeJobTitle(){
		return employeeJobTitle;
	} 
	
	public void setEmployeeJobTitle(String employeeJobTitle){
		this.employeeJobTitle = employeeJobTitle ;
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


	public String getTaskDescription(){
		return taskDescription;
	} 
	
	public void setTaskDescription(String taskDescription){
		this.taskDescription = taskDescription ;
	} 


	public int getTaskId(){
		return taskId;
	} 
	
	public void setTaskId(int taskId){
		this.taskId = taskId ;
	} 

}

