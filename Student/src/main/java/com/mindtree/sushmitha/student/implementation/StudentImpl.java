package com.mindtree.sushmitha.student.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.sushmitha.student.VO.College;
import com.mindtree.sushmitha.student.VO.ResponseTemplate;
import com.mindtree.sushmitha.student.entity.Student;
import com.mindtree.sushmitha.student.repository.StudentRepository;
import com.mindtree.sushmitha.student.service.StudentService;



	@Component
	public class StudentImpl implements StudentService {

		@Autowired
		private StudentRepository studtRepo;
		
		@Autowired
		private RestTemplate restTemplate;
		
		@Override
		public Student add(Student studt) {
			return studtRepo.save(studt);
		}

		@Override
		public List<Student> list() {
			return studtRepo.findAll();
		}

		@Override
		public Student searchById(long id) {
			return studtRepo.findById(id);
		}

		@Override
		public ResponseTemplate studtWithCollg(long studtId) {
			ResponseTemplate RT = new ResponseTemplate();
			Student  studt = studtRepo.findById(studtId);
			
			long collg_id = studt.getCollg_id();
	        College collg = restTemplate.getForObject("http://COLLEGE-SERVICE/college/"+collg_id, College.class);
			RT.setCollege(collg);
			RT.setStudent(studt);
			return RT;
		}

		@Override
		public Student assignCollege(long studtId, long collgId) {
			Student  studt = studtRepo.findById(studtId);
			College collg = restTemplate.getForObject("http://COLLEGE-SERVICE/college/"+collgId, College.class);
			if(studt==null || collg==null)
			{
				return null;
			}
			studt.setCollg_id(collgId);
			studtRepo.save(studt);
			return studt;

		}
		@Override
		public List<Student> getByCollgId(long collg_id) {
			return studtRepo.getByCollgId(collg_id);
		}

		@Override
		public List<Student> getStudentByCollegeWithDescAge(long collg_id) {
			return studtRepo.getStudentByCollegeWithDescAge(collg_id);
		}
		

}
