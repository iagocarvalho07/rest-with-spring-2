package br.com.iago.restap.servises;


import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import br.com.iago.restap.controllers.BooksController;
import br.com.iago.restap.dataVo.BookVO;
import br.com.iago.restap.excptions.RequiredObjectIsNullException;
import br.com.iago.restap.excptions.ResouceNotFoundException;
import br.com.iago.restap.interfaces.BooksRepository;
import br.com.iago.restap.mapper.DozzerMapper;
import br.com.iago.restap.model.books;

@Service
public class BooksService {
	
	private Logger logger = Logger.getLogger(BooksService.class.getName());
	
	@Autowired
	BooksRepository repository;

	public List<BookVO> findAll() {

		logger.info("Finding all book!");

		var books = DozzerMapper.parseListObjects(repository.findAll(), BookVO.class);
		books
			.stream()
			.forEach(p -> p.add(linkTo(methodOn(BooksController.class).findById(p.getKey())).withSelfRel()));
		return books;
	}

	public BookVO findById(Long id) {
		
		logger.info("Finding one book!");
		
		var entity = repository.findById(id)
			.orElseThrow(() -> new ResouceNotFoundException("No records found for this ID!"));
		var vo = DozzerMapper.parseObject(entity, BookVO.class);
		vo.add(linkTo(methodOn(BooksController.class).findById(id)).withSelfRel());
		return vo;
	}
	
	public BookVO create(BookVO book) {

		if (book == null) throw new RequiredObjectIsNullException();
		
		logger.info("Creating one book!");
		var entity = DozzerMapper.parseObject(book, books.class);
		var vo =  DozzerMapper.parseObject(repository.save(entity), BookVO.class);
		vo.add(linkTo(methodOn(BooksController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
	public BookVO update(BookVO book) {

		if (book == null) throw new RequiredObjectIsNullException();
		
		logger.info("Updating one book!");
		
		var entity = repository.findById(book.getKey())
			.orElseThrow(() -> new ResouceNotFoundException("No records found for this ID!"));

		entity.setAuthor(book.getAuthor());
		entity.setLaunch_date(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		var vo =  DozzerMapper.parseObject(repository.save(entity), BookVO.class);
		vo.add(linkTo(methodOn(BooksController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one book!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}
}

