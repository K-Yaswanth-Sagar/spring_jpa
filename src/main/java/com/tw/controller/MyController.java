package com.tw.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.tw.entity.Book;
import com.tw.entity.Request;
import com.tw.service.BookService;


@RestController
public class MyController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);

	
	@Autowired
	private BookService bs;

	@PostMapping("/saveBook")
	public ResponseEntity<String> saveBook(@RequestBody Request request) {
		
		logger.info("Received request to save book with details: {}", request);
        bs.saveBook(request.getBook(), request.getAutherDetails());
        logger.info("Book saved successfully.");
        return ResponseEntity.status(HttpStatus.CREATED).body("Book saved successfully.");
		
	}
	
	@GetMapping("/getAllBooks")
	public ResponseEntity<List<Book>> getAllRecords() {
        logger.info("Fetching all book records.");
        List<Book> books = bs.getAllBooks();
        logger.info("Fetched {} books.", books.size());
        return ResponseEntity.ok(books);
    }
	
	
	@GetMapping("/{pageNo}")
	public ResponseEntity<List<Book>> getbooks(@PathVariable int pageNo) {
        logger.info("Fetching books for page number: {}", pageNo);
        List<Book> books = bs.getBooks(pageNo, 2);
        if (books.isEmpty()) {
            logger.warn("No books found for page number: {}", pageNo);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(books);
        }
        logger.info("Fetched {} books for page number: {}", books.size(), pageNo);
        return ResponseEntity.ok(books);
    }
	
	@GetMapping("/getBooksByPriceSorting")
	public ResponseEntity<List<Book>> getBooksByPriceSorting() {
        logger.info("Fetching books sorted by price.");
        List<Book> books = bs.getBooksByPriceSorting();
        logger.info("Fetched {} books sorted by price.", books.size());
        return ResponseEntity.ok(books);
    }
	
	@GetMapping("/getById-{id}")
	public ResponseEntity<Book> getBook(@PathVariable Long id) {
        logger.info("Fetching book with ID: {}", id);
        Book book = bs.getBookById(id);
        if (book != null) {
            logger.info("Book found: {}", book);
            return ResponseEntity.ok(book);
        } else {
            logger.warn("No book found with ID: {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

	
	@PutMapping("/updateBook")
	public ResponseEntity<Book> update(@RequestBody Book b) {
        logger.info("Updating book with details: {}", b);
        Book updatedBook = bs.updateBook(b);
        if (updatedBook != null) {
            logger.info("Book updated successfully: {}", updatedBook);
            return ResponseEntity.ok(updatedBook);
        } else {
            logger.warn("Failed to update book: {}", b);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

	
	@DeleteMapping("/deleteById-{id}")
	 public ResponseEntity<String> deleteById(@PathVariable Long id) {
        logger.info("Deleting book with ID: {}", id);
        bs.deleteBook(id);
        logger.info("Book with ID: {} deleted successfully.", id);
        return ResponseEntity.ok("Book deleted successfully.");
    }
	

}
