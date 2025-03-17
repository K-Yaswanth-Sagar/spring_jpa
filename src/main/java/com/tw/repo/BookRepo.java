package com.tw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
