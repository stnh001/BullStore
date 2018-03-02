package cn.store.domain;

import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable{
	private int orderid;
	private double totalMony;
	private int state;
	private int userid;
	private Date createDate;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public double getTotalMony() {
		return totalMony;
	}
	public void setTotalMony(double totalMony) {
		this.totalMony = totalMony;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Order() {

	}
	public Order(int orderid, double totalMony, int state, int userid) {
		super();
		this.orderid = orderid;
		this.totalMony = totalMony;
		this.state = state;
		this.userid = userid;
	}
	
	
}
