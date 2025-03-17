package com.tw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.entity.Book;
import com.tw.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;
	
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	public void saveBook(Book b) {
		bookRepo.save(b);
	}
	
	public Book updateBook(Book b) {
		Book bk = bookRepo.findById(b.getBookId()).get();
		bk.setAutherName(b.getAutherName());
		bk.setBookPrice(b.getBookPrice());
		bookRepo.save(bk);
		return bk;
	}
	
	public boolean deleteBook(int id) {
		bookRepo.deleteById(id);
		return true;
	}
	
}
