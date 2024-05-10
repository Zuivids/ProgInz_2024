package com.example.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.model.Product;

public interface IProductRepo extends CrudRepository<Product, Integer> {

	//public abstract jau pec noklusejuma
	// SELECT * FROM product_tavle WHERE title = 1 arguments AND Descrpition = 2 arguments AnNDprice = 3arguments
	Product findByTitleAndDescriptionAndPrice(String title, String description, float price);

	ArrayList<Product> findByPriceLessThan(float threshold);

	ArrayList<Product> findByQuantityLessThan(int threshold);

	ArrayList<Product> findByTitleIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(String phrase, String phrase2);

	@Query(nativeQuery = true, value = "SELECT SUM(price * quantity) FROM product_table;")
	float calcualteTotalValueFromRepoProducts();
	
	
}
