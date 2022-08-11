package com.mindtree.sushmitha.college.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.sushmitha.college.VO.RequestTemplate;
import com.mindtree.sushmitha.college.VO.Student;
import com.mindtree.sushmitha.college.entity.College;
import com.mindtree.sushmitha.college.respository.CollegeRepository;
import com.mindtree.sushmitha.college.service.CollegeService;



	@Component
	public class CollegeImpl implements CollegeService {

		@Autowired
		CollegeRepository collgRepo;
		@Autowired
		RestTemplate restTemplate;
		
		@Override
		public College add(College collg) {
			return collgRepo.save(collg);
		}

		@Override
		public List<College> list() {
			return collgRepo.findAll();
		}

		@Override
		public College  update(long id, String name) {
			College  collg= collgRepo.findById(id);
			collg.setName(name);
			return collgRepo.save(collg);
		}

		@Override
		public College searchById(long id) {
			if(collgRepo.findById(id)==null)
			{
				return null;
			}
			return collgRepo.findById(id);
		}

		@Override
		public List<RequestTemplate> listWithStudt() {
			List<RequestTemplate> fullList = new ArrayList<RequestTemplate>();
			List<College> allCollg = this.list();
			Iterator<College > ir = allCollg.iterator();
			while(ir.hasNext())
			{
				College  clg = ir.next();
				ResponseEntity<Student[]> response =
						  restTemplate.getForEntity(
								  "http://STUDENT-SERVICE/student/student-with-ascname/"+clg.getId(),
						  Student[].class);
				Student[] students = response.getBody();
				List<Student> studs = Arrays.asList(students);
	 			RequestTemplate RTm = new RequestTemplate();
				RTm.setCollege(clg);
				RTm.setStudentList(studs);
				fullList.add(RTm);
			}
			return fullList;
		}

		@Override
		public RequestTemplate specificCollgStudent(long collg_id) {
			College college  = this.searchById(collg_id);
			
			ResponseEntity<Student[]> response =
					  restTemplate.getForEntity(
							  "http://STUDENT-SERVICE/student/student-with-desc-age/"+college.getId(),
					  Student[].class);
			Student[] student = response.getBody();
			List<Student> students = Arrays.asList(student);
			RequestTemplate requestTemplate = new RequestTemplate();
			
			requestTemplate.setCollege(college);
			requestTemplate.setStudentList(students);
			
			return requestTemplate;
		}

	}


