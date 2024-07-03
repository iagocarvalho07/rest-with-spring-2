package br.com.iago.restap.servises;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iago.restap.interfaces.BooksRepository;
import br.com.iago.restap.model.books;

@Service
public class BooksService {

	@Autowired
	BooksRepository booksRepository;
	
	public List<books> findAllBooks(){
		 List<books> booksList = booksRepository.findAll();
		return booksList;
	}
	
	public books create(books createbook) {
		var book = booksRepository.save(createbook);
		return book;
	}
	
}
