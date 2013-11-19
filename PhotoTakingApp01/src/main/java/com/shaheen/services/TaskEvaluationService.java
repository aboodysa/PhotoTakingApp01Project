package com.shaheen.services;

import com.shaheen.dto.TaskEvaluation;
import com.shaheen.dto.PageListTaskEvaluation;
/**
* Created by shaheen on 11/9/2013.
*/
public class TaskEvaluationService extends Service<TaskEvaluation,PageListTaskEvaluation> {
	public TaskEvaluationService()
	{ 
		super("taskevaluations",TaskEvaluation.class,PageListTaskEvaluation.class);
	}
}


