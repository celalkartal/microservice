package com.ahtacode.playermarkt.converter;

import com.ahtacode.playermarkt.data.dto.BaseDTO;
import com.ahtacode.playermarkt.data.entity.BaseEntity;

public interface BaseConverter<ENTITY extends BaseEntity, DTO extends BaseDTO> {
	public ENTITY convert(DTO dto);
	public DTO convert(ENTITY entity);
}
