package com.demo.products.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.products.entity.ProductsEntity;
import com.demo.products.impl.ProductsImpl;
import com.demo.products.interfaces.Products;
import com.demo.products.repository.ProductsRepository;

@ManagedBean
public class ProductsDao {
	
	@Autowired
	ProductsRepository productsRepository;

	public Products getProductfromId(int product_id) {
		Optional<ProductsEntity> product = productsRepository.findById(product_id);
		ProductsEntity productsEntity = product.get();
		Products products = new ProductsImpl(productsEntity.getId(), productsEntity.getProductName(), productsEntity.isVisible()
				, productsEntity.getOrder());
		return products;
	}
	
	public List<Products> getAllProducts(){
		List<ProductsEntity> list = productsRepository.findAll();
		List<Products> pList = new ArrayList<Products>();
		for(ProductsEntity productsEntity : list) {
			pList.add(new ProductsImpl(productsEntity.getId(), productsEntity.getProductName(), productsEntity.isVisible()
					, productsEntity.getOrder()));
		}
		return pList;
	}

	public String createProduct(Products product) throws RuntimeException{
		ProductsEntity productsEntity = getProductEntity(product);
		try{
			productsRepository.save(productsEntity);
		} catch (RuntimeException rException){
			rException.printStackTrace();
			return "error";
		}
		return "success";
	}

	public ProductsEntity getProductEntity(Products product){
		return new ProductsEntity(product.getProductName(), product.isVisible(), 1);
	}

	public String updatePrduct(Products product, int id) throws RuntimeException{
		Optional<ProductsEntity> productById = productsRepository.findById(id);
		if(productById.isPresent()){
			ProductsEntity productsEntity = getProductEntity(product);
			productsEntity.setId(id);
			try{
				productsRepository.save(productsEntity);
			} catch (RuntimeException rException){
				rException.printStackTrace();
				return "error in Put";
			}
			return "success in Put";
		}
		return id +" id is not present in Database";
	}

	public void deleteProduct(int id){
		try {
			productsRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
