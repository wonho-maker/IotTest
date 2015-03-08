package ssu.media.iot.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addViewController("/results").setViewName("results2");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/signIn").setViewName("loginForm");
		//registry.addViewController("/topMenu").setViewName("topMenu");
		//registry.addViewController("/index").setViewName("index");
		//registry.addViewController("/**").setViewName("/static/");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		//registry.addResourceHandler("/**").addResourceLocations("/static/");
	}
}
