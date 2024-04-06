package com.api.book.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;


@Service
public class BookService
{
	
	@Autowired
	private BookRepository repoObj;
	
	
	// METHOD TO GET ALL BOOKS
	public List<Book> getAllBooks()
	{
		List<Book> listOfBooks = (List<Book>) repoObj.findAll();
		return listOfBooks;
	}
	
	
	// METHOD TO GET BOOK BY ITS ID
	public Book getBookByID(int bookId)
	{
		Book bookFetched = repoObj.findById(bookId);
		return bookFetched;
	}


	// METHOD TO ADD NEW BOOK
	public Book addBook(Book bookToBeAdded)
	{
		Book bookAdded = repoObj.save(bookToBeAdded);
		return bookAdded;
	}
	
	
	// DELETING A BOOK BY ITS ID
	public void deleteById(int bookId)
	{
		repoObj.deleteById(bookId);
	}


	// UPDATING A BOOK WITH THE HELP OF ID
	public void updateBook(Book updatedBook, int bookId)
	{
		updatedBook.setId(bookId);
		repoObj.save(updatedBook);
	}
}
