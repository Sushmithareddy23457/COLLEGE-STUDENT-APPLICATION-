package com.mindtree.sushmitha.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.sushmitha.student.VO.ResponseTemplate;
import com.mindtree.sushmitha.student.entity.Student;


	@Service
	public interface StudentService {
		
		Student add(Student emply);
		List<Student> list();
		Student searchById(long id);
		ResponseTemplate studtWithCollg(long studtId);
		Student assignCollege(long studtId, long collgId);
		List<Student> getByCollgId(long collg_id);
		List<Student> getStudentByCollegeWithDescAge(long collg_id);
	}

