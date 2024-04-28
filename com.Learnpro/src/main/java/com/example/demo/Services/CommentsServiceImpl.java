package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.CommentsRepository;
import com.example.demo.entities.Comments;

@Service
public class CommentsServiceImpl implements CommentsService{

	@Autowired
	CommentsRepository commentRepo;
	@Override
	public List<Comments> commentList() {
		return commentRepo.findAll();
	}

	@Override
	public String addComment(Comments comment) {
		commentRepo.save(comment);
		return "comment added";
	}

}
