package com.bookStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MyBooks")
public class MyBookList {

	@Id
	private int id;
	private String name;
	private String author;
	private String price;

	@Column(length = 500)  // Allows long URLs for images
	private String bookCover;

	public MyBookList() {
		super();
	}

	public MyBookList(int id, String name, String author, String price, String bookCover) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.bookCover = bookCover;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBookCover() {
		return bookCover;
	}

	public void setBookCover(String bookCover) {
		this.bookCover = bookCover;
	}
}
