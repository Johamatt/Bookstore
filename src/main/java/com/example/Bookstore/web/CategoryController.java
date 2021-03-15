package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	

	
	@Autowired
	private CategoryRepository repo;
	
	
	@RequestMapping(value="/categorylist", method = RequestMethod.GET)
	public String readCategory(Model model) {
		model.addAttribute("categories", repo.findAll());
		return "categorylist";
	}
	
	@RequestMapping(value="/newcategory", method = RequestMethod.GET)
	public String getCategory () {
		return "newcategory";
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String createCategory(@ModelAttribute Category category) {
		repo.save(category);
		return "redirect:/categorylist";
	}
	
	
}