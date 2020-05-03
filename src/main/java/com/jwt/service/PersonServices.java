package com.jwt.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.entity.Person;
import com.jwt.exception.ResourceNotFoundException;
import com.jwt.repository.PersonRepository;
import com.jwt.vo.PersonVo;


@Service
public class PersonServices {
	
	@Autowired
	private PersonRepository personRepository;
	
	public PersonVo create(PersonVo person) {
		return this.personRepository.save(person);
	}
	
	public PersonVo update(PersonVo person) {
		this.personRepository.findById(person.getId())
		.orElseThrow(()-> new ResourceNotFoundException("Person not found"));
		return this.personRepository.save(person);
	}	
	
	public void delete(Long id) {
		this.personRepository.deleteById(id);
	}
	
	public PersonVo findById(Long id) {
		return this.personRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("No data found for ID"));
		
	}
	
	public List<PersonVo> findAll() {
		return this.personRepository.findAll();
		
	}

}
