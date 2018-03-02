package cn.store.dao;

import java.util.List;

public interface BaseDao<T> {
	//增加
	int inSert(String sql,Object...params);
	//删除
	int delet(String sql,Object...params);
	//查询单个
	T  getBean(String sql,Object...params);
	//查询多个
	List<T> getList(String sql,Object...params);
	//修改商品
	int update(String sql,Object...params);

	// 专门用来处理批量操作
	int[] batch(String sql,Object[][] params);
}
