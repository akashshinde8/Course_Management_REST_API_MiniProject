package com.example.service;

import java.util.List;

import com.example.binding.Course;

public interface CourseService {
	//upsert() metod is used for inserting & updating
	public String upsert(Course course);
	
//	it will give perticular record
	public Course getById(Integer cid);
	
	//it will give all existing courses
	public List<Course> getAllCourses();
	
	//it will delete the record based on id
	public String deleteById(Integer cid);
}
