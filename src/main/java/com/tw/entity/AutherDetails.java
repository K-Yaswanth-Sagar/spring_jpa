package com.tw.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutherDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aId;
	
	private String name;
	private String dob;
	
	private Integer bookId;
	
}
