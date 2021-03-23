package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class) 
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test  
    public void findByUsernameAndEmailReturnUser() {
        User user = repository.findByUsername("user"); 
        List<User>users = repository.findByEmail("user@gmail.com");
        
        assertThat(user).isNotNull();
        assertThat(users.get(0).getUsername().equals(user.getUsername()));

    }
    
    @Test 
    public void createNewUser() {
    	User user = new User("john123", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","john@gmail.com", "USER");
    	repository.save(user);
    	assertThat(user.getId()).isNotNull();
    }    
        
    @Test
    public void deleteUser() {  	
    	repository.deleteById(1L);
    	Iterable<User> users = repository.findAll();
    	assertThat(users).hasSize(1);
    }
}


