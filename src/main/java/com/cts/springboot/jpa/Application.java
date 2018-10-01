package com.cts.springboot.jpa;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cts.springboot.jpa.entity.Book;
import com.cts.springboot.jpa.entity.Subject;
import com.cts.springboot.jpa.repository.BookRepository;
import com.cts.springboot.jpa.service.BookService;
@SpringBootApplication
public class Application {
	
	@Autowired
	BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	@Bean
	public CommandLineRunner run(BookRepository repository) {
		return (args) -> {
			Book book = new Book(1002, "java", 300, 3, new Date());
			// book = saveBookDetails(book);
			  saveSubjectDetails();
			Subject javaSubject = new Subject(2003, "Dba2", 6);
			 bookService.saveSubject(javaSubject);
			//System.out.println("Book Id : "+book.getBookid());
		};
	}
	
	public Book saveBookDetails(Book book){
		return bookService.saveBook(book);
	}
	public Subject saveSubjectDetails(){
		System.out.println("Subject Id : ");
		Book book4 = new Book(1004, "css", 400, 4, new Date());
		Book book5 = new Book(1005, "oracle", 500, 8, new Date());

		Subject javaSubject = new Subject(2003, "Dba2", 6);

		book4.setSubjectid(javaSubject);
		book5.setSubjectid(javaSubject);

		Set<Book> bookset = new HashSet<Book>();

		System.out.println("....Before insert......." + bookset.size());

		bookset.add(book4);
		bookset.add(book5);
		bookset.size();

		javaSubject.setBooks(bookset);

		

		System.out.println("....After insert......." + bookset.size());
		return bookService.saveSubject(javaSubject);
	}
	
	public Book getPerson(Book book){
		return bookService.getBook(book.getBookid());
	}
}
