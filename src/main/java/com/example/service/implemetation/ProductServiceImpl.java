package com.example.service.implemetation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.IProductFilteringService;
import com.example.model.Product;
import com.example.repo.IProductRepo;
import com.example.service.IProductCRUDService;

@Service
public class ProductServiceImpl implements IProductCRUDService, IProductFilteringService{

	@Autowired
	private IProductRepo productRepo;
	
	
	@Override
	public ArrayList<Product> filterByPrice(float threshold) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> filterByQuantityLess(int threshold) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> filterByTitleOrDescription(String phrase) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float calculateTotalValueOfProducts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void create(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product retriveById(int id) {
		
		
		
		return null;
	}

	@Override
	public ArrayList<Product> retriveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateById(int id, Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
