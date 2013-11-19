package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class Files {
	@SerializedName("ForDownload")
	private boolean forDownload;

	@SerializedName("Path")
	private String path;

	@SerializedName("TextContents")
	private String textContents;
	public Files (boolean forDownload, String path, String textContents) {
		this.forDownload = forDownload;

		this.path = path;

		this.textContents = textContents;
	} 
	public boolean getForDownload(){
		return forDownload;
	} 
	
	public void setForDownload(boolean forDownload){
		this.forDownload = forDownload ;
	} 


	public String getPath(){
		return path;
	} 
	
	public void setPath(String path){
		this.path = path ;
	} 


	public String getTextContents(){
		return textContents;
	} 
	
	public void setTextContents(String textContents){
		this.textContents = textContents ;
	} 

}

