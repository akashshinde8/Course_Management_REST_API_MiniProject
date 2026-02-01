//repo usually contains database-related logic.
package com.example.repo;

import java.io.Serializable;

//JpaRepository is a Spring Data JPA interface.
//It provides ready-made CRUD operations, such as:
//save()
//findById()
//findAll()
//deleteById()
//existsById()
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.binding.Course;

//it represents Repository class
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
