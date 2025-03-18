package com.tw.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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

	private Double bookPrice;
	private String autherName;
	
	@EmbeddedId
	private BookPk pk;
	
	@CreationTimestamp
	@Column(name = "create_date" , updatable = false)
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name = "update_date", insertable = false)
	private LocalDate updatedDate;
	 
	
}
