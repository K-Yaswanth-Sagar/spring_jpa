package com.tw.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="books")
public class Book {

	@Id
	private Integer bookId;
	private String bookName;
	private Double bookPrice;
	private String autherName;
	 
	
}
