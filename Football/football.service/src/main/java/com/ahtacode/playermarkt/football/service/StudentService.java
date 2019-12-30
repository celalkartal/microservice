package com.ahtacode.playermarkt.football.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahtacode.playermarkt.data.entity.Student;
import com.ahtacode.playermarkt.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student getStudentName() {
		Student student = new Student();
		student.setName("Celal Kartal");
		return student;
	}

	public Student save(Student student) {
		student = studentRepository.save(student);
		return student;
	}
}
