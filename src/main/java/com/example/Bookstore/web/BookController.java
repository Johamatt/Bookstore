package com.example.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;


@CrossOrigin
@Controller
public class BookController {
	
	// Login page
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@Autowired
	private BookRepository repo;
	
	@Autowired
	private CategoryRepository repo2;
	
	@RequestMapping(value="/booklist", method = RequestMethod.GET)
	public String getBooks(Model model) {
		model.addAttribute("books", repo.findAll());
		model.addAttribute("categories", repo2.findAll());
		return "booklist";
	}
	
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String postBook(@ModelAttribute Book book) {
		repo.save(book);

		return "redirect:/booklist";
	}
	

	@RequestMapping(value="/update", method = RequestMethod.PUT)
	public String putBook(@ModelAttribute Book book) {	
		repo.save(book);
		return "redirect:/booklist";
	}


	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable Long id) {
		repo.deleteById(id);		
		return "redirect:/booklist";
	}
	
	
	//rest
	@RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repo.findAll();
    }    

    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
    	return repo.findById(bookId);
    }      
    
    @RequestMapping(value="/books", method = RequestMethod.POST)
    public @ResponseBody Book saveBookRest(@RequestBody Book book) {	
    	return repo.save(book);
    }
	
		
	
}
