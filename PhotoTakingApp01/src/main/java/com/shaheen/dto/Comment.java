package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class Comment {
	@SerializedName("ActionTypeId")
	private int actionTypeId;
	@SerializedName("CommentBody")
	private String commentBody;
	@SerializedName("CommentTitle")
	private String commentTitle;
	@SerializedName("DateCreated")
	private String dateCreated;
	@SerializedName("DateModified")
	private String dateModified;
	@SerializedName("Deleted")
	private boolean deleted;
	@SerializedName("EmployeeId")
	private int employeeId;
	@SerializedName("Id")
	private int id;
	@SerializedName("TaskId")
	private int taskId;
	@SerializedName("TaskTeamId")
	private int taskTeamId;
	public Comment (int actionTypeId, String commentBody, String commentTitle, int employeeId, int id, int taskId, int taskTeamId) {
		this.actionTypeId = actionTypeId;

		this.commentBody = commentBody;

		this.commentTitle = commentTitle;

		this.employeeId = employeeId;

		this.id = id;

		this.taskId = taskId;

		this.taskTeamId = taskTeamId;
	} 
	public int getActionTypeId(){
		return actionTypeId;
	} 
	
	public void setActionTypeId(int actionTypeId){
		this.actionTypeId = actionTypeId ;
	} 


	public String getCommentBody(){
		return commentBody;
	} 
	
	public void setCommentBody(String commentBody){
		this.commentBody = commentBody ;
	} 


	public String getCommentTitle(){
		return commentTitle;
	} 
	
	public void setCommentTitle(String commentTitle){
		this.commentTitle = commentTitle ;
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


	public int getId(){
		return id;
	} 
	
	public void setId(int id){
		this.id = id ;
	} 


	public int getTaskId(){
		return taskId;
	} 
	
	public void setTaskId(int taskId){
		this.taskId = taskId ;
	} 


	public int getTaskTeamId(){
		return taskTeamId;
	} 
	
	public void setTaskTeamId(int taskTeamId){
		this.taskTeamId = taskTeamId ;
	} 

	}

