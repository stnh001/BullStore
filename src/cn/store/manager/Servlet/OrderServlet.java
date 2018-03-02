package cn.store.manager.Servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.store.domain.Cart;
import cn.store.domain.CartItem;
import cn.store.domain.Iterm;
import cn.store.domain.Order;
import cn.store.domain.Product;
import cn.store.manager.service.OrderService;
import cn.store.manager.service.ProductService;
import cn.store.utils.WEBUtils;

public class OrderServlet extends BaseServlet {

	public String addOrder(HttpServletRequest request, HttpServletResponse response) {
		
		
		String id = request.getParameter("pri");
		/*
		 * String befheader = request.getParameter("befoer");
		 * System.out.println(befheader);
		 */
		ProductService service = new ProductService();
		Product productBean = service.getProductBean(id);
		String name = productBean.getName();
		 response.setContentType("text/html;charset=UTF-8");
		
		Cart cart;
		if (request.getSession().getAttribute("cart") == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		} else {
			cart = (Cart) request.getSession().getAttribute("cart");
		}

		cart.addProductToMap(productBean);
		/* request.getSession().setAttribute("cart", cart); */
		//获取请求地址
		String string = WEBUtils.getFrontPath(request);
		
		try {
			response.getWriter().write(name);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
//			request.getRequestDispatcher(string).forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}


	//创建购物车列表
	public void createCartList(HttpServletRequest request,HttpServletResponse response) {
		
	}

	

	public String getOrder(HttpServletRequest request, HttpServletResponse response) {
		Cart cat = (Cart) request.getSession().getAttribute("cart");
		if (cat != null) {
			List<CartItem> cartItemList = cat.getCartItemList();
		}

		try {
			response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	//删除购物我车的内容
	public String deletOrder(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Cart cat = (Cart) request.getSession().getAttribute("cart");
		cat.deletProduct(id);
		try {
			response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	
	//创建订单
	public String createOder(HttpServletRequest request, HttpServletResponse response){
		OrderService service=new OrderService();
		int numner = service.creatOrder(request,response);
		
		response.setHeader("Refresh", "6;URL="+request.getContextPath()+"/index.jsp");
		request.setAttribute("numner", numner);
		return "pages/cart/checkout.jsp";
		
	}
	//查看订单
	public String chekOrder(HttpServletRequest request, HttpServletResponse response){
		OrderService service=new OrderService();
		List<Order> order = service.chekOrder(request, response);
		request.setAttribute("order", order);
		return "pages/order/order.jsp";
	}
	//查看订单详情
	public String chekOrderDetail(HttpServletRequest request, HttpServletResponse response){
		String orderid = request.getParameter("orderid");
		OrderService service=new OrderService();
		List<Iterm> itermList = service.selectList(Integer.parseInt(orderid));
		request.setAttribute("itermList", itermList);
		return "pages/order/order_detail.jsp";
		
	}
	
	
	
}
