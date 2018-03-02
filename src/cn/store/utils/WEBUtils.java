package cn.store.utils;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

public class WEBUtils {
	public static String getRealPath(HttpServletRequest request){
		String url = request.getRequestURI();
		String paramater = request.getQueryString();
		StringBuilder sb=new StringBuilder();
		sb.append(url);
		sb.append("?");
		sb.append(paramater);
		if(sb.indexOf("&currentPage")!=-1){
			sb.delete(sb.indexOf("&currentPage"), sb.length());
		}
		return sb.toString();
	}
	//循环获取访问地址
	public  static String getFrontPath(HttpServletRequest request) {
		String header = request.getHeader("referer");
		String[] str = header.split("/");
		String string = str[str.length - 1];
		
		
		LinkedList<String> list = (LinkedList<String>) request.getSession().getAttribute("bbb");
		if (list==null) {
			list = new LinkedList<>();
			list.addFirst(string);
			request.getSession().setAttribute("bbb", list);
		}else{
			list.addFirst(string);
		}
		
		while (list.size()>0) {
			String first = list.removeFirst();
			
			if (!first.contains("OrderServlet")) {
				string = first;
				list.addFirst(first);
				break;
			}
		}
		return string;
	}
}
