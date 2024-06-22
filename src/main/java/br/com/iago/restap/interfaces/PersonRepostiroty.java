package br.com.iago.restap.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.iago.restap.model.Person;

@Repository
public interface PersonRepostiroty extends JpaRepository<Person, Long>{}
