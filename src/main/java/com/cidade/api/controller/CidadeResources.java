package com.cidade.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cidade.api.entity.Cidade;
import com.cidade.api.repository.CidadeRepository;

@CrossOrigin(origins  = "*")
@RestController
@RequestMapping("/api/cadastro")
public class CidadeResources {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	Logger logger = LoggerFactory.getLogger(CidadeResources.class);


	@DeleteMapping("/{id}")
	public void deleteCidadePorId(@PathVariable Long id){		
		cidadeRepository.deleteById(id);
	}	

	@GetMapping
	public @ResponseBody List<Cidade> findCidadeAll(){		
		return cidadeRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> buscarPeloCodigo(@PathVariable Long id) {
		 Optional<Cidade> cidade = cidadeRepository.findById(id);
		 return cidade != null ? ResponseEntity.ok(cidade.get()) : ResponseEntity.notFound().build();
	}	
	

	@PostMapping
	public ResponseEntity<Cidade> adicionarCidade(@Valid @RequestBody Cidade cidade) {
		try {
			cidadeRepository.save(cidade);
			System.out.println("safassd");
		} catch (Exception e) {			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage().toString());

		}
		return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
	}	

}
