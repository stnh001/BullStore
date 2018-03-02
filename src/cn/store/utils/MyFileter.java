package cn.store.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class MyFileter implements Filter{
	FilterConfig filterConfig;
	
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig=filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req;
		HttpServletResponse rsp;
		req=(HttpServletRequest)request;
		rsp=(HttpServletResponse)response;
		doFilter(req,rsp,chain);
	}

	@Override
	public void destroy() {
		
	}
	public abstract void doFilter(HttpServletRequest request,HttpServletResponse response,FilterChain chain);

}
