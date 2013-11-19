package com.shaheen.services;

import com.shaheen.dto.Task;
import com.shaheen.dto.PageListTask;
/**
* Created by shaheen on 11/9/2013.
*/
public class TaskService extends Service<Task,PageListTask> {
    private static TaskService instance;

    public TaskService()
	{ 
		super("tasks",Task.class,PageListTask.class);
	}

    public static TaskService getInstance() {
        if(instance==null)
            instance = new TaskService();
        return instance;
    }
}


