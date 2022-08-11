package com.mindtree.sushmitha.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.sushmitha.college.VO.RequestTemplate;
import com.mindtree.sushmitha.college.entity.College;
import com.mindtree.sushmitha.college.service.CollegeService;




	@RestController
	@RequestMapping("/college")
	public class CollegeController {
		
		@Autowired
		CollegeService collgService;
		
		@PostMapping
		public College add(@RequestBody College collg)
		{
			return collgService.add(collg);
		}
		
		@GetMapping
		public List<College> list()
		{
			return collgService.list();
		}
		
		@GetMapping("/{id}")
		public College searchById(@PathVariable long id)
		{
			return collgService.searchById(id);
		}
		
		@GetMapping("/all-college-student")
		public List<RequestTemplate> listWithStudt()
		{
			return collgService.listWithStudt();
		}
		
		@GetMapping("/college-with-student/{collg_id}")
		public RequestTemplate specificCollgStudt(@PathVariable long Collg_id)
		{
			return collgService.specificCollgStudent(Collg_id);
		}
		
		
	}





