package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class FilesResponse {
	@SerializedName("FolderResult")
	private FolderResult directory;

	@SerializedName("File")
	private FileResult file;

	@SerializedName("ResponseStatus")
	private ResponseStatus responseStatus;
	public FilesResponse (FolderResult directory, FileResult file, ResponseStatus responseStatus) {
		this.directory = directory;

		this.file = file;

		this.responseStatus = responseStatus;
	} 
	public FolderResult getDirectory(){
		return directory;
	} 
	
	public void setDirectory(FolderResult directory){
		this.directory = directory ;
	} 


	public FileResult getFile(){
		return file;
	} 
	
	public void setFile(FileResult file){
		this.file = file ;
	} 


	public ResponseStatus getResponseStatus(){
		return responseStatus;
	} 
	
	public void setResponseStatus(ResponseStatus responseStatus){
		this.responseStatus = responseStatus ;
	} 

}

