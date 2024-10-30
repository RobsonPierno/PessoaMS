package com.streaming.pessoa.model.enums;

public enum SexEnum {

	MALE("M", "Masculino"),
	FEMALE("F", "Feminino"),
	UNDEFINED("U", "Nao Definido");
	
	private String acronym;
	private String name;
	
	private SexEnum(String acronym, String name) {
		this.acronym = acronym;
		this.name = name;
	}

	public String getAcronym() {
		return acronym;
	}

	public String getName() {
		return name;
	}
	
	public static SexEnum getByAcronym(final String acronym) {
		for (SexEnum value : SexEnum.values()) {
			if (value.getAcronym().equalsIgnoreCase(acronym)) {
				return value;
			}
		}
		return SexEnum.UNDEFINED;
	}
	
	public static SexEnum getByName(final String name) {
		for (SexEnum value : SexEnum.values()) {
			if (value.getName().equalsIgnoreCase(name)) {
				return value;
			}
		}
		return SexEnum.UNDEFINED;
	}
}
