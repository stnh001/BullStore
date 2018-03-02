package cn.store.domain;

public class Page<T> {
	//当前页面(是页面传过来的)
	private int currentPage;
	//起始页面(计算)
	private int startIndex;
	//总共有多少条纪录(计算)
	private int totalCount;
	//总共有多少页(计算)
	private int pageSize;
	//每页显示的纪录数
	private int pageCount;
	
	private T datas;
	
	public T getDatas() {
		return datas;
	}
	public void setDatas(T datas) {
		this.datas = datas;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartIndex() {
		return (currentPage-1)*pageCount;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		
		return (int) Math.ceil((1.0*totalCount/pageCount));
	}
	public void setPageSize(int pageSize) {
		
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	
}
