package com.example.Bookstore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Book {
	
	private String title;
	private String author;
	private int year;
	private String isbn;
	private double price;
}
