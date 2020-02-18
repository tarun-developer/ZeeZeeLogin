package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.bean.LoginBean;
import com.service.LoginService;



@Controller
public class LoginController {
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginpage(LoginBean loginBean) {
	
			return "login";

	}


	@RequestMapping("/postdata")
	public String checkLoginDetails(LoginBean loginBean, 
			BindingResult result,Model model) {
		 if (result.hasErrors()) {
	         return "login";
	      }
		 
		 model.addAttribute("username", loginBean.getUserName());
	      model.addAttribute("password", loginBean.getPassword());
	     
		LoginService s=new LoginService();
		if(s.validate(loginBean)) {
		
			return "success";
		}
	
		return "invalid";

	}
	

}
