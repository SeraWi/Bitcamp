package guest.jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class JdbcDriverLoad extends HttpServlet{

	@Override
	// ServletConfig: web.xml파라미터 사용하는 용
	public void init(ServletConfig config) throws ServletException {
		
		String jdbcDriver = config.getInitParameter("jdbcdriver");
		
		try {
			
			jdbcDriver =jdbcDriver == null? "com.mysql.cj.jdbc.Driver" : jdbcDriver;
			//없으면 설정 있으면 그대로 쓰기
			Class.forName(jdbcDriver);
			System.out.println("mysql Driver load..!!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	
}
