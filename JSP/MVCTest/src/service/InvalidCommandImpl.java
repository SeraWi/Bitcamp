package service;

import javax.servlet.http.HttpServletRequest;

public class InvalidCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request) {
		request.setAttribute("result","default");

		return "/WEB-INF/views/default.jsp";
	}

}
