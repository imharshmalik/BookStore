package com.api.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.service.BookService;

@RestController
public class BookController
{
	@Autowired
	private BookService serviceObj;
	
	
	@GetMapping("/book")
	public List<Book> getBooks()
	{		
		return serviceObj.getAllBooks();
	}
	
	
	@GetMapping("/book/{bookId}")
	public Book getBookById(@PathVariable int bookId)
	{		
		return serviceObj.getBookByID(bookId);
	}
	
		
	@PostMapping("/book")
	public String addBook(@RequestBody Book b)
	{
		serviceObj.addBook(b);
		return "Book Added.";
	}
	
	
	@DeleteMapping("/book/{bookId}")
	public String deleteBook(@PathVariable int bookId)
	{
		serviceObj.deleteById(bookId);
		return "Book Deleted.";
	}
	
	
	@PutMapping("/book/{bookId}")
	public String updateBook(@RequestBody Book updatedBook, @PathVariable int bookId)
	{
		serviceObj.updateBook(updatedBook, bookId);
		return "Book Updated.";
	}
}
