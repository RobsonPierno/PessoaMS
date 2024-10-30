package com.streaming.pessoa.model;

import java.util.Date;

import com.streaming.pessoa.model.enums.SexEnum;
import com.streaming.pessoa.utils.SexEnumConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "sobrenome")
	private String lastname;
	
	@Column(name = "dtnascimento")
	private Date dtBirth;

	@Column(name = "sexo")
	@Convert(converter = SexEnumConverter.class)
	private SexEnum sex;
	
	@Column(name = "dtcadastro")
	private Date dtInsert;
	
	@Column(name = "ativo")
	private Boolean active;
	
	public Pessoa() {
		super();
	}
	
	public Pessoa(Integer id, String name, String lastname, Date dtBirth, SexEnum sex, Date dtInsert, Boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.dtBirth = dtBirth;
		this.sex = sex;
		this.dtInsert = dtInsert;
		this.active = active;
	}

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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDtBirth() {
		return dtBirth;
	}

	public void setDtBirth(Date dtBirth) {
		this.dtBirth = dtBirth;
	}

	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
	}

	public Date getDtInsert() {
		return dtInsert;
	}

	public void setDtInsert(Date dtInsert) {
		this.dtInsert = dtInsert;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}

