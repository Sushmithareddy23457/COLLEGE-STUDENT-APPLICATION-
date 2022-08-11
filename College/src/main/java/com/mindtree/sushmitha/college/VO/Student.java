package com.mindtree.sushmitha.college.VO;

public class Student {
	
		private long rollNumber;
		private String name;
		private String gender;
		private int age;
		private long collg_id;
		
		public long getrollNumber() {
			return rollNumber;
		}
		public void setrollNumber(long rollNumber) {
			this.rollNumber = rollNumber;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public long getCollg_id() {
			return collg_id;
		}
		public void setCollg_id(long collg_id) {
			this.collg_id = collg_id;
		}

		public Student(String name, String gender, int age, long collg_id) {
			super();
			this.name = name;
			this.gender = gender;
			this.age = age;
			this.collg_id = collg_id;
		}
		public Student() {
			super();
		}
}


