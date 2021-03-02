package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repo;
	
	@Autowired
	private CategoryRepository repo2;
	
	@GetMapping("/booklist")
	public String getBooks(Model model) {
		model.addAttribute("books", repo.findAll());
		model.addAttribute("categories", repo2.findAll());
		return "booklist";
	}
	
	@PostMapping("/save")
	public String postBook(@ModelAttribute Book book) {
		repo.save(book);

		return "redirect:/booklist";
	}
	
	@PostMapping("/update")
	public String putBook(@ModelAttribute Book book) {	
		repo.save(book);
		return "redirect:/booklist";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable Long id) {
		repo.deleteById(id);		
		return "redirect:/booklist";
	}
	
}
