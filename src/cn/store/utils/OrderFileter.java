package cn.store.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.store.domain.User;

/**
 * Servlet Filter implementation class OrderFileter
 */
public class OrderFileter extends MyFileter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
		User user = (User) request.getSession().getAttribute("user");
		String method = request.getParameter("method");
		if(!method.equals("addOrder")&&user==null){
			try {
				request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				chain.doFilter(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
