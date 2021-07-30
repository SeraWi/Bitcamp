package member.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;


public class CharacterEncodingFilter implements Filter {
	
	
	private String encoding;


	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest =(HttpServletRequest) request;
		httpRequest.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		//초기화 해주기
		String paramValue= fConfig.getInitParameter("encoding");
		//param-name /param-value
		
		if(paramValue != null) {
			this.encoding = "utf-8";
		}else {
			this.encoding =paramValue;
		}
	}

}