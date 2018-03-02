package cn.store.manager.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import cn.store.dao.impl.UserDaoImpl;
import cn.store.domain.User;

public class UserService {
	public int registerUser(User user){
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		int i = userDaoImpl.inserUser(user);
		return i;
	}
	//用户登录
	public boolean login(User user){
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		User userBean = userDaoImpl.getUserBean(user);	
		return userBean!=null;
	}
	//校验用户是否存在
	public boolean isExist(String value){
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		User user=new User();
		user.setUsername(value);
		User userBean = userDaoImpl.getUserBeanByName(user);
		return userBean!=null;
	}
	
	public boolean idLogin(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		CookieServce servce=new CookieServce();
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		boolean flag=false;
		List<String> userEmail = userDaoImpl.seletUserEmail();
		for (String string : userEmail) {
			if(CookieServce.isTmpCookie(string, request)){
				flag=true;
			}
		}
		return flag;
	}
}
