package cn.store.dao;

import java.util.List;

import cn.store.domain.User;

public interface UserDao<T> {
	T getUserBean(User user);
	List<T> getUserList();
}
