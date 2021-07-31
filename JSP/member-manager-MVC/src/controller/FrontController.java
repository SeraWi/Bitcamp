package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Command;
import service.IndexCommandImpl;


public class FrontController extends HttpServlet{

	private Map<String,Command> commands = new HashMap<String,Command>();
	//			<요청(uri), GreeringCommandImpl>
	// commands.put("/",new GreetingCommandImpl())


	//초기화 해주는 메서드, 
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		//설정파일의 경로 가져오기
		String configFile = config.getInitParameter("config");
		
		Properties prop = new Properties();
		
		FileInputStream fis = null;
		//설정파일의 시스템 경로를 받아오기
		String configPath = config.getServletContext().getRealPath(configFile);
		System.out.println(configPath);
		
		try {
			fis = new FileInputStream(configPath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator<Object>itr = prop.keySet().iterator();
		while(itr.hasNext()) {
			String command = (String)itr.next();
			String commandClassName = prop.getProperty(command); //키값을 받아서 value반환
			//System.out.println(command+"="+commandClassName);//  /greeting.do=service.GreetingCommandImpl
			
			
			//클래스 이름올 해당클래스의 인스턴스 생성
			try {
				Class commandClass = Class.forName(commandClassName);
				
				Command commandObj = (Command) commandClass.newInstance();
				
				commands.put(command, commandObj);
				
				System.out.println(command+"="+commandClassName);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 사용자의 요청 분석:uri를 추출해서 사용하기
		//String type = request.getParameter("type"); 
		String commandUri = request.getRequestURI();
		// http://localhost:8080/mvc/guest/list.do ->/mvc/guest/list.do ( -->URI )

		//contextpath제거하기
		if(commandUri.indexOf(request.getContextPath())==0) {
			//contextpath의 인덱스가 0이다 == contextpath로 시작한다.

			//substring(beginindex)
			commandUri = commandUri.substring(request.getContextPath().length());
		}


		//view 페이지
		//controller 통해서만 view페이지 볼 수 있다.
		String viewPage = "/WEB-INF/views/index.jsp";
		Command command = null;
		command = commands.get(commandUri); //key값에 해당하는value값 반환 -> impl클래스 반환

		if(command==null) {
			command =new IndexCommandImpl();
		}
		viewPage = command.getPage(request,response);

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	} 
}

