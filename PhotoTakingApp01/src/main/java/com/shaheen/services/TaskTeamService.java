package com.shaheen.services;

import com.shaheen.dto.TaskTeam;
import com.shaheen.dto.PageListTaskTeam;
/**
* Created by shaheen on 11/9/2013.
*/
public class TaskTeamService extends Service<TaskTeam,PageListTaskTeam> {
	public TaskTeamService()
	{ 
		super("taskteams",TaskTeam.class,PageListTaskTeam.class);
	}
}


