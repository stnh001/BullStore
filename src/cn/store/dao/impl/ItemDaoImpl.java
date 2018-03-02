package cn.store.dao.impl;

import java.util.List;

import cn.store.dao.ItemDao;
import cn.store.domain.Cart;
import cn.store.domain.CartItem;
import cn.store.domain.Iterm;
import cn.store.domain.Product;

public class ItemDaoImpl extends BaseDaoImpl<Iterm> implements ItemDao {

	@Override
	public int createItem(Cart cart, CartItem cartItem,int orderid) {
		
		String sql="insert into bs_iterm(itermid,product_name,product_price,product_img,orderid,count)"
				+ "values(?,?,?,?,?,?) ";
		Product product = cartItem.getProduct();
		int i = this.inSert(sql,null, product.getName(),product.getPrice(),product.getImgPath(),orderid,cartItem.getCount());
		return i;
	}
	//批量操作订单
		public int[] inserListOrder(Object[][] obj){
			String sql="insert into bs_iterm(product_name,product_price,product_img,orderid,count)"
				+ "values(?,?,?,?,?) ";
			int[] batch = this.batch(sql, obj);
			return batch;
		}
	//查找订单详情
	public List<Iterm> selectList(int orderid){
		String sql="SELECT product_name productName,product_price productPrice,product_img productImg,orderId,COUNT FROM bs_iterm WHERE orderid=?";
		double total = selectTotal(orderid);
		List<Iterm> list = this.getList(sql, orderid);
		for (Iterm iterm : list) {
			iterm.setTotalmony(total);
		}
		return list;
	}
	//查询总金额
	public double selectTotal(int orderid){
		String sql1="SELECT totalmony FROM bs_order WHERE orderid=?";
		double  totalmony =  (double) this.getByCount(sql1, orderid);
		return totalmony;
	}

}
