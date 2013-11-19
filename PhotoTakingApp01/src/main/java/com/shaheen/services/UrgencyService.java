package com.shaheen.services;

import com.shaheen.dto.Urgency;
import com.shaheen.dto.PageListUrgency;
/**
* Created by shaheen on 11/9/2013.
*/
public class UrgencyService extends Service<Urgency,PageListUrgency> {
	public UrgencyService()
	{ 
		super("urgencies",Urgency.class,PageListUrgency.class);
	}
}


