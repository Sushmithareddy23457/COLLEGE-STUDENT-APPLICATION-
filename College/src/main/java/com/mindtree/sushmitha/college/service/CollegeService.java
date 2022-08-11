package com.mindtree.sushmitha.college.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.sushmitha.college.VO.RequestTemplate;
import com.mindtree.sushmitha.college.entity.College;




	@Service
	public interface CollegeService {
		College add(College deptm);
		List<College> list();
		College update(long id,String name);
		College searchById(long id);
		List<RequestTemplate> listWithStudt();
		RequestTemplate specificCollgStudent(long collg_id);
	}

