package cn.store.manager.service;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.store.dao.UserDao;
import cn.store.dao.impl.ItemDaoImpl;
import cn.store.dao.impl.OrderDaoImpl;
import cn.store.dao.impl.UserDaoImpl;
import cn.store.domain.Cart;
import cn.store.domain.CartItem;
import cn.store.domain.Iterm;
import cn.store.domain.Order;
import cn.store.domain.User;

public class OrderService {
	public int creatOrder(HttpServletRequest request,HttpServletResponse response){
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		User user = (User) request.getSession().getAttribute("user");
		UserDaoImpl userDao=new UserDaoImpl();
		User userBean = userDao.getUserBean(user);
		int orderId=(int) System.currentTimeMillis()+userBean.getId();
		
		Order order=new Order(orderId,cart.getTotalMony(),0,userBean.getId());
		OrderDaoImpl orderDaoImpl=new OrderDaoImpl();
		ItemDaoImpl impl=new ItemDaoImpl();
		
		orderDaoImpl.createOrder(order);
		List<CartItem> list = cart.getCartItemList();
		Object[][] objects=new Object[list.size()][];
		String name="";
		for (int i = 0; i < list.size(); i++) {
			CartItem cartItem = list.get(i);
			//itermid,product_name,product_price,product_img,orderid,count
			if(name!=cartItem.getProduct().getName()){
				objects[i]=new Object[]{cartItem.getProduct().getName(),cartItem.getProduct().getPrice(),
						cartItem.getProduct().getImgPath(),orderId,cartItem.getCount()};
			}
		}
		
		impl.inserListOrder(objects);
		
		
		/*for (CartItem cartItem : list) {
			if(name.equals(cartItem.getProduct().getName())){
				continue;
			}else{
				impl.createItem(cart, cartItem, orderId);
				name=cartItem.getProduct().getName();
			}
			
		}*/
		//清空购物车
		cart.clearProduct();
		
		return orderId;
	}
	//查询订单
	public List<Order> chekOrder(HttpServletRequest request,HttpServletResponse response){
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			try {
				request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		UserDaoImpl userDao=new UserDaoImpl();
		User userBean = userDao.getUserBean(user);
		OrderDaoImpl orderDaoImpl=new OrderDaoImpl();
		List<Order> chekOrder = orderDaoImpl.chekOrder(userBean.getId());
		return chekOrder;
		
	}
	//查看订单详情 
	public List<Iterm> selectList(int orderid){
		ItemDaoImpl daoImpl=new ItemDaoImpl();
		List<Iterm> itermList = daoImpl.selectList(orderid);
		return itermList;
	}

}
