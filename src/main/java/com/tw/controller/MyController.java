package com.tw.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tw.entity.Book;
import com.tw.entity.Request;
import com.tw.service.BookService;


@RestController
public class MyController {
	
	@Autowired
	private BookService bs;

	@PostMapping("/saveBook")
	public void saveEmploye(@RequestBody Request request) {
		
		bs.saveBook(request.getBook(), request.getAutherDetails());
	}
	
	@GetMapping("/getAllBooks")
	public List<Book> getAllRecords(){
		return bs.getAllBooks();
	}
	
	
	@GetMapping("/{pageNo}")
	public List<Book> getbooks(@PathVariable int pageNo){
		return bs.getBooks(pageNo, 2);
	}
	
	@GetMapping("/getBooksByPriceSorting")
	public List<Book> getBooksByPriceSorting(){
		return bs.getBooksByPriceSorting();
	}
	
	@GetMapping("/getById-{id}")
	public Book getBook(@PathVariable Long id) {
		return bs.getBookById(id);
	}
	
	@PutMapping("/updateBook")
	public Book updateEmployee(@RequestBody Book b) {
		return bs.updateBook(b);
	}
	
	@DeleteMapping("/deleteById-{id}")
	public void deleteById(@PathVariable Long id) {
		
		bs.deleteBook(id);
	}
	

}
