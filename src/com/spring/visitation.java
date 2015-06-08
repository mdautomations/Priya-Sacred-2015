package com.spring;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class visitation{	

		private static final long serialVersionUID = 1L;
		@PrimaryKey
	 	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	 	private String key;	
		@Persistent	 
		private String goal;
		@Persistent	 
		private String subjects;
		@Persistent	 
		private int count;
		
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getGoal() {
			return goal;
		}
		public void setGoal(String goal) {
			this.goal = goal;
		}
		public String getSubjects() {
			return subjects;
		}
		public void setSubjects(String subjects) {
			this.subjects = subjects;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int i) {
			this.count = i;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
	}

