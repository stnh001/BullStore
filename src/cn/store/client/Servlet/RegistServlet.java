package cn.store.client.Servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;
import org.apache.commons.beanutils.BeanUtils;

import cn.store.domain.User;
import cn.store.manager.service.UserService;

public class RegistServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String[]> map = request.getParameterMap();
		UserService userService=new UserService();
		User user=new User();
		try {
			//封装数据
			BeanUtils.populate(user, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String browsercode = request.getParameter("code");
		
		String  hostcode = (String) request.getSession().getAttribute("invalidateCode");
		if(browsercode!=null&&browsercode.equals(hostcode)){
			int i = userService.registerUser(user);
			if(i>0){
				response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
			}else{
				request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("mgs", "验证码错误");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
		request.getSession().invalidate();
		
		
		
		
		
		
		 
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
