package br.com.iago.restap.mapper;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.iago.restap.dataVo.PersonVoV2;
import br.com.iago.restap.model.Person;

@Service
public class PersonMapperCustom {
	public PersonVoV2 converEntityToVo(Person person) {
		PersonVoV2 vo = new PersonVoV2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setDate(new Date());
		vo.setName(person.getName());
		vo.setLastname(person.getLastname());
		vo.setGender(person.getGender());
		return vo;
		
	}
	
	
	public Person converVoToEntity(PersonVoV2 person) {
		Person vo = new Person();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		//vo.setDate(new Date());
		vo.setName(person.getName());
		vo.setLastname(person.getLastname());
		vo.setGender(person.getGender());
		return vo;
		
	}
}
