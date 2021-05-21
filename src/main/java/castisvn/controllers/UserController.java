package castisvn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import castisvn.commonUtils.EmailFormat;
import castisvn.entities.User;
import castisvn.entities.UserRole;
import castisvn.formModel.UserForm;
import castisvn.repository.RoleRepository;
import castisvn.repository.UserRepository;
import castisvn.repository.UserRoleRepository;

@Controller
@RequestMapping(value = {"/admin/user"})
public class UserController extends BaseController{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("users", userRepository.findAll());		
		return "user/index";
	}
	
	@GetMapping(value = {"/add"})
	public String userAdd(Model model) {
		UserForm userForm = new UserForm();		
		model.addAttribute("userForm", userForm);
		model.addAttribute("roles", roleRepository.findAll());
		return "user/addUser";
	}
	
	@PostMapping(value = {"/add"})
	public String userAdd(@ModelAttribute UserForm userForm) {
		if(!EmailFormat.checkEmailValidFormat(userForm.getUser().getEmail())) {
			return "redirect:/admin/user/add";
		}
		User userSave = userRepository.saveAndFlush(userForm.getUser());			
		userRoleRepository.saveAndFlush(new UserRole(userSave.getId(), userForm.getRoleId()));
		return "user/add_success";
	}
	
	@GetMapping(value = {"/edit/{userId}"})
	public String editUser(@PathVariable(name = "userId") Integer userId, Model model) {
		User user = userRepository.findById(userId).get();
		UserForm userForm = new UserForm();
		userForm.setUser(user);
		model.addAttribute("userForm", userForm);
		model.addAttribute("roles", roleRepository.findAll());
		model.addAttribute("userRole", user.getRoles().iterator().next());		
		return "user/editUser";
	}
	@PostMapping(value = {"/edit"})
	public String editUser(@ModelAttribute UserForm userForm, Model model) {
		userRepository.saveAndFlush(userForm.getUser());
		userRoleRepository.saveAndFlush(new UserRole(userForm.getUser().getId(), userForm.getRoleId()));
		model.addAttribute("msgAction", "Edit user successfully");
		model.addAttribute("actionRoute","/admin/user");
		model.addAttribute("actionButtonText", "Go to User screen");
		return "action-success";
	}
	
	@GetMapping(value = {"/delete/{id}"})
	public String userDelete(@PathVariable(name = "id") Integer userId, Model model) {
		userRepository.deleteById(userId);
		model.addAttribute("msgAction", "Delete user successfully");
		model.addAttribute("actionRoute","/admin/user");
		model.addAttribute("actionButtonText", "Go to User screen");		
		return "action-success";
	}
}
