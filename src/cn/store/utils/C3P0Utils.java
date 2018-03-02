package cn.store.utils;

import javax.sql.ConnectionPoolDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	private static ComboPooledDataSource pool=new ComboPooledDataSource();
	
	
	
	public static ComboPooledDataSource getDataSouce(){
		System.out.println();
		return pool;
	}
}
