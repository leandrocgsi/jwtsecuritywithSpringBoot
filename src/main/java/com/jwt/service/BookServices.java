package com.jwt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jwt.converter.DozerEntityConverter;
import com.jwt.entity.Book;
import com.jwt.exception.ResourceNotFoundException;
import com.jwt.repository.BookRepository;
import com.jwt.vo.BookVO;


@Service
public class BookServices {
	
	@Autowired
	BookRepository repository;
		
	public BookVO create(BookVO bookVo) {
		Book parse = DozerEntityConverter.parseObject(bookVo, Book.class);
		return DozerEntityConverter.parseObject(this.repository.save(parse), BookVO.class);
	}

	public BookVO update(BookVO bookVo) {
		this.repository.findById(bookVo.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Person not found"));
		Book parse = DozerEntityConverter.parseObject(bookVo, Book.class);
		return DozerEntityConverter.parseObject(this.repository.save(parse), BookVO.class);
	}

	public void delete(Long id) {
		this.repository.deleteById(id);
	}

	public BookVO findById(Long id) {
		 Book book = this.repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No data found for ID"));
		return DozerEntityConverter.parseObject(book, BookVO.class);

	}

	public List<BookVO> findAll() {
		return DozerEntityConverter.parseListObject(this.repository.findAll(), BookVO.class);

	}

}
