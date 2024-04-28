package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Services.CommentsService;
import com.example.demo.Services.StudentService;
import com.example.demo.Services.TrainerService;
import com.example.demo.Services.UserService;
import com.example.demo.entities.Comments;
import com.example.demo.entities.Course;
import com.example.demo.entities.Lesson;
import com.example.demo.entities.Users;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
	@Autowired
	StudentService service;
	
	@Autowired
	UserService us;
	
	@Autowired
	TrainerService tService;
	
	@Autowired
	CommentsService cService;
	
	@GetMapping("/viewLesson")
	public String viewLesson(@RequestParam("lessonId") int lessonId, Model model, HttpSession session) {
	    Lesson lesson = service.getLesson(lessonId);
	    
	    // Add the complete video URL to the model
	    model.addAttribute("videoUrl", lesson.getLink());
	    
	    // Add the lesson and comments to the model
	    model.addAttribute("lesson", lesson);
	    List<Comments> commentsList = cService.commentList();
	    model.addAttribute("comments", commentsList);

	    return "myLesson";
	}

	
	@PostMapping("/addComment")
	public String comments(@RequestParam("comment")String comment
						,Model model) {
		Comments c=new Comments();
		c.setComment(comment);
		cService.addComment(c);
		
		List<Comments> commentsList=cService.commentList();
		model.addAttribute("comments",commentsList);
		
		return "myLesson";
	}

	@GetMapping("/purchase")
	public String showCourses(Model model,HttpSession session) {
		Users user = (Users) session.getAttribute("loggedInUser");

		List<Course> courseList=tService.courseList();
		model.addAttribute("courseList",courseList);
		model.addAttribute("loggedInUser",user);
		return "purchase";
	}
	
	
	@GetMapping("/fetchCourses")
	public String fetchCourses(Model model, HttpSession session) {
	    Users loggedUser = (Users) session.getAttribute("loggedInUser");

	    // Check if loggedUser is not null before accessing its properties
	    if (loggedUser != null) {
	        String email = loggedUser.getEmail();
	        Users user = us.getUser(email);

	        List<Course> courseList = user.getCourses();
	        model.addAttribute("courseList", courseList);
	    } else {
	       System.out.println("USER NOT EXISTS");
	       return "login";
	    }

	    return "myCourses";
	}

	
}
