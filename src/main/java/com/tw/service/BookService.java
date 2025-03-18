package com.tw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tw.entity.Book;
import com.tw.entity.BookPk;
import com.tw.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;
	
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	public List<Book> getBooks(int pageNo, int pageSize){
		PageRequest pr = PageRequest.of(pageNo-1, pageSize);
		Page<Book> all = bookRepo.findAll(pr);
		return all.getContent();
	}
	
	public List<Book> getBooksByPriceSorting(){
		Sort sort = Sort.by("bookPrice").descending();
		return bookRepo.findAll(sort);
	}
	
	public void saveBook(Book b) {
		bookRepo.save(b);
	}
	
	public Book updateBook(Book b) {
		BookPk bpk = b.getPk();
		
		Book bk = bookRepo.findById(bpk).get();
		bk.setAutherName(b.getAutherName());
		bk.setBookPrice(b.getBookPrice());
		bpk.setBookId(b.getPk().getBookId());
		bpk.setBookName(b.getPk().getBookName());
		bookRepo.save(bk);
		return bk;
	}
	
	public Book getBookById(Long b) {
		return bookRepo.getBookById(b);
	}
	
	public boolean deleteBook(Long id) {
		bookRepo.deleteBookById(id);
		return true;
	}
	
}
