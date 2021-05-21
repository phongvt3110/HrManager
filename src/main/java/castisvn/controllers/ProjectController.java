package castisvn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/project"})
public class ProjectController {
	@GetMapping
	public String index() {
		return "project/index";
	}
}
