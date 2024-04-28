package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.CourseRepository;
import com.example.demo.Repositories.LessonRepository;
import com.example.demo.entities.Course;
import com.example.demo.entities.Lesson;

@Service
public class TrainerServiceImpl implements TrainerService{

	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	LessonRepository lessonRepo;
	
	@Override
	public String addCourse(Course course) {
		courseRepo.save(course);
		return "Course added.......!";
	}

	@Override
	public Course getCourse(int courseId) {
		return courseRepo.findById(courseId).get();
	}

	@Override
	public String addLesson(Lesson lesson) {
		lessonRepo.save(lesson);
		return "lesson added successfully!";
	}

	@Override
	public String saveCourse(Course course) {
		courseRepo.save(course);
		return "Course saved successfully!";
	}

	@Override
	public List<Course> courseList() {
		return courseRepo.findAll();
	}
}
