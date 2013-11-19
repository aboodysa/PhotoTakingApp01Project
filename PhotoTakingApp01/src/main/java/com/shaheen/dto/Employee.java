package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


/**
* Created by shaheen on 11/2/13.
*/
//todo add employee image
//add tostring
public class Employee implements Serializable {
	@SerializedName("DateCreated")
	private String dateCreated;
	@SerializedName("DateModified")
	private String dateModified;
	@SerializedName("DateOfBirth")
	private String dateOfBirth;
	@SerializedName("Deleted")
	private boolean deleted;
	@SerializedName("DisplayName")
	private String displayName;
	@SerializedName("Email")
	private String email;
	@SerializedName("Enabled")
	private boolean enabled;
	@SerializedName("FirstName")
	private String firstName;
	@SerializedName("Id")
	private int id;
	@SerializedName("JobTitleId")
	private int jobTitleId;
	@SerializedName("LastName")
	private String lastName;
	@SerializedName("Mobile")
	private String mobile;
	@SerializedName("SecondName")
	private String secondName;
	@SerializedName("ThirdName")
	private String thirdName;
	@SerializedName("UserName")
	private String userName;
	public Employee (String dateOfBirth, String displayName, String email, boolean enabled, String firstName, int id, int jobTitleId, String lastName, String mobile, String secondName, String thirdName, String userName) {
		this.dateOfBirth = dateOfBirth;

		this.displayName = displayName;

		this.email = email;

		this.enabled = enabled;

		this.firstName = firstName;

		this.id = id;

		this.jobTitleId = jobTitleId;

		this.lastName = lastName;

		this.mobile = mobile;

		this.secondName = secondName;

		this.thirdName = thirdName;

		this.userName = userName;
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


	public String getDateOfBirth(){
		return dateOfBirth;
	} 
	
	public void setDateOfBirth(String dateOfBirth){
		this.dateOfBirth = dateOfBirth ;
	} 


	public boolean getDeleted(){
		return deleted;
	} 
	
	public void setDeleted(boolean deleted){
		this.deleted = deleted ;
	} 


	public String getDisplayName(){
		return displayName;
	} 
	
	public void setDisplayName(String displayName){
		this.displayName = displayName ;
	} 


	public String getEmail(){
		return email;
	} 
	
	public void setEmail(String email){
		this.email = email ;
	} 


	public boolean getEnabled(){
		return enabled;
	} 
	
	public void setEnabled(boolean enabled){
		this.enabled = enabled ;
	} 


	public String getFirstName(){
		return firstName;
	} 
	
	public void setFirstName(String firstName){
		this.firstName = firstName ;
	} 


	public int getId(){
		return id;
	} 
	
	public void setId(int id){
		this.id = id ;
	} 


	public int getJobTitleId(){
		return jobTitleId;
	} 
	
	public void setJobTitleId(int jobTitleId){
		this.jobTitleId = jobTitleId ;
	} 


	public String getLastName(){
		return lastName;
	} 
	
	public void setLastName(String lastName){
		this.lastName = lastName ;
	} 


	public String getMobile(){
		return mobile;
	} 
	
	public void setMobile(String mobile){
		this.mobile = mobile ;
	} 


	public String getSecondName(){
		return secondName;
	} 
	
	public void setSecondName(String secondName){
		this.secondName = secondName ;
	} 


	public String getThirdName(){
		return thirdName;
	} 
	
	public void setThirdName(String thirdName){
		this.thirdName = thirdName ;
	} 


	public String getUserName(){
		return userName;
	} 
	
	public void setUserName(String userName){
		this.userName = userName ;
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (firstName != null)
            builder.append(firstName).append(" ");
        if (secondName != null)
            builder.append(secondName).append(" ");
        if (thirdName != null)
            builder.append(thirdName).append(" ");
        if (lastName != null)
            builder.append(lastName);
        return String.format(builder.toString());
    }
}

