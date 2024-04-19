package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Product;

@Controller
public class FirstController {

	@GetMapping("/hello") // localhost:8080/hello
	public String getHello() {
		System.out.println("First controller works!");
		return "hello-page"; // tiks parādīta hello-page html lapa
	}

	@GetMapping("/test")
	public String getTest() {
		System.out.println("Second controller works!");
		return "test-page";
	}

	Random rand = new Random();

	@GetMapping("/hello/msg") // localhost:8080/hello/msg
	public String getHelloMsg(Model model) {
		model.addAttribute("mydata", "Ziņa no Mārtiņa ->" + rand.nextInt(0, 100));
		return "hello-msg-page"; // tiks paradita hello-msh-page.html ar padotajiem datiem
	}

	@GetMapping("/product/test") // localhost:8080/product/test
	public String getProducutTest(Model model) {
		Product product = new Product("Cukurs", "Daudz", 2, 2.99f);
		model.addAttribute("mydata", product);
		return "product-show-one-page";
	}
	
//	@GetMapping("product/list")
//	public String getProductList(Model model) {
//		ArrayList <Product> allProducts = new ArrayList<>();
//			Arrays.asList(
//					new Product("Zimulis", "Tas ir zimulis", 9, 1.99f)
//					new Product("Ziepes", "Tas ir ziepes", 92, 4.5f)
//					new Product("Zeke", "Ta ir zeke", 1, 7.99f));
//		
//		return "product-show-many-page";
//	}

}
