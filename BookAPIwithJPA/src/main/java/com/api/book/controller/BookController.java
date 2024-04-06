package com.api.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Book>> getBooks()
	{		
		List<Book> listOfBooks = serviceObj.getAllBooks();
		if(listOfBooks == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(listOfBooks);
	}
	
	
	@GetMapping("/book/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable int bookId)
	{		
		Book bookFetched = serviceObj.getBookByID(bookId);
		if(bookFetched == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(bookFetched));
	}
	
		
	@PostMapping("/book")
	public ResponseEntity<Book> addBook(@RequestBody Book b)
	{		
		try
		{
			serviceObj.addBook(b);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<Book> deleteBook(@PathVariable int bookId)
	{		
		try
		{
			serviceObj.deleteById(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@PutMapping("/book/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book updatedBook, @PathVariable int bookId)
	{	
		try
		{
			serviceObj.updateBook(updatedBook, bookId);
			return ResponseEntity.ok().body(updatedBook);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
