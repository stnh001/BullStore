package cn.store.client.Servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.commons.beanutils.BeanUtils;

import cn.store.domain.PageBean;
import cn.store.domain.Product;
import cn.store.manager.Servlet.BaseServlet;
import cn.store.manager.service.CookieServce;
import cn.store.manager.service.ProductService;
import cn.store.manager.service.UserService;
import cn.store.utils.WEBUtils;

public class ProductServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	//分页查询商品信息
	public String selectProduct(HttpServletRequest request,HttpServletResponse response){
		UserService service=new UserService();
		if(!service.idLogin(request)){
			try {
				response.sendRedirect(request.getContextPath()+"/pages/user/login.jsp");
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 获取请求地址的路径
		String sb = WEBUtils.getRealPath(request);
		String currentPage = request.getParameter("currentPage");
		
//		String currentPage = request.getParameter(cPage);
		ProductService productService=new ProductService();
		PageBean<Product> productList = productService.seletProductList(currentPage);
		productList.setPath(sb.toString());
		request.setAttribute("productList", productList);
		return "pages/manager/product_manager.jsp";
		
	}
	//获取单个产品的信息
	public String getProductBean(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		ProductService productService=new ProductService();
		Product productBean = productService.getProductBean(id);
		request.setAttribute("product", productBean);
		System.out.println(productBean);
		return "pages/manager/product_edit.jsp";
	}
	//修改商品
	public String updateProductbean(HttpServletRequest request,HttpServletResponse response){

		String header = request.getParameter("referer");
		System.out.println(header);
		Map<String, String[]> map = request.getParameterMap();
		Product product=new Product();
		ProductService productService=new ProductService();
		try {
			BeanUtils.populate(product, map);
			
			productService.updateProduct(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			response.sendRedirect(header);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	//删除商品 
	public String deletProductBean(HttpServletRequest request,HttpServletResponse response){
		String parameter = request.getHeader("Referer");
		String id = request.getParameter("id");
		Product product=new Product();
		ProductService productService=new ProductService();
		productService.deletProduct(id);
		try {
			response.sendRedirect(parameter);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String selectProductByProcie(HttpServletRequest request,HttpServletResponse response){
		String parameter = request.getParameter("");
		
		
		
		
		return null;
		
	}
	
	
	
	
	
}