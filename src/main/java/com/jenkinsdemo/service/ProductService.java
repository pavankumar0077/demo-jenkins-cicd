package com.jenkinsdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jenkinsdemo.model.Product;
import com.jenkinsdemo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public String getYourName(String name) {
		return "Hello " + name;
	}
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> getProducts(){
		return repository.getAllProducts();
	}

	public Product getProductById(int id) {
		return repository.findById(id);
	}
	
	public String deleteProduct(int id) {
		repository.delete(id);
		return "product removed !! " + id;
	}
	
	public Product updateProduct(Product product) {
		return repository.update(product);
	}
}
