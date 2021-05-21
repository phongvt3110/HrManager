package castisvn.controllers;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import castisvn.commonUtils.CommonGenerator;
import castisvn.commonUtils.EmailFormat;
import castisvn.commons.CommonConst;
import castisvn.entities.Report;
import castisvn.entities.User;
import castisvn.formModel.UserForm;
import castisvn.repository.MyUserDetails;
import castisvn.repository.ReportRepository;
import castisvn.repository.UserRepository;

@Controller
@RequestMapping(value = {"/staff"})
public class StaffController extends BaseController{
	@Autowired
	private ReportRepository reportRepository;
	@Autowired
	private UserRepository userRepository;
	@GetMapping
	public String index(@RequestParam(name = "page", defaultValue = "1") Integer currentPage,Authentication authentication, Model model) {
		if(!this.hasPermission("USER")) return "errors/access_denied";
		model.addAttribute("name", authentication.getName());
		MyUserDetails userDetails = (MyUserDetails)authentication.getPrincipal();
//		User user = userRepository.getUserByUsername(authentication.getName());
		Page<Report> reports = reportRepository.getReportByUserId(userDetails.getUserId(), PageRequest.of(currentPage -1 , CommonConst.ELEMENT_OF_PAGE));
		model.addAttribute("reports", reports);
		model.addAttribute("page", currentPage);
		model.addAttribute("pageable", IntStream.range(1, reports.getTotalPages()+1).toArray());
		return "home/staff";
	}
	@GetMapping(value = {"/profile"})
	public String profile(Authentication authentication, Model model) {
		UserForm userForm = new UserForm();
		userForm.setUser(getUser());
		model.addAttribute("userForm", userForm);
		return "home/staff_profile";
	}
	@PostMapping(value = {"/profile"})
	public String editProfile(@ModelAttribute UserForm userForm,Model model) {
		if(userForm.getUser().getPassword() == "" || userForm.getRePassword() == "" || 
				!userForm.getUser().getPassword().equals(userForm.getRePassword())
				|| !EmailFormat.checkEmailValidFormat(userForm.getUser().getEmail())
				) {
			UserForm usrForm = new UserForm();
			usrForm.setUser(getUser());
			model.addAttribute("userForm", usrForm);
			model.addAttribute("isValid", false);
			return "home/staff_profile";
		}
		User user = this.getUser();
		user.setUsername(userForm.getUser().getUsername());
		user.setPassword(CommonGenerator.passwordGenetor(userForm.getUser().getPassword()));
		user.setEmail(userForm.getUser().getEmail());		
		userRepository.saveAndFlush(user);
		model.addAttribute("msgAction", "Modify profile successfully");
		model.addAttribute("actionRoute","/staff");
		model.addAttribute("actionButtonText", "Go to Staff screen");
		return "action-success";
	}
}
