package com.GL.EmployeeDataManegmentProject.Employee.Config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.GL.EmployeeDataManegmentProject.Employee.Entity.Role;
import com.GL.EmployeeDataManegmentProject.Employee.Entity.User;

@Configuration
public class MyUserDetails implements UserDetails {

	// Creting The object of the USer Class hear :-
	@Autowired
	private User user;

	public MyUserDetails(User user) {

		this.user = user;

	}
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
	List<Role> roles=user.getListRole();
    List<SimpleGrantedAuthority> Auth=new ArrayList<>();
    
    for(Role role:roles) {
    	
    	Auth.add(new SimpleGrantedAuthority(role.getRole_Name()));
    }
		return Auth;
	
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
