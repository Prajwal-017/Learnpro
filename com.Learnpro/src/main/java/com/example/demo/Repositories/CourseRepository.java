package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Course;

public interface CourseRepository extends JpaRepository<Course,Integer>{

}
