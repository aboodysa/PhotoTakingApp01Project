package com.shaheen.services;

import com.shaheen.dto.Status;
import com.shaheen.dto.PageListStatus;
/**
* Created by shaheen on 11/9/2013.
*/
public class StatusService extends Service<Status,PageListStatus> {
	public StatusService()
	{ 
		super("statuses",Status.class,PageListStatus.class);
	}
}


