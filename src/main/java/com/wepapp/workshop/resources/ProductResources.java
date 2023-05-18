package com.wepapp.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wepapp.workshop.entity.Product;
import com.wepapp.workshop.services.ProductServices;

@RestController
@RequestMapping("/products")
public class ProductResources {

	@Autowired
	private ProductServices service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findall() {	
		List<Product> list = service.findall();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
