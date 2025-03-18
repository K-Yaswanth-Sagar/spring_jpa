package com.tw.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.tw.entity.Book;
import com.tw.entity.BookPk;


public interface BookRepo extends JpaRepository<Book, BookPk> {
	
	@Transactional
	@Modifying
	@Query("delete from Book b where b.pk.bookId = :bookId")
	void deleteBookById(@Param("bookId") Long bookId);

	
	@Query("select b from Book b where b.pk.bookId = :bookId")
	Book getBookById(@Param("bookId") Long bookId);

}
