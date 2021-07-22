package util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieBox {
	// request 객체를 이용해서 모든 Cookie객체를 Map에 저장
	// map<key,value> -> 쿠키이름, 쿠키객체
	
	private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
	
	
	//생성자를 이용해서 Map에 저장할 데이터 초기화
	public CookieBox(HttpServletRequest request ) {
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies !=null && cookies.length >0) {
			for(int i= 0; i<cookies.length; i++) {
				//cookieMap에 쿠키 정보를 저장
				
				cookieMap.put(cookies[i].getName(),cookies[i]);
			}
		}
	}
	
	//cookie 객체 생성하는 메소드 : 오버로딩, static
	// 쿠키이름, 쿠키값으로 생성
	public static Cookie makeCookie(String name, String value) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name, URLEncoder.encode(value,"utf-8"));
		
		return c;
	}
	
	
	//오버로딩: 쿠키이름, 쿠키값, 경로, 유지시간
	public static Cookie makeCookie(String name, String value, String path, int maxAge ) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name, URLEncoder.encode(value,"utf-8"));
		c.setPath(path); //     /
		c.setMaxAge(maxAge);
		
		return c;
	}
	

	//오버로딩: 쿠키이름, 쿠키값, 경로, 유지시간, 도메인
	public static Cookie makeCookie(String name, String value, String path, int maxAge, String domain) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name, URLEncoder.encode(value,"utf-8"));
		c.setPath(path); //     /
		c.setMaxAge(maxAge);
		c.setDomain(domain);
		return c;
	}
	
}












