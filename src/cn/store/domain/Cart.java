package cn.store.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import cn.store.manager.service.ProductService;

public class Cart implements Serializable {
	LinkedHashMap<String, CartItem> map=new LinkedHashMap<>();
	//通过id添加商品
	public void addProductToMap(Product product){
		if(map.containsKey(product.getId().toString())){
			CartItem cartItem = map.get(product.getId().toString());
			cartItem.setCount(cartItem.getCount()+1);
		}else{
			// 购物车中没有这个商品
			CartItem item = new CartItem(product,1);
			item.setCount(1);
			map.put(product.getId().toString(), item);
		}		
	}
	//获取mp中的订单项集合
	public List<CartItem> getCartItemList(){
		Collection<CartItem> values = map.values();
		ArrayList<CartItem> list=new ArrayList<>(values);
		return list;
	}
	//获取购物车的总金额
	public double getTotalMony(){
		List<CartItem> list = getCartItemList();
		BigDecimal totalMoney = new BigDecimal("0");
		for (CartItem cartItem : list) {
			totalMoney=totalMoney.add(new BigDecimal(cartItem.TotalPrice+""));
		}
		return totalMoney.doubleValue();
	}
		//获取商品的个数
		//计算得出购物车中商品的总数量
		public int getTotalCount() {
			
			// 购物车中的商品的总金额
			// 遍历List<CartItem>	
			List<CartItem> cartItems =  getCartItemList();
			int totalCount = 0;
			
			for(CartItem ci : cartItems) {
				totalCount += ci.getCount();
			}
			return totalCount;
		}
	//根据id删除订单
	public void deletProduct(String id){
		map.remove(id);
	}
	//清空购物车
	public void clearProduct(){
		map.clear();
	}
	public LinkedHashMap<String, CartItem> getMap() {
		return map;
	}
	
		
}
