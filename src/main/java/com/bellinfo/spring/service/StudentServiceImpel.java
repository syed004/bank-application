package com.bellinfo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bellinfo.spring.model.Student;
import com.bellinfo.spring.repository.StudentRepository;





@Component
public class StudentServiceImpel implements StudentService {

	@Autowired
	StudentRepository repository;

	public void processStudentData(Student student) {
		System.out.println("this is data at service and sending to database");
		repository.persistStudentData(student);

	}

	public boolean processStudentvalidation(Student s2) {
		return repository.persistStudentvalidation(s2);
		
	}

}
