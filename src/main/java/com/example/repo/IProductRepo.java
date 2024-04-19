package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Product;

public interface IProductRepo extends CrudRepository<Product, Integer> {
	
	
}
