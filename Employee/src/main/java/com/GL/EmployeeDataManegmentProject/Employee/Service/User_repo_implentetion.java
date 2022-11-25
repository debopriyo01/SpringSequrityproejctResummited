package com.GL.EmployeeDataManegmentProject.Employee.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.GL.EmployeeDataManegmentProject.Employee.Config.MyUserDetails;
import com.GL.EmployeeDataManegmentProject.Employee.Entity.User;
import com.GL.EmployeeDataManegmentProject.Employee.Repository.User_repo;

@Service
public class User_repo_implentetion implements UserDetailsService {

	@Autowired
	private User_repo user_repo;

	@Autowired
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = user_repo.FindByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException("The User Not Found !");
		} else {
			return new MyUserDetails(user);
		}

	}

}
