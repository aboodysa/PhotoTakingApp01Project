package com.shaheen.services;

import com.shaheen.dto.JobTitle;
import com.shaheen.dto.PageListJobTitle;
/**
* Created by shaheen on 11/9/2013.
*/
public class JobTitleService extends Service<JobTitle,PageListJobTitle> {
	public JobTitleService()
	{ 
		super("jobtitles",JobTitle.class,PageListJobTitle.class);
	}
}


