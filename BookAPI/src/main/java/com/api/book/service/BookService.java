package com.api.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.book.entities.Book;


@Service
public class BookService
{
	
	// DECLARING A VARIABLE TO BE USED BY ALL METHODS OF THIS SERVICE CLASS
	private static List<Book> listOfBooks = new ArrayList<>();
	
	
	// STATIC BLOCK WILL RUN WHEN THIS SERVICE CLASS IS INSTANTIATED, AND WILL CREATE THE LIST OF BOOKS
	static
	{
		Book bookObj1 = new Book(1, "Cosmos", "Carl Sagan", 650.99);
		Book bookObj2 = new Book(2, "1984", "George Orwell", 428.50);
		Book bookObj3 = new Book(3, "The theory of Everything", "Stephan Hawking", 562.20);
		
		listOfBooks.add(bookObj1);
		listOfBooks.add(bookObj2);
		listOfBooks.add(bookObj3);
	}
	
	
	// METHOD TO GET ALL BOOKS
	public List<Book> getAllBooks()
	{
		return listOfBooks;
	}
	
	
	// METHOD TO GET BOOK BY ITS ID
	public Book getBookByID(int bookId)
	{
		Book bookFetched = listOfBooks.stream()
					.filter(b -> b.getId() == bookId)
					.findFirst()
					.get();
		return bookFetched;
	}


	// METHOD TO ADD NEW BOOK
	public void addBook(Book bookToBeAdded)
	{
		listOfBooks.add(bookToBeAdded);
	
	}
	
	
	// DELETING A BOOK BY ITS ID
	public void deleteById(int  bookId)
	{
		listOfBooks = listOfBooks.stream()
				.filter(b -> b.getId() != bookId)
				.collect(Collectors.toList());
	}


	// UPDATING A BOOK WITH THE HELP OF ID
	public void updateBook(Book updatedBook, int bookId)
	{
		listOfBooks = listOfBooks.stream()
				.map(b -> 
				{
					if(b.getId() == bookId)
					{
						b.setId(updatedBook.getId());
						b.setTitle(updatedBook.getTitle());
						b.setAuthor(updatedBook.getAuthor());
						b.setCost(updatedBook.getCost());
					}
					return b;
				})
				.collect(Collectors.toList());		
	}
}
