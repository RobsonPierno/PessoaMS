package com.streaming.pessoa.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import com.streaming.pessoa.model.Pessoa;
import com.streaming.pessoa.model.enums.SexEnum;
import com.streaming.pessoaclient.dto.PessoaDTO;

public class PessoaMapper {
	
	public static void mapFields(ModelMapper mapper) {
		EntityToDTO(mapper);
		DtoToEntity(mapper);
	}
	
	private static void EntityToDTO(ModelMapper mapper) {
		TypeMap<Pessoa, PessoaDTO> propertyMapper = mapper.createTypeMap(Pessoa.class, PessoaDTO.class);
		
		propertyMapper.addMapping(Pessoa::getLastname, PessoaDTO::setSurename);
		
		propertyMapper.addMapping(Pessoa::getDtBirth, PessoaDTO::setDtBirthTmp);
		
		propertyMapper.addMapping(Pessoa::getDtInsert, PessoaDTO::setDtInsertTmp);
		
		propertyMapper.addMapping(p -> p.getSex() != null ? p.getSex().getName() : null, PessoaDTO::setSex);
	}
	
	private static void DtoToEntity(ModelMapper mapper) {
		TypeMap<PessoaDTO, Pessoa> propertyMapper = mapper.createTypeMap(PessoaDTO.class, Pessoa.class);
		
		propertyMapper.addMapping(PessoaDTO::getSurename, Pessoa::setLastname);
		
		propertyMapper.addMapping(PessoaDTO::getDtBirthTmp, Pessoa::setDtBirth);
		
		propertyMapper.addMapping(PessoaDTO::getDtInsertTmp, Pessoa::setDtInsert);
		
		propertyMapper.addMapping(p -> SexEnum.getByName(p.getSex()), Pessoa::setSex);
	}
}
