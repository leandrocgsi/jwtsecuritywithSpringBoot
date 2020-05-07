package com.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.entity.Person;
import com.jwt.service.PersonServices;
import com.jwt.vo.PersonVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "Person Controller" ,description = "Person Controller Api Doc" ,tags = {"Person", ""})
@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	@ApiOperation(value = "find all recorded data")
	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVo> findAll() {
		return service.findAll();
	}	
	@ApiOperation(value = "find a specific recorded data")
	@RequestMapping(value="/{id}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVo findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}	
	@ApiOperation(value = "create new data")
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVo create(@RequestBody PersonVo person) {
		return service.create(person);
	}
	
	@ApiOperation(value = "update the recorded data")
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVo update(@RequestBody PersonVo person) {
		return service.update(person);
	}	
	
	@ApiOperation(value = "delete the recorded data")
	@RequestMapping(value="/{id}", 
			method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}