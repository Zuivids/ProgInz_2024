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
	public Product retriveById(int id) throws Exception {
		if(id < 0) throw new Exception("Id should be positive!");
		
		if(productRepo.existsById(id)) {
			return productRepo.findById(id).get();
		}
		else {
			throw new Exception("Product with this id ("+id+")is not in system!");
		}
	}

	@Override
	public ArrayList<Product> retriveAll()throws Exception{
		
		if(productRepo.count() == 0 ) throw new Exception("Table is empty!");
	
		return (ArrayList<Product>) productRepo.findAll();
		
		
	}

	@Override
	public void updateById(int id, Product product) throws Exception {
		
		Product productForUpdating = retriveById(id);
		
		productForUpdating.setTitle(product.getTitle());
		productForUpdating.setDescription(product.getDescription());
		productForUpdating.setQuantity(product.getQuantity());
		productForUpdating.setPrice(product.getPrice());
		
		productRepo.save(productForUpdating);
	}

	@Override
	public void deleteById(int id) throws Exception{
		
		//if(id < 0) throw new Exception("Id should be positive!");
		
		productRepo.deleteById(id);
		
	}
	
	

}
