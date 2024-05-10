package com.example.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Product;
import com.example.service.IProductCRUDService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/product/crud")
public class ProductCRUDController {

	@Autowired
	private IProductCRUDService crudService;

	@GetMapping("/all")
	public String getProductCRUDAll(Model model) {

		try {
			model.addAttribute("mydata", crudService.retriveAll());
			model.addAttribute("msg","Products shown from JAVA");
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
	public String postProductCRUDInsert(@Valid Product product, BindingResult result) {

		if (result.hasErrors()) {
			return "product-insert-page";
		} else {
			crudService.create(product);
			System.out.print(product);
			return "product-insert-page";
		}

	}

	@GetMapping("/update/{id}") // localhost:8080/product/crud/update/1
	public String getProductCRUDUpdateById(@PathVariable("id") int id, Model model) {

		try {
			Product productForUpdating = crudService.retriveById(id);
			model.addAttribute("product", productForUpdating);
			model.addAttribute("id");
			return "product-update-page";

		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}

	}

	@PostMapping("/update/{id}")
	public String postPorductCRUDUpdateById(@PathVariable("id") int id, @Valid Product product, BindingResult result,
			Model model) {

		try {
			crudService.updateById(id, product);
			return "redirect:/product/crud/all";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}

	}
	
	@GetMapping("/delete/{id}")
	public String getProductCRUDDeleteById(@PathVariable("id") int id, Model model) {
		
		try {
			crudService.deleteById(id);
			ArrayList<Product>allProducts = crudService.retriveAll();
			model.addAttribute("mydata",allProducts);
			return "product-show-many-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
}
