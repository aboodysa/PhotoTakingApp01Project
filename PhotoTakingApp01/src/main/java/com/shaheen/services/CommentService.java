package com.shaheen.services;

import com.shaheen.dto.Comment;
import com.shaheen.dto.PageListComment;
/**
* Created by shaheen on 11/9/2013.
*/
public class CommentService extends Service<Comment,PageListComment> {
	public CommentService()
	{ 
		super("comments",Comment.class,PageListComment.class);
	}
}


