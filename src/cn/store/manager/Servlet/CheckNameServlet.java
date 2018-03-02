package cn.store.manager.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.store.manager.service.UserService;

/**
 * Servlet implementation class CheckNameServlet
 */
public class CheckNameServlet extends BaseServlet {
	
	
	public void chekName(HttpServletRequest request,HttpServletResponse response){
		String value = request.getParameter("username");
		UserService userService=new UserService();
		boolean exist = userService.isExist(value.trim());
		if(exist){
			System.out.println(request.getContextPath());
			String val="{\"exist\":"+exist+"}";
			try {
				response.getWriter().write(val);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(val);
		}

	}
	

	

}
