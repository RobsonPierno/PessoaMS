package com.streaming.pessoa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.streaming.pessoa.model.Pessoa;
import com.streaming.pessoaclient.dto.PessoaDTO;

@SpringBootTest(classes = PessoaApplication.class)
class PessoaApplicationTests {
	
	@Autowired
	private ModelMapper mapper;

	@Test
	void convertEntityToDto() {
		Pessoa p = new Pessoa();
		p.setName("Robson");
		p.setLastname("Pierno");
		
		PessoaDTO pDto = this.mapper.map(p, PessoaDTO.class);
		
		assertEquals(pDto.getName(), p.getName());
		assertEquals(pDto.getSurename(), p.getLastname());
	}

}
