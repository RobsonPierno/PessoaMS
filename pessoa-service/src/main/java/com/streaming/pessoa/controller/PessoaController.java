package com.streaming.pessoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.streaming.pessoa.service.PessoaService;
import com.streaming.pessoaclient.client.PessoaClient;
import com.streaming.pessoaclient.dto.PessoaDTO;

@RestController
@RequestMapping("/pessoa")
public class PessoaController implements PessoaClient {

	@Autowired
	private PessoaService pessoaService;
	
	public List<PessoaDTO> getAll() {
		return this.pessoaService.getAll();
	}
	
	public PessoaDTO getById(@PathVariable Integer id) {
		return this.pessoaService.getById(id);
	}
	
	public void save(@RequestBody PessoaDTO pessoa) {
		this.pessoaService.save(pessoa);
	}
	
	public PessoaDTO updatePessoa(@PathVariable Integer id, @RequestBody PessoaDTO pessoa) {
		return this.pessoaService.update(id, pessoa);
	}
}
