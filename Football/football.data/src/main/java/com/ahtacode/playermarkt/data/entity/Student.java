package com.ahtacode.playermarkt.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_CELAL_STUDENT")
@SequenceGenerator(name = "TEST_CELAL_STUDENT_SEQ", initialValue = 1, allocationSize = 100)
public class Student extends BaseEntity {
	@Column(name = "NAME")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEST_CELAL_STUDENT_SEQ")
	public Long getId() {
		return super.getId();
	}

}
