package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.web.BookController;
import com.example.Bookstore.web.CategoryController;
import com.example.Bookstore.web.UserDetailServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {

	 @Autowired
	 private BookController bookController;
	 
	 @Autowired
	 private CategoryController categoryController;
	 
	 @Autowired
	 private UserDetailServiceImpl userDetailServiceImpl;
	 
	 @Test
	 public void contextLoads() throws Exception {
		 assertThat(bookController).isNotNull();
		 assertThat(categoryController).isNotNull();
		 assertThat(userDetailServiceImpl).isNotNull();
	 }

}


