package castisvn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping(value = {"/login-system"})
	public String login() {
		return "login/login_system";
	}
	
	@GetMapping(value = {"/login-failed"})
	public String loginFailed() {
		return "login/login-failed";
	}
}
