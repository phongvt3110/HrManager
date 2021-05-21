package castisvn.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import castisvn.entities.User;
import castisvn.repository.MyUserDetails;

@Controller
public class BaseController {
	public User getUser() {
		return ((MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
	}
	public String getRoleName(){
		return SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().toString().replaceAll("^.|.$", "");
	}
	public boolean hasPermission(String role) {
		if(getRoleName().contains(role))return true; else return false;
	}
}
