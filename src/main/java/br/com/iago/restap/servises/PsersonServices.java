package br.com.iago.restap.servises;


import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.iago.restap.controllers.MathController;
import br.com.iago.restap.dataVo.PersonVo;
import br.com.iago.restap.dataVo.PersonVoV2;
import br.com.iago.restap.excptions.ResouceNotFoundException;
import br.com.iago.restap.interfaces.PersonRepostiroty;
import br.com.iago.restap.mapper.DozzerMapper;
import br.com.iago.restap.mapper.PersonMapperCustom;
import br.com.iago.restap.model.Person;

@Service
public class PsersonServices {

	@Autowired
	PersonRepostiroty repostiroty;
	
	@Autowired
	PersonMapperCustom personMapperCustom;

	private Logger logger = Logger.getLogger(PsersonServices.class.getName());

	public List<PersonVo> findAll()  {
		logger.info("Finding all people!");
		var persons = DozzerMapper.parseListObjects(repostiroty.findAll(), PersonVo.class);
		persons.stream().forEach(p -> {
			try {
				p.add(linkTo(methodOn(MathController.class).person(p.getId())).withSelfRel());
			} catch (Exception e) {
	
				e.printStackTrace();
			}
		});
		return persons;

	}

	public PersonVo findById(Long id) throws Exception {
		logger.info("find one person!");
		var entity = repostiroty.findById(id).orElseThrow(
				() -> new ResouceNotFoundException("no records found for this Id"));
		PersonVo vo = DozzerMapper.parseObject(entity, PersonVo.class);
		vo.add(linkTo(methodOn(MathController.class).person(id)).withSelfRel());
		return vo;
	}

	public PersonVo create(PersonVo person) throws Exception {
		logger.info("Creating one person!");
		var entity = DozzerMapper.parseObject(person, Person.class);
		var vo =  DozzerMapper.parseObject(repostiroty.save(entity), PersonVo.class);
		vo.add(linkTo(methodOn(MathController.class).person(vo.getId())).withSelfRel());
		return vo;
	}

	public PersonVo update(PersonVo person) {

		logger.info("Updating one person!");
		var entity = repostiroty.findById(person.getId())
				.orElseThrow(() -> new ResouceNotFoundException("no records found for this Id"));
		entity.setName(person.getName());
		entity.setLastname(person.getLastname());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		var vo =  DozzerMapper.parseObject(repostiroty.save(entity), PersonVo.class);
		return vo;
	}

	public void delete(Long id) {
		logger.info("Deleting one person!");
		var entity = repostiroty.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("no records found for this Id"));
		repostiroty.delete(entity);

	}

	public PersonVoV2 createV2(PersonVoV2 person) {
		logger.info("Creating one person V2!");
		var entity = personMapperCustom.converVoToEntity(person);
		var vo =  personMapperCustom.converEntityToVo(repostiroty.save(entity));
		return vo;
	}

}
