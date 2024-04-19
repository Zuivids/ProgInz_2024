package com.example.service;

import java.util.ArrayList;

import com.example.model.Product;

public interface IProductCRUDService {
	
	//CRUD - create - retrive - update - delete
	
	public abstract void create(Product product);
	
	public abstract Product retriveById(int id);
	
	public abstract ArrayList<Product> retriveAll();
	
	public abstract void updateById(int id , Product product);
	
	public abstract void deleteById(int id);
	
	
	
}
