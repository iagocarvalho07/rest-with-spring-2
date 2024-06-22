package br.com.iago.restap.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.iago.restap.model.Person;
import br.com.iago.restap.servises.PsersonServices;

@RestController
@RequestMapping("/person")
public class MathController {

	@Autowired
	private PsersonServices services;

	@GetMapping(value = "/{id}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Person person(@PathVariable(value = "id") Long id) throws Exception {
		return services.findById(id);
	}

	@GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<Person> allperson() {
		return services.findAll();
	}

	@PostMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) {
		return services.create(person);
	}
	
	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person) {
		return services.update(person);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}

}
