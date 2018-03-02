package cn.store.manager.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.test.StaticFunctionTests;
import org.apache.tomcat.util.http.Cookies;

import cn.store.dao.impl.UserDaoImpl;
import cn.store.utils.MD5Utils;

public class CookieServce {
	 	private static final String SALT = "tmp_20170524.";
	 	
	    private static final String CT_TMP = "_ct_tmp";
	    
	    private static final String CT_UN = "_ct_un";
	    
	    private static final String COOKIE_PATH = "/";
	    
	    private static final int COOKIE_MAX_AGE = 60 * 60 * 24 * 7; // 7 days in second
	public static  boolean isTmpCookie(String md5Str,HttpServletRequest request){

		Cookie[] cookies = request.getCookies();
		String value = "";
		for (Cookie cookie : cookies) {
			if("_ct_tmp".equals(cookie.getName())){
				value = cookie.getValue();
			}
		}
		
		return MD5Utils.md5(md5Str).equals(value);
	}
	
	public static void createUserNameCookie(String username,String password,HttpServletResponse response){
		String md5pass = MD5Utils.md5(password);
		Cookie tmp = new Cookie("_ct_tmp", MD5Utils.md5(username+md5pass));
		    tmp.setMaxAge(COOKIE_MAX_AGE);
	        tmp.setPath(COOKIE_PATH);
//	        tmp.setDomain(COOKIE_DOMAIN);
	        tmp.setHttpOnly(true);
	        response.addCookie(tmp);
	}
	 public boolean clearCookies(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
	        if (httpServletRequest.getCookies() != null) {
	            for (Cookie cookie : httpServletRequest.getCookies()) {
	                if (cookie.getName().equals(CT_TMP)) {
	                    cookie.setMaxAge(0);
	                    cookie.setValue("");
	                    cookie.setPath("/");
	                    httpServletResponse.addCookie(cookie);
	                    continue;
	                }

	                if (cookie.getName().equals(CT_UN)) {
	                    cookie.setMaxAge(0);
	                    cookie.setValue("");
	                    cookie.setPath("/");
	                    httpServletResponse.addCookie(cookie);
	                }
	            }

	            return true;
	        }

	        return false;
	    }
	
}
