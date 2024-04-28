package com.example.demo.Services;

import java.util.List;

import com.example.demo.entities.Comments;

public interface CommentsService {

	List<Comments> commentList();

	String addComment(Comments c);

}
