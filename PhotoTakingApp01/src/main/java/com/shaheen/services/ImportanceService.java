package com.shaheen.services;

import com.shaheen.dto.Importance;
import com.shaheen.dto.PageListImportance;
/**
* Created by shaheen on 11/9/2013.
*/
public class ImportanceService extends Service<Importance,PageListImportance> {
	public ImportanceService()
	{ 
		super("importances",Importance.class,PageListImportance.class);
	}
}


