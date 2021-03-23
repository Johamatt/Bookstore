package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@ExtendWith(SpringExtension.class) 
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test  
    public void findByTitleShouldReturnBook() {
        List<Book> books = repository.findByTitle("The Lord of the Rings");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("J.R.R. Tolkien");
    }
    
    @Test 
    public void createNewBook() {
    	Book book = new Book("Da Vinci Code", "Brown, Dan", 2003, "0-385-50420-9 (US) / 978-0-55215971-5", 55.50, null);
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
        
    @Test
    public void deleteBook() {  	
    	repository.deleteById(3L);
    	Iterable<Book> books = repository.findAll();
    	assertThat(books).hasSize(1);
    }
}



