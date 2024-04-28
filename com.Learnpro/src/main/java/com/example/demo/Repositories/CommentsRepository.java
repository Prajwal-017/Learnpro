package com.example.demo.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Integer>{


}
