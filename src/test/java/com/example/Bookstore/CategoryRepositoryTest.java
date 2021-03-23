package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@ExtendWith(SpringExtension.class) 
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test  
    public void findByCategoryNameShouldReturnCategory() {
        List<Category> categories = repository.findByName("fantasy");
        
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("fantasy");
    }
    
    @Test 
    public void createNewCategory() {
    	Category category = new Category("drama");
    	repository.save(category);
    	assertThat(category.getId()).isNotNull();
    }    
        
    @Test
    public void deleteCategory() {  	
    	repository.deleteById(1L);
    	Iterable<Category> categories = repository.findAll();
    	assertThat(categories).hasSize(1);
    }
}



