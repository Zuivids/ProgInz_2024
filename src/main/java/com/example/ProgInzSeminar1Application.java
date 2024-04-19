package com.example;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.Product;
import com.example.repo.IProductRepo;

@SpringBootApplication
public class ProgInzSeminar1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgInzSeminar1Application.class, args);
	}

	@Bean  //funkcija tiks izsaukta automatiski, lidz ko palaizhas sistema
	public CommandLineRunner testDatabase(IProductRepo productRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				// TODO izveidot 3 produktus
				Product p1 = new Product("Zimulis", "Tas ir zimulis", 9, 1.99f);
				Product p2 = new Product("Ziepes", "Tas ir ziepes", 92, 4.5f);
				Product p3 = new Product("Zeke", "Ta ir zeke", 1, 7.99f);
				//ar save funckiju saglabat repo
				productRepo.save(p1);
				productRepo.save(p2);
				productRepo.save(p3);
				// izsaukt caur repo count()
				System.out.println("How many products: "+productRepo.count());
				// izsaukt caur repo findByID()
				System.out.println("Get  product by id (1): "+productRepo.findById(1).get());
				
				
				
		
				Product productForDeleting = productRepo.findById(1).get();
				productRepo.delete(productForDeleting);
				// uztaisit update caur repo
				Product productForUpdating = productRepo.findById(2).get();
				productForUpdating.setPrice(0.99f);
				productRepo.save(productForUpdating);
			}
		};
	}

}
