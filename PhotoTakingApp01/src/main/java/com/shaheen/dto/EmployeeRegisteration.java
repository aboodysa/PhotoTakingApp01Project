package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;


/**
* Created by shaheen on 11/2/13.
*/

public class EmployeeRegisteration {
	@SerializedName("AutoLogin")
	private boolean autoLogin;

	@SerializedName("DateCreated")
	private String dateCreated;

	@SerializedName("DateModified")
	private String dateModified;

	@SerializedName("DateOfBirth")
	private String dateOfBirth;

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

	@SerializedName("MiddleName")
	private String middleName;

	@SerializedName("Mobile")
	private String mobile;

	@SerializedName("Password")
	private String password;

	@SerializedName("Permissions")
	private List<String> permissions;

	@SerializedName("Roles")
	private List<String> roles;

	@SerializedName("ThirdName")
	private String thirdName;

	@SerializedName("UserName")
	private String userName;
	public EmployeeRegisteration (boolean autoLogin, String dateOfBirth, String displayName, String email, boolean enabled, String firstName, int id, int jobTitleId, String lastName, String middleName, String mobile, String password, List<String> permissions, List<String> roles, String thirdName, String userName) {
		this.autoLogin = autoLogin;

		this.dateOfBirth = dateOfBirth;

		this.displayName = displayName;

		this.email = email;

		this.enabled = enabled;

		this.firstName = firstName;

		this.id = id;

		this.jobTitleId = jobTitleId;

		this.lastName = lastName;

		this.middleName = middleName;

		this.mobile = mobile;

		this.password = password;

		this.permissions = permissions;

		this.roles = roles;

		this.thirdName = thirdName;

		this.userName = userName;
	} 
	public boolean getAutoLogin(){
		return autoLogin;
	} 
	
	public void setAutoLogin(boolean autoLogin){
		this.autoLogin = autoLogin ;
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


	public String getMiddleName(){
		return middleName;
	} 
	
	public void setMiddleName(String middleName){
		this.middleName = middleName ;
	} 


	public String getMobile(){
		return mobile;
	} 
	
	public void setMobile(String mobile){
		this.mobile = mobile ;
	} 


	public String getPassword(){
		return password;
	} 
	
	public void setPassword(String password){
		this.password = password ;
	} 


	public List<String> getPermissions(){
		return permissions;
	} 
	
	public void setPermissions(List<String> permissions){
		this.permissions = permissions ;
	} 


	public List<String> getRoles(){
		return roles;
	} 
	
	public void setRoles(List<String> roles){
		this.roles = roles ;
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

}

