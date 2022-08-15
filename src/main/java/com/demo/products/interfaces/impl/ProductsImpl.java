package com.demo.products.interfaces.impl;

import javax.annotation.ManagedBean;

import com.demo.products.interfaces.Products;

@ManagedBean
public class ProductsImpl implements Products {
	int productId;
	String productName;
	boolean visible;
	int orderNumber;

	public ProductsImpl() {

	}

	public ProductsImpl(int productId,String productName, boolean visible, int orderNumber) {
		this.productId = productId;
		this.productName = productName;
		this.visible = visible;
		this.orderNumber = orderNumber;
	}

	@Override
	public int getProductId() {
		return this.productId;
	}

	@Override
	public String getProductName() {
		return this.productName;
	}

	@Override
	public boolean isVisible() {
		return this.visible;
	}

	@Override
	public int getOrderNumber() {
		return this.orderNumber;
	}

}
