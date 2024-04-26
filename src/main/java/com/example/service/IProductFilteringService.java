package com.example.service;

import java.util.ArrayList;

import com.example.model.Product;

public interface IProductFilteringService {

	public abstract ArrayList<Product> filterByPriceLess(float threshold) throws Exception;
	
	public abstract ArrayList<Product> filterByQuantityLess(int threshold) throws Exception;
	
	public abstract ArrayList<Product> filterByTitleOrDescription(String phrase) throws Exception;
	
	public abstract float calculateTotalValueOfProducts() throws Exception;
	
	
}
