package com.streaming.pessoaclient.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.streaming.pessoaclient.dto.PessoaDTO;

@FeignClient(name = "pessoa-service", url = "http://pessoa:8081", path = "/pessoa")
public interface PessoaClient {

	@GetMapping
	public List<PessoaDTO> getAll();
	
	@GetMapping("/{id}")
	public PessoaDTO getById(@PathVariable Integer id);
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody PessoaDTO pessoa);
	
	@PatchMapping("/{id}")
	public PessoaDTO updatePessoa(@PathVariable Integer id, @RequestBody PessoaDTO pessoa);
}
