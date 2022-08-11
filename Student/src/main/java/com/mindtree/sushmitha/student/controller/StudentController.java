package com.mindtree.sushmitha.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.sushmitha.student.VO.ResponseTemplate;
import com.mindtree.sushmitha.student.entity.Student;
import com.mindtree.sushmitha.student.service.StudentService;




	@RestController
	@RequestMapping("/student")
	public class StudentController {
		
		@Autowired
		StudentService studtService;
		
		@PostMapping
		public Student add(@RequestBody Student studt)
		{
			return studtService.add(studt);
		}
		
		@GetMapping
		public List<Student> listStudtt(){
			return studtService.list();
		}
		
		@GetMapping("/{studtId}")
		public ResponseTemplate studtWithCollg(@PathVariable long studtId)
		{
			return studtService.studtWithCollg(studtId);
		}
		
		@PutMapping("/{studtId}/{collgId}")
		public String updateCollege(@PathVariable long studtId,@PathVariable long collgId)
		{
			Student studt = studtService.assignCollege(studtId,collgId);
			if(studt!=null)
			{
				return studt.toString();
			}
			return "Sorry! College or Student Not Found";
		}
		
		@GetMapping("/student-with-ascname/{collg_id}")
		public List<Student> getByCollgId(@PathVariable long collg_id)
		{
			return studtService.getByCollgId(collg_id);
		}
		
		@GetMapping("/student-with-desc-age/{collg_id}")
		public List<Student> getStudentByCollegeWithDescAge(@PathVariable long collg_id)
		{
			return studtService.getStudentByCollegeWithDescAge(collg_id);
		}
	}









