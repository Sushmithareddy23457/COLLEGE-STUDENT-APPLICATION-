package com.mindtree.sushmitha.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.sushmitha.student.entity.Student;


	@Repository
	public interface StudentRepository extends JpaRepository<Student, Long> {

		Student findById(long id);

		@Query(value="SELECT * FROM student WHERE collg_id=:collg_id ORDER BY name ASC", nativeQuery = true)
		List<Student> getByCollgId(@Param("collg_id") long collg_id);
		
		@Query(value="SELECT * FROM student WHERE collg_id=:collg_id ORDER BY age DESC", nativeQuery = true)
		List<Student> getStudentByCollegeWithDescAge(@Param("collg_id") long collg_id);
	}


