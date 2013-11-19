package com.shaheen.services;

import com.shaheen.dto.TaskRole;
import com.shaheen.dto.PageListTaskRole;
/**
* Created by shaheen on 11/9/2013.
*/
public class TaskRoleService extends Service<TaskRole,PageListTaskRole> {
	public TaskRoleService()
	{ 
		super("taskroles",TaskRole.class,PageListTaskRole.class);
	}
}


