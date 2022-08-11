package com.mindtree.sushmitha.student.VO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int totalStudents;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int gettotalStudents() {
		return totalStudents;
	}
	public void settotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}
	public College(String name, int totalStudents) {
		super();
		this.name = name;
		this.totalStudents = totalStudents;
	}
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}


