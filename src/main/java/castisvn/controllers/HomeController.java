package castisvn.controllers;

import java.security.Principal;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import castisvn.repository.MyUserDetails;

//import castis.repository.MyUserDetails;

@Controller
@RequestMapping(value = {"/"})
public class HomeController extends BaseController{
	@ModelAttribute
	public void addMsg(Model model) {
		model.addAttribute("msg", "Hello everyone here");
	}
	@GetMapping
	public String index(@AuthenticationPrincipal MyUserDetails userDetails,Principal principal,Model model) {		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		User user = ((MyUserDetails)authentication.getPrincipal()).getUser();			
		if(!(authentication instanceof AnonymousAuthenticationToken)) {
//			String currentUserName = authentication.getName();
			String roleString = authentication.getAuthorities().toString();
//			roleString.replaceAll("^.|.$", ""); //remove first and last character in string
			model.addAttribute("name", principal.getName());			
			if(roleString.contains("ADMIN")) {
				return "redirect:/admin";
//				return "forward:/admin";
			} else {
				return "redirect:/staff";
//				return "forward:/staff";
			}
		}
		return "home/index";
	}
	@GetMapping(value = "/home")
	public String home() {			
		return "home/home";
	}
	
	@GetMapping(value = "/menu")
	public String menu() {			
		return "menu";
	}	
}
