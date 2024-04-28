package com.example.demo.Services;

import java.util.List;

import com.example.demo.entities.Course;
import com.example.demo.entities.Lesson;

public interface TrainerService {

	String addCourse(Course course);

	Course getCourse(int courseId);

	String addLesson(Lesson lesson);

	String saveCourse(Course course);

	List<Course> courseList();

}
