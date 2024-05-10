package com.example.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Product;
import com.example.service.IProductFilteringService;

@Controller
@RequestMapping("/product/filter")
public class ProductFilterController {

	@Autowired
	private IProductFilteringService filterService;
	
	
	@GetMapping("/price/{param}")
	public String getProductFilterByPrice(@PathVariable("param") float param, Model model) {
		
		try {
			ArrayList<Product> result = filterService.filterByPriceLess(param);
			model.addAttribute("mydata",result);
			model.addAttribute("msg","Products filtered by price");
			return "product-show-many-page";
			
		}catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/quantity/{param}")
	public String getProductFilterByQuantity(@PathVariable("param") int param, Model model) {
		
		try {
			ArrayList<Product> result = filterService.filterByQuantityLess(param);
			model.addAttribute("mydata",result);
			model.addAttribute("msg","Products filtered by quantity");
			return "product-show-many-page";
			
		}catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/text/{param}")
	public String getProductFilterByTitleOfDescription(@PathVariable("param") String param, Model model) {
		
		try {
			ArrayList<Product> result = filterService.filterByTitleOrDescription(param);
			model.addAttribute("mydata",result);
			model.addAttribute("msg","Products filtered by phrase");
			return "product-show-many-page";
			
		}catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
	
}
