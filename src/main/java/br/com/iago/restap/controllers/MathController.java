package br.com.iago.restap.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iago.restap.dataVo.PersonVo;
import br.com.iago.restap.dataVo.PersonVoV2;
import br.com.iago.restap.servises.PsersonServices;

@RestController
@RequestMapping("/person")
public class MathController {

	@Autowired
	private PsersonServices services;

	@GetMapping(value = "/{id}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public PersonVo person(@PathVariable(value = "id") Long id) throws Exception {
		return services.findById(id);
	}

	@GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVo> allperson() {
		return services.findAll();
	}

	@PostMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PersonVo create(@RequestBody PersonVo person) {
		return services.create(person);
	}
	
//	@PostMapping(value = "/v2", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public PersonVoV2 createV2(@RequestBody PersonVoV2 person) {
//		return services.createV2(person);
//	}
	
	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVo update(@RequestBody PersonVo person) {
		return services.update(person);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}

}
