package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Product;
import com.example.service.IProductCRUDService;

@Controller
@RequestMapping("/product/crud")
public class ProductCRUDController {

	@Autowired
	private IProductCRUDService crudService;

	@GetMapping("/all")
	public String getProductCRUDAll(Model model) {

		try {
			model.addAttribute("mydata", crudService.retriveAll());
			return "product-show-many-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}

	}

	@GetMapping("/product")
	public String getProductId(@RequestParam("id") int id, Model model) {
		
		try {
			model.addAttribute("mydata", crudService.retriveById(id));
			return "product-show-one-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}

		
	}
	
	@GetMapping("/product/{id}")
	public String getProductId2(@PathVariable("id") int id, Model model) {
		
		try {
			model.addAttribute("mydata", crudService.retriveById(id));
			return "product-show-one-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}

		
	}
	
	@GetMapping("/insert")
	public String getProductCRUDInsert(Model model) {
		
		model.addAttribute("product", new Product());
		
		return "product-insert-page";
	}
	
	@PostMapping("/insert")
	public String postProductCRUDInsert(Product product) {
		
		
		System.out.print(product);
		return "product-insert-page";
	}

}
