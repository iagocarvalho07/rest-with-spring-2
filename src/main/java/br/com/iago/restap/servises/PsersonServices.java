package br.com.iago.restap.servises;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.iago.restap.excptions.ResouceNotFoundException;
import br.com.iago.restap.interfaces.PersonRepostiroty;
import br.com.iago.restap.model.Person;

@Service
public class PsersonServices {

	@Autowired
	PersonRepostiroty repostiroty;

	private Logger logger = Logger.getLogger(PsersonServices.class.getName());

	public List<Person> findAll() {
		logger.info("Finding all people!");
		return repostiroty.findAll();

	}

	public Person findById(Long id) {
		logger.info("find one person!");
		return repostiroty.findById(id).orElseThrow(() -> new ResouceNotFoundException("no records found for this Id"));
	}

	public Person create(Person person) {
		logger.info("Creating one person!");

		return repostiroty.save(person);
	}

	public Person update(Person person) {

		logger.info("Updating one person!");
		Person entity = repostiroty.findById(person.getId())
				.orElseThrow(() -> new ResouceNotFoundException("no records found for this Id"));
		entity.setName(person.getName());
		entity.setLastname(person.getLastname());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return repostiroty.save(entity);
	}

	public void delete(Long id) {
		logger.info("Deleting one person!");
		Person entity = repostiroty.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("no records found for this Id"));
		repostiroty.delete(entity);

	}

}
