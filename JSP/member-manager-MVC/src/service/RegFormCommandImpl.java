package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegFormCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse reponse) {

		return "/WEB-INF/views/regForm.jsp";
	}

}
