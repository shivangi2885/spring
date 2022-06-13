package com.example.mypkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("myapp")

public class Home {
	 
		 @Value("${server.port}")
		 public String port;
		 
		 @GetMapping("/demo")
		 public String getdemo() {
			 return port;
		 }
		 
		 @GetMapping("/demo/next")
		 public String getSecPage() {
			 return "second page";
		 }
		 @RequestMapping("home")
		 public String home(HttpServletRequest req) {
			 HttpSession session=req.getSession();
			 String namevar=req.getParameter("name");
			 System.out.println("hello"+namevar);
			 session.setAttribute("namevar", namevar);
			 return "home";
		 }	 
		 @RequestMapping("aboutUs")
		 public String aboutUs(HttpServletRequest req) {
		      HttpSession session=req.getSession();
			  String city=req.getParameter("city");
			  System.out.println("welcome to"+city);
			  session.setAttribute("city", city);
			  return "city";
		 }
		 @RequestMapping("mvc")
		 public ModelAndView mvc(HttpServletRequest req) {
		      HttpSession session=req.getSession();
			  String city=req.getParameter("city").toUpperCase();
			  ModelAndView mv= new ModelAndView();
//			  session.setAttribute("city", city);
			  mv.addObject("city",city);
			  mv.setViewName("city");
			  return mv;
		 }
	 
}
