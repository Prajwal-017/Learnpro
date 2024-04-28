package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer>{


}
