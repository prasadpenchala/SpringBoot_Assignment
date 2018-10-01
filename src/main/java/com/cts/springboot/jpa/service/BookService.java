package com.cts.springboot.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.springboot.jpa.entity.Book;
import com.cts.springboot.jpa.entity.Subject;
import com.cts.springboot.jpa.repository.BookRepository;
import com.cts.springboot.jpa.repository.SubjectRepository;

@Service
@Transactional
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private SubjectRepository subjectRepo;

	
	public List<Book> getAllPersons() {
		return (List<Book>) bookRepo.findAll();
	}

	public Book getBook(long id) {
		return bookRepo.findOne(id);
	}

	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}
	
	public Subject saveSubject(Subject sub) {
		System.out.println("*********************subject***************"+sub.getDurationInHours()+""+sub.getSubjectid());
		return subjectRepo.save(sub);
	}
}