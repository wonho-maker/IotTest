package ssu.media.iot.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;


@Configuration
@EnableWebMvcSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	String[] basicURLForResources = { "/css/**", "/js/**", "/fonts/**", "/font-awesome/**" };
	String[] publicURLString = {"/", "/index", "/registration", "/console/**", "/chart/**", "/api/**"};
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(basicURLForResources).permitAll()
				.antMatchers(publicURLString).permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/signIn")
				.permitAll()
				.and()
			.logout()
				.permitAll()
				.logoutSuccessUrl("/")
				.and()
			.csrf().disable()
			.headers().frameOptions().disable();
			
		
			
	}
	
	
	@Autowired
	private DataSource dataSource; 
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		//auth
		//.inMemoryAuthentication()
		//	.withUser("user").password("password").roles("USER");
		
		auth.jdbcAuthentication().dataSource(this.dataSource)
				.usersByUsernameQuery("select username, password, true from users where username = ?")
				.authoritiesByUsernameQuery("select username, role from users where username = ?");
						
						
	}
}
