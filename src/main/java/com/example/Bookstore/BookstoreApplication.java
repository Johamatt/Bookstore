package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repo, CategoryRepository repo2, UserRepository repo3)  {
		return (args) -> {
			
			Category c1 = new Category("fantasy");
			Category c2 = new Category("horror");
			repo2.save(c1);
			repo2.save(c2);
			
			Book b = new Book("The Lord of the Rings", "J.R.R. Tolkien", 2012, "1782808086", 16.99, repo2.findByName("fantasy").get(0));
			Book b1 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1998, "9781782808084", 25.90, repo2.findByName("horror").get(0));
			repo.save(b);
			repo.save(b1);
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@gmail.com", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@gmail.com", "ADMIN");
			repo3.save(user1);
			repo3.save(user2);
			

	
		};
	}

}


