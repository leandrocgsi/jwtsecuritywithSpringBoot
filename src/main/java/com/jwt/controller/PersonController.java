package com.jwt.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import com.jwt.service.PersonServices;
import com.jwt.vo.PersonVo;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices service;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml" })
	public List<PersonVo> findAll() {
		 List<PersonVo> personVos = service.findAll();
		 personVos = personVos.stream().map(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel())).collect(Collectors.toList());
		 return personVos;
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
			"application/x-yaml" })
	public PersonVo findById(@PathVariable("id") Long id) {
		PersonVo personVo = service.findById(id);
		// via slash
		// personVo.add(linkTo(PersonController.class).slash(personVo.getKey()).withSelfRel());

		// via method
		personVo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return personVo;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
			"application/x-yaml" }, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
					"application/x-yaml" })
	public PersonVo create(@RequestBody PersonVo person) {
		PersonVo personVo = service.create(person);
		personVo.add(linkTo(PersonController.class).slash(person.getKey()).withSelfRel());
		return personVo;
	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
			"application/x-yaml" }, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
					"application/x-yaml" })
	public PersonVo update(@RequestBody PersonVo person) {

		PersonVo personVo = service.create(person);
		personVo.add(linkTo(PersonController.class).slash(person.getKey()).withSelfRel());
		return personVo;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}