package com.mindtree.sushmitha.college.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.sushmitha.college.VO.Student;
import com.mindtree.sushmitha.college.entity.College;




@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

 College findById(long id);

@Query(value="SELECT e.* FROM student e WHERE e.collg_id=:id ", nativeQuery = true)
	List<Student> studtByCollg(@Param("id") long id);
}

