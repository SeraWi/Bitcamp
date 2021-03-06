package com.bitcamp.orl.mountain.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.orl.mountain.domain.MountainLocInfo;
import com.bitcamp.orl.mountain.service.MountainLocInfoViewService;

@Controller
public class SearchController {


	@Autowired
	private MountainLocInfoViewService locService;
	
	@RequestMapping(value="/mountain/search",method=RequestMethod.GET)
	public String getSearch() {
		return "mountain/search";
	}
	
	
	// 검색시 검색결과보여주는 컨트롤러
	@RequestMapping(value="/mountain/search",method=RequestMethod.POST)
	public String search(HttpServletRequest request,Model model
		) {
		
		String search =null;
		search=request.getParameter("mysearch").trim(); 
		
	
			List<MountainLocInfo> mountainListByName = null;
			List<MountainLocInfo> mountainListByLoc = null;
			
			mountainListByName = locService.getMountainSearchName(search);
			mountainListByLoc= locService.getMountainLocInfo(search);
			
			model.addAttribute("mountainListByName",mountainListByName);
			model.addAttribute("mountainListByLoc",mountainListByLoc);
			return "mountain/search";
			
		
	}
	
}
