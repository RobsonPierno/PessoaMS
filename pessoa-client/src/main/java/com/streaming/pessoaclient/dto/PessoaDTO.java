package com.streaming.pessoaclient.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PessoaDTO {
	
	private Integer id;
	private String name;
	private String surename;
	private LocalDate dtBirth;
	private String sex;
	private LocalDateTime dtInsert;
	private Boolean active;
	
	@JsonIgnore
	private Date dtBirthTmp;
	
	@JsonIgnore
	private Date dtInsertTmp;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurename() {
		return surename;
	}

	public void setSurename(String surename) {
		this.surename = surename;
	}
	
	public LocalDate getDtBirth() {
		if (this.dtBirth == null && this.dtBirthTmp != null) {
			this.dtBirth = Instant.ofEpochMilli(this.dtBirthTmp.getTime())
									.atZone(ZoneId.systemDefault())
									.toLocalDate();
		}
		return dtBirth;
	}
	
	public void setDtBirth(LocalDate dtBirth) {
		this.dtBirth = dtBirth;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public LocalDateTime getDtInsert() {
		if (this.dtInsert == null && this.dtInsertTmp != null) {
			this.dtInsert = Instant.ofEpochMilli(this.dtInsertTmp.getTime())
									.atZone(ZoneId.systemDefault())
									.toLocalDateTime();
		}
		return dtInsert;
	}
	
	public void setDtInsert(LocalDateTime dtInsert) {
		this.dtInsert = dtInsert;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Date getDtBirthTmp() {
		if (this.dtBirthTmp == null && this.dtBirth != null) {
			this.dtBirthTmp = Date.from(this.dtBirth
											.atStartOfDay(ZoneId.systemDefault())
											.toInstant());
		}
		return dtBirthTmp;
	}
	
	public void setDtBirthTmp(Date dtBirthTmp) {
		this.dtBirthTmp = dtBirthTmp;
	}
	
	public Date getDtInsertTmp() {
		if (this.dtInsertTmp == null && this.dtInsert != null) {
			this.dtInsertTmp = Date.from(this.dtInsert
											.atZone(ZoneId.systemDefault())
											.toInstant());
		}
		return dtInsertTmp;
	}
	
	public void setDtInsertTmp(Date dtInsertTmp) {
		this.dtInsertTmp = dtInsertTmp;
	}
	
	@JsonIgnore
	public Boolean isMadatoryFieldsNotNull() {
		return this.getName() != null && 
				this.getSurename() != null && 
				this.getDtBirth() != null && 
				this.getActive() != null &&
				this.getSex() != null;
	}
	
	@Override
	public String toString() {
		return "PessoaDTO [id=" + id + ", name=" + name + ", surename=" + surename + ", dtBirth=" + dtBirth + ", sex="
				+ sex + ", dtInsert=" + dtInsert + ", active=" + active + "]";
	}
}
