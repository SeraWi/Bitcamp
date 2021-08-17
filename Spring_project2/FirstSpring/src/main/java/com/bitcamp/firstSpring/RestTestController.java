package com.bitcamp.firstSpring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/simple")
public class RestTestController {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getForm() {
		return "rest/form";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String simple(
			@RequestBody String body
			) {
		
		//@RequestBody body 안에 있는 모든것을 받아온다.
		//Json 데이터를 받을 때 이용한다. 
		//Gson 라이브러리 이용하면 : json문자열을 Java 객체로 변경할 수 있다.
		
		System.out.println("body:"+body);//body:name=cool&age=10
		//return "@ReponseBody를 이용한 응답!";
		return body;
	}
}
