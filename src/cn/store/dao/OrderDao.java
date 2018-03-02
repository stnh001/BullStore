
package cn.store.dao;

import cn.store.domain.Order;

public interface OrderDao {
	//生成订单
	int createOrder(Order order);
}
