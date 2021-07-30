package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request,HttpServletResponse reponse) {
		return "/index.jsp";
	}

}
