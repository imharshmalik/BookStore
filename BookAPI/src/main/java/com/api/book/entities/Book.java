package com.api.book.entities;

public class Book
{
	private int id;
	private String title;
	private String author;
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
