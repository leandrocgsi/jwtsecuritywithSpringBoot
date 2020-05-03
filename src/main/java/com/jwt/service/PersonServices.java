package com.jwt.service;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.entity.Person;
import com.jwt.exception.ResourceNotFoundException;
import com.jwt.repository.PersonRepository;


@Service
public class PersonServices {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person create(Person person) {
		return this.personRepository.save(person);
	}
	
	public Person update(Person person) {
		this.personRepository.findById(person.getId())
		.orElseThrow(()-> new ResourceNotFoundException("Person not found"));
		return this.personRepository.save(person);
	}	
	
	public void delete(Long id) {
		this.personRepository.deleteById(id);
	}
	
	public Person findById(Long id) {
		return this.personRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("No data found for ID"));
		
	}
	
	public List<Person> findAll() {
		return this.personRepository.findAll();
		
	}

}
