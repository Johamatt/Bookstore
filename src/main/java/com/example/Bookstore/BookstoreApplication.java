package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repo, CategoryRepository repo2)  {
		return (args) -> {
			
			Category c1 = new Category("fantasy");
			Category c2 = new Category("horror");
			repo2.save(c1);
			repo2.save(c2);
			
			Book b = new Book("The Lord of the Rings", "J.R.R. Tolkien", 2012, "1782808086", 16.99, repo2.findByName("fantasy").get(0));
			Book b1 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1998, "9781782808084", 25.90, repo2.findByName("horror").get(0));
			

			
			repo.save(b);
			repo.save(b1);
			
	
		};
	}

}


