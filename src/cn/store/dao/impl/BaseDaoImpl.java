package cn.store.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.regexp.internal.recompile;

import cn.store.dao.BaseDao;
import cn.store.utils.C3P0Utils;

public class BaseDaoImpl<T> implements BaseDao<T> {
	
	private Class type;
	
	public BaseDaoImpl(){
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] types = pt.getActualTypeArguments();
		type=(Class) types[0];
	
	}
	
	@Override
	public int inSert(String sql, Object... params) {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSouce());
		int i=0;
		try {
			i=qr.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int delet(String sql, Object... params) {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSouce());
		int i=0;
		try {
			i=qr.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public T getBean(String sql, Object... params) {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSouce());
		T t=null;
		try {
			t=qr.query(sql, new BeanHandler<T>(type),params);
//			t=qr.query(sql, new ResultSetHandler<T>,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public List<T> getList(String sql, Object... params) {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSouce());
		List<T> list = null;
		try {
			list=qr.query(sql, new BeanListHandler<T>(type),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Object getCount(String sql, Object... params){
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSouce());
		Object query = null;
		try {
			query = qr.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return query;
	}
	public Object getByCount(String sql, Object... params){
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSouce());
		Object query = null;
		try {
			query = qr.query(sql, new ScalarHandler(),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return query;
	}

	@Override
	public int update(String sql, Object... params) {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSouce());
		int i=0;
		try {
			i = qr.update(sql, new ScalarHandler(),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int[] batch(String sql, Object[][] params) {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSouce());
		
		int[] batch = null;
		
		try {
			batch = runner.batch(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return batch;
	}

	


}
