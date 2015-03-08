package ssu.media.iot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	
	//@RequestMapping("/")
	public String index(Model model)
	{
		model.addAttribute("message", "Hello");
		
		return "hello";
	}
}
