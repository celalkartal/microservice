package com.ahtacode.playermarkt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahtacode.playermarkt.converter.StudentConverter;
import com.ahtacode.playermarkt.data.dto.StudentDTO;
import com.ahtacode.playermarkt.data.entity.Student;
import com.ahtacode.playermarkt.football.service.StudentService;

@RestController
@RequestMapping("/rest/student")
public class StudentContoller {

	@Autowired
	StudentService studentService;
	@Autowired StudentConverter  studentConverter;

	@GetMapping("/{id}")
	public StudentDTO getById(@PathVariable("id") long id) {
		Student student = studentService.getStudentName();
		StudentDTO dto = studentConverter.convert(student);
		return dto;
	}

	@GetMapping("/save")
	public StudentDTO save() {
		StudentDTO dto = new StudentDTO();
		dto.setName("Celal KARTAL");
		Student student = studentConverter.convert(dto);
		student = studentService.save(student);
		dto = studentConverter.convert(student);
		return dto;
	}

}
