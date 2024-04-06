package com.api.book.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book
{
	@Id
	@GeneratedValue
	@Column(name="book_id")
	private int id;
	
	@Column(name="book_title")
	private String title;
	
	@Column(name="book_author")
	private String author;
	
	@Column(name="book_cost")
	private double cost;
	
	
	// GETTERS AND SETTERS
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public double getCost()
	{
		return cost;
	}
	public void setCost(double cost)
	{
		this.cost = cost;
	}
	
	
	//CONSTRUCTORS
	public Book()
	{
		
	}
	public Book(int id, String title, String author, double cost)
	{
		this.id = id;
		this.title = title;
		this.author = author;
		this.cost = cost;
	}
	
	
	@Override
	public String toString()
	{
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", cost=" + cost + "]";
	}
	
	
}
