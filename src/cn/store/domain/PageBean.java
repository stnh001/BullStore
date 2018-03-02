package cn.store.domain;

import java.util.List;

public class PageBean<T> {
	
	//商品数据
	private List<T> datas;
	//每页显示的纪录数
	private int pageSize;
	//总共多少纪录
	private int totalRecord;
	//当前页面码
	private int currentPage;
	//当前页面的索引
	private int startIndex;
	//总共多少页
	private  int totalPage;
	//路径
	private String path;
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		if(totalRecord%pageSize==0){
			return totalRecord/pageSize;
		}else{
			return totalRecord/pageSize+1;
		}

	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getTotalRecord() {
		
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getCurrentPage() {
		if(currentPage==0){
			currentPage=1;
		}else if(currentPage>getTotalPage()){
			currentPage=getTotalPage();
		}
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartIndex() {
		
		return (getCurrentPage()-1)*pageSize;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	
}
