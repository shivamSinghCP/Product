package com.demo.products.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TProducts")
public class ProductsEntity {

	public ProductsEntity(){
		super();
	}

	public ProductsEntity(String productName, boolean visible, int order ){
		this.productName = productName;
		this.visible = visible;
		this.order = order;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;

	@Column(name ="product_name")
	private String productName;
	
	@Column(name = "visibility_ind")
	private boolean visible;
	
	@Column(name = "ordernumber")
	private int order;

	public int getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public boolean isVisible() {
		return visible;
	}

	public int getOrder() {
		return order;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
}
