package com.jwt.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.converter.DozerEntityConverter;
import com.jwt.entity.Person;
import com.jwt.exception.ResourceNotFoundException;
import com.jwt.repository.PersonRepository;
import com.jwt.vo.PersonVo;

@Service
public class PersonServices {

	@Autowired
	private PersonRepository personRepository;

	public PersonVo create(PersonVo person) {
		Person parse = DozerEntityConverter.parseObject(person, Person.class);
		return DozerEntityConverter.parseObject(this.personRepository.save(parse), PersonVo.class);
	}

	public PersonVo update(PersonVo person) {
		this.personRepository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("Person not found"));
		Person parse = DozerEntityConverter.parseObject(person, Person.class);
		return DozerEntityConverter.parseObject(this.personRepository.save(parse), PersonVo.class);
	}

	public void delete(Long id) {
		this.personRepository.deleteById(id);
	}

	public PersonVo findById(Long id) {
		 Person person = this.personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No data found for ID"));
		return DozerEntityConverter.parseObject(person, PersonVo.class);

	}

	public List<PersonVo> findAll() {
		return DozerEntityConverter.parseListObject(this.personRepository.findAll(), PersonVo.class);

	}

}
