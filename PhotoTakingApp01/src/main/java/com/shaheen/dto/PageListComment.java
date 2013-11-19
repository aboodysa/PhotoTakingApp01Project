package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
* Created by shaheen on 11/9/2013.
*/
public class PageListComment {

	@SerializedName("PageIndex")
	private int pageIndex;

	@SerializedName("PageSize")
	private int pageSize;

	@SerializedName("List")
	private List<Comment> list;

	public PageListComment(int pageIndex, int pageSize,List<Comment> list)
	{ 		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.list = list;
	}
	public int getPageIndex(){
		return pageIndex;
	} 
	
	public void setPageIndex(int pageIndex){
		this.pageIndex = pageIndex ;
	} 


	public int getPageSize(){
		return pageSize;
	} 
	
	public void setPageSize(int pageSize){
		this.pageSize = pageSize ;
	} 


	public List<Comment> getList(){
		return list;
	} 
	
	public void setList(List<Comment> list){
		this.list = list ;
	} 
}
