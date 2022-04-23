package com.demo.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.products.dao.ProductsDao;
import com.demo.products.interfaces.Products;

@Service
public class ProductService {

	@Autowired
	ProductsDao productsDao;

	public ProductService() {

	}

	public Products getProduct(int product_id) {
		Products product = productsDao.getProduct(product_id);
		return product;

	}
	
	public List<Products> getAllProducts(){
		List<Products> productList = productsDao.getAllProducts();
		return productList;
	}

	public String createProduct(Products product){
		String status = productsDao.createProduct(product);
		return status;
	}

	public String updateProduct(Products product, int id){
		String status = productsDao.updateProduct(product,id);
		return status;
	}

	public void deleteProduct(int id){
		productsDao.deleteProduct(id);
	}
}
