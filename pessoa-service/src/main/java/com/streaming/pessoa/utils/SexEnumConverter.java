package com.streaming.pessoa.utils;

import com.streaming.pessoa.model.enums.SexEnum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SexEnumConverter implements AttributeConverter<SexEnum, String> {

	@Override
	public String convertToDatabaseColumn(SexEnum sexEnum) {
		if (sexEnum != null) {
			return sexEnum.getAcronym();
		}
		return null;
	}

	@Override
	public SexEnum convertToEntityAttribute(String dbData) {
		if (dbData != null) {
			return SexEnum.getByAcronym(dbData);
		}
		return null;
	}

}
