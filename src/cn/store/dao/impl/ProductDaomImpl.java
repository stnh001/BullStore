package cn.store.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.regexp.internal.recompile;

import cn.store.dao.ProductDao;
import cn.store.domain.PageBean;
import cn.store.domain.Product;
import cn.store.utils.C3P0Utils;

public class ProductDaomImpl extends BaseDaoImpl<Product> implements ProductDao<Product> {
			//查询商品的总数
			public int selectCount(){
				String sql="SELECT COUNT(*) FROM bs_product";
				Long count = (Long) this.getCount(sql);
				return (int) count.longValue();
			}
			//查询分页后的商品列表

			@Override
			public PageBean<Product> seletProductList(PageBean<Product> pageBean) {
				//获取商品的总数量
				int totalRecord = selectCount();
				pageBean.setTotalRecord(totalRecord);
				
				String sql="SELECT *from bs_product limit ?,?";
				List<Product> list = this.getList(sql,pageBean.getStartIndex(),pageBean.getPageSize());
				pageBean.setDatas(list);
				return pageBean;
			}
			//修改商品
			@Override
			public int updateProduct(Product product) {
				String sql="UPDATE bs_product SET NAME=?,address=?,price=?,sales=?,stock=?,img_path=? WHERE id=?";
				int i = this.update(sql, product.getName(),product.getAddress(),product.getPrice(),product.getSales(),product.getStock(),product.getImgPath(),product.getId());
				return i;
			}
			//删除商品
			@Override
			public int deletProduct(int i) {
				String sql="DELETE FROM bs_product WHERE id=?";
				int j = this.delet(sql,i);
				return j;
			}
			//获取单个商品
			public Product getProductBean(int i){
				String sql="select *from bs_product where id=?";
				Product product = this.getBean(sql,i);
				return product;
			}

			@Override
			public PageBean<Product> selectProductByPrice(PageBean<Product> pageBean, double min, double max) {
				//获取商品的个数
				String sql1="SELECT COUNT(*) FROM bs_product where price>? and price<?";
				Long count = (Long) this.getByCount(sql1,min,max);
				
				pageBean.setTotalRecord((int)count.longValue());
				//获取所有的商品列表
				String sql="select *from bs_product where price>? and price<? limit ?,?";
				List<Product>  list = this.getList(sql,min,max,pageBean.getStartIndex(),pageBean.getPageSize());
				pageBean.setDatas(list);
				return pageBean;
			}
			
}	
