package ssu.media.iot.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import org.springframework.web.bind.annotation.RestController;

import ssu.media.iot.domain.TestUser;
import ssu.media.iot.service.UserRepository;


@RestController
public class UserInfoController {
	
	@RequestMapping(value = "/userInfo2", method = RequestMethod.GET)
	public Collection<TestUser> getUserInfo() {
		
		return this.userRepository.findAll();
	}
	
	@Autowired
		UserRepository userRepository;
}
