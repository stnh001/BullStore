package cn.store.dao;

import cn.store.domain.PageBean;
import cn.store.domain.Product;

public interface ProductDao <T>{
	//查询纪录总数
	int selectCount();
	//分页查询数据
	public PageBean<T> seletProductList(PageBean<T> pageBean);
	//修改商品
	public int updateProduct(Product product);
	//删除商品
	public int deletProduct(int i);
	//根据价格查找商品
	public PageBean<T> selectProductByPrice(PageBean<T> pageBean,double min,double max);
}
