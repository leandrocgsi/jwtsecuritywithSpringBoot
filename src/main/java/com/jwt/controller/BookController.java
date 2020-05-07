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

import com.jwt.service.BookServices;
import com.jwt.vo.BookVO;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookServices service;
	
	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BookVO> findAll() {
		return service.findAll();
	}	
	
	@RequestMapping(value="/{id}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public BookVO findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}	
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public BookVO create(@RequestBody BookVO book) {
		return service.create(book);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public BookVO update(@RequestBody BookVO book) {
		return service.update(book);
	}	
	
	@RequestMapping(value="/{id}", 
			method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}