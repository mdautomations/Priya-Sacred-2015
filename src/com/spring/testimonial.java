package com.spring;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class testimonial{	

		private static final long serialVersionUID = 1L;
		@PrimaryKey
	 	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	 	private String key;	
		@Persistent
		private String email;
		@Persistent
		private String name;
		@Persistent
		private String degree;
		@Persistent
		private String goal;
		@Persistent
		private String greatness;
		@Persistent
		private String electives;
		@Persistent
		private String department;
		@Persistent
		private String yop;
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
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDegree() {
			return degree;
		}
		public void setDegree(String degree) {
			this.degree = degree;
		}
		public String getGoal() {
			return goal;
		}
		public void setGoal(String goal) {
			this.goal = goal;
		}
		public String getGreatness() {
			return greatness;
		}
		public void setGreatness(String greatness) {
			this.greatness = greatness;
		}
		public String getElectives() {
			return electives;
		}
		public void setElectives(String electives) {
			this.electives = electives;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getYop() {
			return yop;
		}
		public void setYop(String yop) {
			this.yop = yop;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	}
