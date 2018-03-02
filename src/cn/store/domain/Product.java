package cn.store.domain;

import java.io.Serializable;

public class Product implements Serializable {

	private Integer id;		// 商品的id
	private String name;	// 商品的名称
	private String address;	// 商品的地址
	private double price;	// 商品的价格
	private int sales;		// 商品的销量
	private int stock;		// 商品的库存
	private String imgPath = "static/img/default.jpg";	// 商品的图片
	public Product() {
		super();
	}
	public Product(Integer id, String name, String address, double price, int sales, int stock, String imgPath) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.price = price;
		this.sales = sales;
		this.stock = stock;
		this.imgPath = imgPath;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", address=" + address + ", price=" + price + ", sales=" + sales
				+ ", stock=" + stock + ", imgPath=" + imgPath + "]";
	}
}
