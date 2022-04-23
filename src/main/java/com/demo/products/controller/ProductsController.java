package com.demo.products.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.demo.products.interfaces.Products;
import com.demo.products.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products")
public class ProductsController{

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET,
	produces = "application/json")
	public ResponseEntity<Products> getProduct(@PathVariable int id) {
		return ResponseEntity.ok(productService.getProduct(id));
		
	}
	
	@GetMapping("/getallproducts")
	public List<Products> getAllProducts(){
		return productService.getAllProducts();
	}

	@PostMapping("/createproduct")
	public String createProduct(@ModelAttribute @NotNull @Valid Products product){
		return productService.createProduct(product);
	}

	@PutMapping("/updateproduct")
	public String updateProduct(@ModelAttribute Products product, @RequestParam int id){
		if(id >0 && product != null){
		return productService.updateProduct(product,id);
		}
		return "error in Put from controller";
	}

	@DeleteMapping("/deleteproduct/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable int id){
		if(id>0){
			productService.deleteProduct(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
}