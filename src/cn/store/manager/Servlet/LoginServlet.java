package cn.store.manager.Servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.store.domain.User;
import cn.store.manager.service.CookieServce;
import cn.store.manager.service.UserService;

public class LoginServlet extends BaseServlet {

	public String login(HttpServletRequest request,HttpServletResponse response){
		Map<String, String[]> map = request.getParameterMap();
		User user=new User();
		try {
			BeanUtils.populate(user, map);
			/*System.out.println("http://"+request.getServerName()+request.getServerPort()+request.getRequestURI());*/
			
			UserService userService=new UserService();
			boolean flag = userService.login(user);
			if(flag){
				request.getSession().setAttribute("user", user);
				CookieServce.createUserNameCookie(user.getUsername(),user.getPassword(),response);
				response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
				return null;
			}else{
				String msg="账号或者密码错误";
				request.setAttribute("msg", msg);
				return "/pages/user/login.jsp";
			}
			
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String  logout(HttpServletRequest request,HttpServletResponse response){
		request.getSession().invalidate();
		return "index.jsp";
	}
	

}
