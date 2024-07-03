package br.com.iago.restap.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iago.restap.dataVo.PersonVo;
import br.com.iago.restap.model.books;
import br.com.iago.restap.servises.BooksService;

@RestController
@RequestMapping("/books")
public class BooksController {
	
	@Autowired
	private BooksService booksService;
	
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"})
	public List<books> GetAllBooks(){
		return booksService.findAllBooks();
	}
	
	@PostMapping(
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"})
	public books create(@RequestBody books bookss) throws Exception {
		return booksService.create(bookss);
	}
	
	

}
