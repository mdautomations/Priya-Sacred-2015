package com.spring;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Entry{	

		private static final long serialVersionUID = 1L;
		@PrimaryKey
	 	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	 	private String key;	
		@Persistent	 
		private String email;
		@Persistent	 
		private String name;	
		@Persistent	 
		private String password;
	
	    @Persistent	 
	    private String phonenumber;	   
		   
		@Persistent
		private String date;
		
		public String getname() {
			return name;
		}
		public void setname(String name) {
			this.name = name;
		}
		
		public String getemail() {
			return email;
		}
		public void setemail(String email) {
			this.email = email;
		}
		public String getpassword() {
			return password;
		}
		public void setpassword(String password) {
			this.password = password;
		}
		public String getphonenumber() {
			return phonenumber;
		}
		public void setphonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		
		public String getKey() {
			return key;
			}
		public void setKey(String key) {
			this.key = key;
		}
	}

