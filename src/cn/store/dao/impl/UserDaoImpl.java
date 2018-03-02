package cn.store.dao.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import cn.store.dao.UserDao;
import cn.store.domain.User;
import cn.store.utils.MD5Utils;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao<User> {
	//通过用户名密码获取一个对象
	@Override
	public User getUserBean(User user) {
		String sql="select *from bs_user where username=? and password=?";
		String password = MD5Utils.md5(user.getPassword());
		User bean = this.getBean(sql, user.getUsername(),password);
		return bean;
	}
	//通过用户名获取一个对象
	public User getUserBeanByName(User user) {
		String sql="select *from bs_user where username=?";
		User bean = this.getBean(sql, user.getUsername());
		return bean;
	}
	//获取对象的List集合
	@Override
	public List<User> getUserList() {
		String sql="select *from bs_user";
		List<User> list = this.getList(sql);
		return list;
	}
	//插入一个用户
	public int inserUser(User user){
		String sql="insert into bs_user(id,username,password,email) values(?,?,?,?)";
		String password = cn.store.utils.MD5Utils.md5(user.getPassword());
		int i = this.inSert(sql, null,user.getUsername(),password,user.getEmail());
		return i;
	}
	//查询用户的邮箱
	public 	List<String>  seletUserEmail(){
		String sql="select *from bs_user";
		List<String> strList=new ArrayList<>();
		List<User> list=this.getList(sql);
		for (User user : list) {
			strList.add(user.getUsername()+user.getPassword());
		}
		return strList;
	}
	//批量插入
	public int[] batch(Object[][] object){
		String sql="insert into bs_user(id,username,password,email) values(?,?,?,?)";
		int[] intarr = this.batch(sql,object);
		return intarr;
	}
	
	
	




}
