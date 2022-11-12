package com.jenkinsdemo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.jenkinsdemo.model.Product;

@Repository
public class ProductRepository {
	
	private List<Product> list = new ArrayList<Product>();
	
	public void createProduct() {
		list = List.of(
				new Product(1,"Samsung", 10, 13000),
				new Product(2, "Honda Shine", 2, 76000),
				new Product(3, "Dell laptop", 4, 43242)
	    );
	}
	
	public List<Product> getAllProducts() {
		return list;
	}
	
	public Product findById(int id) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == (id)) {
				return list.get(i);
			}
		}
		return null;
	}
	
	public List<Product> search(String name){
		return list.stream().filter(x -> x.getName()
				.startsWith(name)).collect(Collectors.toList());
	}
	
	public Product save(Product p) {
		Product product = new Product();
		product.setId(p.getId());
		product.setName(p.getName());
		product.setQuantity(p.getQuantity());
		product.setPrice(p.getPrice());
		list.add(product);
		return product;
	}
	
	public String delete(Integer id) {
		list.removeIf(x -> x.getId() == (id));
		return null;
	}
	
	public Product update(Product product) {
		int idx = 0;
		int id = 0;
		for(int i = 0; i< list.size(); i++) {
			if(list.get(i).getId() == (product.getId())) {
				id = product.getId();
				idx = i;
				break;
			}
		}
		
		Product product1 = new Product();
		product1.setId(id);
		product1.setName(product.getName());
		product1.setQuantity(product.getQuantity());
		product1.setPrice(product.getPrice());
		list.set(idx ,product);
		return product1;
		
	}

}
