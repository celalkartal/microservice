package com.ahtacode.playermarkt.data.dto;

import java.io.Serializable;

public abstract class BaseDTO implements Serializable {
	private static final long serialVersionUID = 3934768629650196744L;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
