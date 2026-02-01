//restcontroller layer handles HTTP requests & responses.
package com.example.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.binding.Course;
import com.example.service.CourseService;
//it is a combination of @Controller & @ResponseBody
//This class handles REST APIs and returns JSON responses 
@RestController
public class CourseRestController {
	
//	Injects CourseService automatically.
	@Autowired
	private CourseService courseService;
	
//	Used to insert a new course
	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody Course course){
	String Status=courseService.upsert(course);
	return new ResponseEntity<>(Status,HttpStatus.CREATED);
	}
	
//	used to get courses by id
	@GetMapping("/course/{cid}")
	public ResponseEntity<Course> getCourse (@PathVariable Integer cid) {
	Course course = courseService.getById(cid);
	return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
//	used to get all courses
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses() {
	List<Course> allCourses = courseService.getAllCourses();
	return new ResponseEntity<>(allCourses,HttpStatus.OK);
	}
	
//	used to insert and update
	@PutMapping("/course")
	public ResponseEntity<String> updateCourse (@RequestBody Course course) {
	String status = courseService.upsert(course);
	return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
//	used to delete course	
	@DeleteMapping("/course/{cid}")
	public ResponseEntity<String> deleteCourse (@PathVariable Integer cid) {
	String status = courseService.deleteById(cid);
	return new ResponseEntity<>(status, HttpStatus.OK);
	}
}
