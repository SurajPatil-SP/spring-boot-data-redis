package com.main.sbp.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.sbp.redis.entity.Product;
import com.main.sbp.redis.repository.ProductDao;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;
	
	public Product saveProduct(Product product) {
		return dao.save(product);
	}
	
	public List<Product> findAllProducts() {
		return dao.findAll();
	}
	
	public Product findProductById(int id) {
		return dao.findProductById(id);
	}
	
	public String deleteProduct(int id) {
		
		return dao.deleteProduct(id);
	}
}
