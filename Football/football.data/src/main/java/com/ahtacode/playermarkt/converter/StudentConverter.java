package com.ahtacode.playermarkt.converter;

import org.springframework.stereotype.Component;

import com.ahtacode.playermarkt.data.dto.StudentDTO;
import com.ahtacode.playermarkt.data.entity.Student;

@Component
public class StudentConverter implements BaseConverter<Student, StudentDTO> {
	public Student convert(StudentDTO dto) {
		Student entity = new Student();
		entity.setName(dto.getName());

		return entity;
	}

	public StudentDTO convert(Student entity) {
		StudentDTO dto = new StudentDTO();
		dto.setName(entity.getName());
		return dto;
	}

}
