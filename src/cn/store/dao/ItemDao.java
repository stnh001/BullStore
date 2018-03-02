package cn.store.dao;

import cn.store.domain.Cart;
import cn.store.domain.CartItem;

public interface ItemDao {
	//插入商品
	int createItem(Cart cart,CartItem cartItem,int orderid);

	
}
