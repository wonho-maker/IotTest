package ssu.media.iot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ssu.media.iot.domain.TestUser;
import ssu.media.iot.service.UserRepository;

@Controller
public class UserRegistController  {

	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String showForm(TestUser testUser)
	{
		
		return "registration";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String checkUserInfo(TestUser testUser)
	{	
		userRepository.save(testUser);
		
		
		return "redirect:/";
			
	}
	
	@Autowired
	UserRepository userRepository;
	
}
