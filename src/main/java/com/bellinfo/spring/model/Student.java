package com.bellinfo.spring.model;



public class Student {
	String name;
	double fees;
	String password;
	int year;
	int gpa;
	
	
	public Student(String name,String password) {
		super();
		this.name = name;
		this.fees = 0;
		this.password = password;
		this.year = 0;
		this.gpa = 0;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getGpa() {
		return gpa;
	}

	public void setGpa(int gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", fees=" + fees + ", semister=" + password + ", year=" + year + ", gpa=" + gpa
				+ "]";
	}
	

	

}
