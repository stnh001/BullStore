package cn.store.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.regexp.internal.recompile;

import cn.store.dao.OrderDao;
import cn.store.domain.Order;
import cn.store.domain.User;
import cn.store.utils.C3P0Utils;

public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {

	@Override
	public int createOrder(Order order) {
		String sql="insert into bs_order (orderid,totalmony,state,userid,createdate)"
				+ "values(?,?,?,?,?)";
		this.inSert(sql,order.getOrderid(),order.getTotalMony(),order.getState(),order.getUserid(),new Date());
		
		return order.getOrderid();
	}
	
	
	
	
	//查看订单
	public List<Order> chekOrder(Integer integer){
		String sql="SELECT *FROM bs_order WHERE userid=? ORDER BY createdate DESC";
		List<Order> bean = this.getList(sql, integer);
		return 	bean;
	}
	


}
