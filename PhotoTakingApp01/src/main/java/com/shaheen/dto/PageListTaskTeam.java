package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
* Created by shaheen on 11/9/2013.
*/
public class PageListTaskTeam {

	@SerializedName("PageIndex")
	private int pageIndex;

	@SerializedName("PageSize")
	private int pageSize;

	@SerializedName("List")
	private List<TaskTeam> list;

	public PageListTaskTeam(int pageIndex, int pageSize,List<TaskTeam> list)
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


	public List<TaskTeam> getList(){
		return list;
	} 
	
	public void setList(List<TaskTeam> list){
		this.list = list ;
	} 
}
