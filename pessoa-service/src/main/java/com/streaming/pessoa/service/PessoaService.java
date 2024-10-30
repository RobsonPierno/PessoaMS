package com.streaming.pessoa.service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.streaming.pessoa.exception.PessoaEmptyException;
import com.streaming.pessoa.exception.PessoaNotFoundException;
import com.streaming.pessoa.model.Pessoa;
import com.streaming.pessoa.model.enums.SexEnum;
import com.streaming.pessoa.repository.PessoaRepository;
import com.streaming.pessoaclient.dto.PessoaDTO;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<PessoaDTO> getAll() {
		List<PessoaDTO> pessoaDtoList = new ArrayList<>();
		
		List<Pessoa> pessoas = this.pessoaRepository.findAll();
		if(pessoas != null && !pessoas.isEmpty()) {
			
			pessoas.forEach(p -> {
				PessoaDTO pessoaDto = this.entityToDto(p);
				pessoaDtoList.add(pessoaDto);
			});
			
			return pessoaDtoList;
		}
		throw new PessoaEmptyException();
	}

	public PessoaDTO getById(final Integer id) {
		Optional<Pessoa> pessoaOpt = this.pessoaRepository.findById(id);
		if (pessoaOpt.isPresent()) {
			PessoaDTO pessoaDto = this.entityToDto(pessoaOpt.get());
			return pessoaDto;
		}
		throw new PessoaNotFoundException();
	}
	
	public void save(PessoaDTO pessoaDto) {
		if (pessoaDto != null && pessoaDto.isMadatoryFieldsNotNull()) {
			Pessoa pessoa = this.dtoToEntity(pessoaDto);
			pessoa.setDtInsert(new Date());
			this.pessoaRepository.save(pessoa);
		}
	}
	
	public PessoaDTO update(Integer id, PessoaDTO pessoaDto) {
		if (pessoaDto != null && id != null) {
			Optional<Pessoa> pessoaOpt = this.pessoaRepository.findById(id);
			if (pessoaOpt.isPresent()) {
				Pessoa pessoa = pessoaOpt.get();
				
				pessoa.setName(pessoaDto.getName() != null ? pessoaDto.getName() : pessoa.getName());
				pessoa.setLastname(pessoaDto.getSurename() != null ? pessoaDto.getSurename() : pessoa.getLastname());
				pessoa.setSex(pessoaDto.getSex() != null ? SexEnum.getByName(pessoaDto.getSex()) : pessoa.getSex());
				pessoa.setActive(pessoaDto.getActive() != null ? pessoaDto.getActive() : pessoa.getActive());
				pessoa.setDtBirth(pessoaDto.getDtBirth() != null ? Date.from(pessoaDto.getDtBirth().atStartOfDay(ZoneId.systemDefault()).toInstant()) : pessoa.getDtBirth());
				
				Pessoa pessoaUpd = this.pessoaRepository.save(pessoa);
				
				return this.entityToDto(pessoaUpd);
			}
			throw new PessoaNotFoundException();
		}
		return null;
		
	}
	
	private PessoaDTO entityToDto(final Pessoa pessoa) {
		return this.mapper.map(pessoa, PessoaDTO.class);
	}
	
	private Pessoa dtoToEntity(final PessoaDTO pessoaDto) {
		return this.mapper.map(pessoaDto, Pessoa.class);
	}
}
