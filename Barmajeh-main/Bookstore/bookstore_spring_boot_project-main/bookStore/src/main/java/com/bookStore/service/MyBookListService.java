package com.bookStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.MyBookList;
import com.bookStore.repository.MyBookRepository;

@Service
public class MyBookListService {

	@Autowired
	private MyBookRepository mybook;

	public void saveMyBooks(MyBookList book) {
		mybook.save(book);
	}

	public List<MyBookList> getAllMyBooks() {
		return mybook.findAll();
	}

	public MyBookList getMyBookById(int id) {
		Optional<MyBookList> book = mybook.findById(id);
		return book.orElse(null);
	}

	public void deleteById(int id) {
		mybook.deleteById(id);
	}
}
