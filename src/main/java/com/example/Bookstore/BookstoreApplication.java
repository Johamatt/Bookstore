package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repo)  {
		return (args) -> {
			Book b = new Book("The Lord of the Rings", "J.R.R. Tolkien", 2012, "1782808086", 16.99);
			Book b1 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1998, "9781782808084", 25.90);
			
			repo.save(b);
			repo.save(b1);
		};
	}

}


