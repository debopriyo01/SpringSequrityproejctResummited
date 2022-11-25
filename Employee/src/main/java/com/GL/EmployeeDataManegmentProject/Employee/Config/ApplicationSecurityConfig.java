package com.GL.EmployeeDataManegmentProject.Employee.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.GL.EmployeeDataManegmentProject.Employee.Service.User_repo_implentetion;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	protected DaoAuthenticationProvider daoAuthenticationProvider() {

		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());

		return authenticationProvider;
	}

	@Bean
	protected UserDetailsService userDetailsService() {

		return new User_repo_implentetion();
	}

	@Bean
	protected BCryptPasswordEncoder bCryptPasswordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(daoAuthenticationProvider());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/h2-console/**").permitAll().and().authorizeRequests()
				.antMatchers("/Employee/**", "/Employee/List/**", "/Employee/Form_Emp/**", "Employee/save/**")
				.hasAnyRole("Employee", "Admin").antMatchers("/Employee/Update/**", "/Employee/Delete/**")
				.hasRole("Admin").anyRequest().authenticated().and().formLogin().loginProcessingUrl("/login")
				.successForwardUrl("/Employee/List/**").and().logout().logoutSuccessUrl("/login").permitAll().and()
				.exceptionHandling().accessDeniedPage("/acsess-dined").and().cors().and().csrf().disable();

	}

}
