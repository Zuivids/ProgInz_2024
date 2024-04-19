package com.example.service;

import java.util.ArrayList;

import com.example.model.Product;

public interface IProductFilteringService {

	public abstract ArrayList<Product> filterByPrice(float threshold);
	
	public abstract ArrayList<Product> filterByQuantityLess(int threshold);
	
	public abstract ArrayList<Product> filterByTitleOrDescription(String phrase);
	
	public abstract float calculateTotalValueOfProducts();
	
	
}
