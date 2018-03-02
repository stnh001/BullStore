package cn.store.manager.service;

import javax.servlet.http.HttpServletRequest;

import cn.store.dao.impl.ProductDaomImpl;
import cn.store.domain.Order;
import cn.store.domain.PageBean;
import cn.store.domain.Product;

public class ProductService {
	
	public PageBean<Product> seletProductList(String currentPage){
		PageBean<Product> pageBean=new PageBean<>();
		int current=1;
		try {
			current = Integer.parseInt(currentPage);
		} catch (Exception e) {
			
		}
		
		//设置当前页面
		pageBean.setCurrentPage(current);
		//设置每页显示的个数
		pageBean.setPageSize(4);
		
		ProductDaomImpl productDaomImpl=new ProductDaomImpl();
		
		PageBean<Product> beanlist = productDaomImpl.seletProductList(pageBean);
		
		return beanlist;
	}
	//修改商品
	public int updateProduct(Product product){
		ProductDaomImpl productDaomImpl=new ProductDaomImpl();
		int i = productDaomImpl.updateProduct(product);
		return i;
	}
	//删除商品
	public int deletProduct(String id){
		ProductDaomImpl productDaomImpl=new ProductDaomImpl();
		int i = productDaomImpl.deletProduct(Integer.parseInt(id));
		return i;
	}
	//查询单个商品
	public Product getProductBean(String id){
		ProductDaomImpl productDaomImpl=new ProductDaomImpl();
		Product productBean = productDaomImpl.getProductBean(Integer.parseInt(id));
		return productBean;
	}
	//根据价格查询商品
	public PageBean<Product> selectProcutByProcie(String currentPage,String min,String max,int pageSize){
		int current=1;
		try {
			current = Integer.parseInt(currentPage);
		} catch (Exception e) {
			
		}
		int minn=Integer.MIN_VALUE;
		
		try {
			minn=Integer.parseInt(min);
		} catch (Exception e) {
			
		}
		int maxx=Integer.MAX_VALUE;
		try {
			
		} catch (Exception e) {
			maxx=Integer.parseInt(max);
		}
		PageBean<Product> pageBean=new PageBean<>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(current);
		
		ProductDaomImpl productDaomImpl=new ProductDaomImpl();
		PageBean<Product> bean = productDaomImpl.selectProductByPrice(pageBean, minn, maxx);
		return bean;
		
	}
	

}
