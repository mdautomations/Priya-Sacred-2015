package com.spring;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Profile{	

		private static final long serialVersionUID = 1L;
		@PrimaryKey
	 	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	 	private String key;	
		@Persistent	 
		private String email;
		@Persistent	 
		private String Name;

		@Persistent	 
		private String gender;	
		
		@Persistent	 
		private String goal;
		
		@Persistent	 
		private String degree;
	
	    @Persistent	 
	    private String department;	   
		   
		@Persistent
		private String referal;
		@Persistent
		private String yop;
		
		@Persistent
		private String greatness;
		@Persistent
		private String syllabus;
		
		@Persistent
		private int totalCredit;

		public int getTotalCredit() {
			return totalCredit;
		}

		public void setTotalCredit(int finalCredit) {
			this.totalCredit = finalCredit;
		}

		public String getSyllabus() {
			return syllabus;
		}

		public void setSyllabus(String syllabus) {
			this.syllabus = syllabus;
		}
		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}
		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getGoal() {
			return goal;
		}

		public void setGoal(String goal) {
			this.goal = goal;
		}

		public String getDegree() {
			return degree;
		}

		public void setDegree(String degree) {
			this.degree = degree;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getReferal() {
			return referal;
		}

		public void setReferal(String referal) {
			this.referal = referal;
		}

		public String getYop() {
			return yop;
		}

		public void setYop(String yop) {
			this.yop = yop;
		}

		public String getGreatness() {
			return greatness;
		}

		public void setGreatness(String greatness) {
			this.greatness = greatness;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
					
	}

