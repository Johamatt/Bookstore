package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	

	
	@Autowired
	private CategoryRepository repo;
	
	@GetMapping("/categorylist")
	public String readCategory(Model model) {
		model.addAttribute("categories", repo.findAll());
		return "categorylist";
	}
	
	@GetMapping("/newcategory")
	public String getCategory () {
		return "newcategory";
	}
	
	@PostMapping("/create")
	public String createCategory(@ModelAttribute Category category) {
		repo.save(category);
		return "redirect:/categorylist";
	}
	
	
}