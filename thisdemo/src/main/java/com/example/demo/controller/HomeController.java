package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.UserDtls;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
    
@Autowired
private UserService userService;

@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}
   
  @PostMapping("/createUser")
  public String createuser(@ModelAttribute UserDtls user,HttpSession session){

   // this is to save to database

  boolean f=userService.checkEmail(user.getEmail());
  if(f){
    session.setAttribute("msg", "Email Id already exists");
  }else{

    UserDtls userDtls=userService.createUser(user);

  if(userDtls!=null){
    session.setAttribute("msg", "Register Sucessfully");
  }else{
    session.setAttribute("msg", "Something went wrong");
  }

  }

    return "redirect:/register";
  }

}