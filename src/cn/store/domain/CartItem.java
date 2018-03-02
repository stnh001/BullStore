package cn.store.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CartItem implements Serializable {
	//商品的信息
	private Product product;
	//商品的个数信息
	private int count;
	//商品的名称
	private String name;
	//订单的项的总价格
	double TotalPrice;

	public CartItem(Product product, int count) {
		this.product = product;
		this.count = count;
		this.name =  product.getName();
	}


	//订单项的总金额
	public double getTotalPrice(){
		return new BigDecimal(product.getPrice()+"").multiply(new BigDecimal(count+"")).doubleValue();
	}
	
	
	public CartItem() {
		super();
	}
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.TotalPrice = getTotalPrice();
		this.count = count;
	}


	@Override
	public String toString() {
		return "CartItem [count=" + count + ", name=" + name + ", TotalPrice=" + TotalPrice + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
