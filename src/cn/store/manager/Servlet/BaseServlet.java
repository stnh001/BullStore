package cn.store.manager.Servlet;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

public class BaseServlet extends HttpServlet {
	
	 protected void service(HttpServletRequest request, HttpServletResponse response){
		 try {
			 //post请求，服务器默认使用iso8859-1编码表来解码。
			 //所以我们在获取参数之前设置编码为UTF-89
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 response.setContentType("text/html;charset=utf-8");
		 //获取也面的参数
		 String method = request.getParameter("method");
		 Class<? extends BaseServlet> clazz = this.getClass();
		 try {
			Method thisMothed = clazz.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			// 取消语法检测
			thisMothed.setAccessible(true);
			String  result = (String) thisMothed.invoke(this, request,response);
			// 通过返回值完成请求转发
			if(result != null && !result.isEmpty()) {
				request.getRequestDispatcher(result).forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	

}
