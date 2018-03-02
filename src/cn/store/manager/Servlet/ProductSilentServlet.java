package cn.store.manager.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.store.domain.PageBean;
import cn.store.domain.Product;
import cn.store.manager.service.ProductService;
import cn.store.utils.WEBUtils;

public class ProductSilentServlet extends BaseServlet {

		//分页查询商品信息
		public String selectProduct(HttpServletRequest request,HttpServletResponse response){
			// 获取请求地址的路径
			String sb = WEBUtils.getRealPath(request);
			String currentPage = request.getParameter("currentPage");
//			String currentPage = request.getParameter(cPage);
			ProductService productService=new ProductService();
			PageBean<Product> productList = productService.seletProductList(currentPage);
			productList.setPath(sb.toString());
			request.setAttribute("productList", productList);
			return "pages/manager/product_list.jsp";
			
		}
		

}