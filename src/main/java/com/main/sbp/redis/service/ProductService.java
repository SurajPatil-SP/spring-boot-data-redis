package com.main.sbp.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
	
	@Cacheable(key = "#id", value = "Product", unless = "#result.price > 1000")
	public Product findProductById(int id) {
		return dao.findProductById(id);
	}
	
	@CacheEvict(key = "#id", value = "Product")
	public String deleteProduct(int id) {
		
		return dao.deleteProduct(id);
	}
	
	@CachePut(key = "#id", value = "Product")
	public boolean updateProduct(Long id, Product product) {
        return dao.updateProduct(id, product);
    }
}
