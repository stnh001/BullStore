package cn.store.domain;

public class Iterm {
	private int itermid;
	private String productName;
	private Double productPrice;
	private String productImg;
	private double totalmony;
	private int orderId;
	private int count;
	
	
	public double getTotalmony() {
		return totalmony;
	}
	public void setTotalmony(double totalmony) {
		this.totalmony = totalmony;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getItermid() {
		return itermid;
	}
	public void setItermid(int itermid) {
		this.itermid = itermid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
}
