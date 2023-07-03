package com.main.sbp.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.sbp.redis.entity.Product;
import com.main.sbp.redis.repository.ProductDao;
import com.main.sbp.redis.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public Product save(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.findAllProducts();
	}

	@GetMapping("/{id}")
	public Product findProduct(@PathVariable int id) {
		return productService.findProductById(id);
	}

	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id) {
		return productService.deleteProduct(id);
	}
}
