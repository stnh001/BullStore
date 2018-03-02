package cn.store.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.store.dao.ProductDao;
import cn.store.dao.impl.BaseDaoImpl;
import cn.store.dao.impl.ItemDaoImpl;
import cn.store.dao.impl.ProductDaomImpl;
import cn.store.dao.impl.UserDaoImpl;
import cn.store.domain.Cart;
import cn.store.domain.CartItem;
import cn.store.domain.PageBean;
import cn.store.domain.Product;
import cn.store.domain.User;
import cn.store.manager.service.OrderService;
import cn.store.manager.service.ProductService;
import cn.store.utils.MD5Utils;

public class ItBullTest {
	
	@Test
	public void getUser(){
		User bean=new User();
		bean.setUsername("adm");
		bean.setPassword("123656");
		UserDaoImpl user=new UserDaoImpl();
		User userBean = user.getUserBean(bean);
		System.out.println(userBean);
	}

	@Test
	public void getListUser(){
		UserDaoImpl user=new UserDaoImpl();
		List<User> userList = user.getUserList();
		System.out.println(userList);
	}
	@Test
	public void getInsertUser(){
		UserDaoImpl user=new UserDaoImpl();
		User bean=new User();
		bean.setUsername("admin1");
		bean.setPassword("123656");
		bean.setEmail("635446169@qq.com");
		int i = user.inserUser(bean);
	}
	@Test
	public void getPageBean(){
	/*	ProductService service=new ProductService();
		PageBean<Product> seletProductList = service.seletProductList(3);
		List<Product> t = seletProductList.getT();
		for (Product product : t) {
			System.out.println(product);
		}
		System.out.println("----------");
		System.out.println(seletProductList.getTotalPage());*/
	}
	@Test
	public void updatProduct(){
		ProductDaomImpl productDaomImpl=new ProductDaomImpl();
		Product product=new Product();
		product.setName("羊蹄子");
		product.setAddress("荷兰");
		product.setPrice(8.0);
		product.setSales(100);
		product.setStock(100);
		product.setImgPath("/static/img/default.jpg");
		product.setId(32);
		productDaomImpl.updateProduct(product);
		
	}
	@Test
	public void selectProductByPrice(){
		ProductService service=new ProductService();
		PageBean<Product> product = service.selectProcutByProcie("1", "a", "b", 4);
		List<Product> datas = product.getDatas();
		for (Product product2 : datas) {
			System.out.println(product2);
		}
		/*ProductDaomImpl productDaomImpl=new ProductDaomImpl();
		PageBean<Product> pageBean=new PageBean<>();
		pageBean.setCurrentPage(1);
		pageBean.setPageSize(4);
		PageBean<Product> product = productDaomImpl.selectProductByPrice(pageBean,10,20);
		List<Product> datas = product.getDatas();
		for (Product product2 : datas) {
			System.out.println(product2);
		}*/
	}
	@Test
	public void getStrList(){
		UserDaoImpl user=new UserDaoImpl();
		List<String> seletUserEmail = user.seletUserEmail();
		for (String string : seletUserEmail) {
			System.out.println(string);
		}
	}
	@Test
	public void getMdString(){
		String md5 = MD5Utils.md5("344809958@qq.com");
		System.out.println(md5);
	}
	@Test
	public void addProduct(){ 
		ProductService  service=new ProductService();
		Product productBean = service.getProductBean("57");
		Product productBean1 = service.getProductBean("58");
		Product productBean2 = service.getProductBean("59");
		Product productBean3 = service.getProductBean("60");
		Cart  cart=new Cart();
		cart.addProductToMap(productBean);
		cart.addProductToMap(productBean);
		cart.addProductToMap(productBean);
		cart.addProductToMap(productBean1);
		cart.addProductToMap(productBean2);
		cart.addProductToMap(productBean3);
		List<CartItem> cartItemList = cart.getCartItemList();
		for (CartItem cartItem : cartItemList) {
			System.out.println(cartItem);
		}
		System.out.println(cart.getTotalMony());
 		
	}
	@Test
	public void getTotal(){
		ItemDaoImpl daoImpl=new ItemDaoImpl();
		double selectTotal = daoImpl.selectTotal(1756081512);
		System.out.println(selectTotal);
	}
	
	@Test
	public void doCount(){
		List<User> list=new ArrayList<>();
		list.add(new User(null,"luwan5","123456","344809958@qq.com"));
		list.add(new User(null,"luwan1","123","344809958@qq.com"));
		list.add(new User(null,"luwan2","123","344809958@qq.com"));
		list.add(new User(null,"luwan3","123","344809958@qq.com"));
		Object[][] Ob=new Object[list.size()][];
		UserDaoImpl daoImpl=new UserDaoImpl();
		for (int i = 0; i < list.size(); i++) {
			User user = list.get(i);
			Ob[i]=new Object[]{user.getId(),user.getUsername(),user.getPassword(),user.getEmail()};
		}
		daoImpl.batch(Ob);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
