package com.example.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.binding.Course;
import com.example.repo.CourseRepository;
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public String upsert(Course course) {
		//save() internally executes upsert command
 		courseRepo.save(course);
		return "success";
	}

	@Override
	public Course getById(Integer cid) {
		//this method returns Optional object. Optional objects are intoduced in java 1.8 to avoid		
		Optional<Course>findById=courseRepo.findById(cid);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepo.findAll();
	}

	@Override
	public String deleteById(Integer cid) {
		if(courseRepo.existsById(cid)) {
			courseRepo.deleteById(cid);
			return "Delete Success";
		}else {
			return "No Record Found";
		}
	}

}
