package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
* Created by shaheen on 11/9/2013.
*/
public class PageListUrgency {

	@SerializedName("PageIndex")
	private int pageIndex;

	@SerializedName("PageSize")
	private int pageSize;

	@SerializedName("List")
	private List<Urgency> list;

	public PageListUrgency(int pageIndex, int pageSize,List<Urgency> list)
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


	public List<Urgency> getList(){
		return list;
	} 
	
	public void setList(List<Urgency> list){
		this.list = list ;
	} 
}
