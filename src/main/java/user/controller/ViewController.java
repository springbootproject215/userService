package user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() throws Exception{
		return "login";
	}
	
	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	public String profile() throws Exception{
       
		return "index";
	}
	
	@RequestMapping(value="/regist.do", method=RequestMethod.GET)
	public String regist() throws Exception{
       
		return "regist";
	}
	

}
