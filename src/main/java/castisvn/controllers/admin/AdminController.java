package castisvn.controllers.admin;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import castisvn.commons.CommonConst;
import castisvn.controllers.BaseController;
import castisvn.entities.Position;
import castisvn.entities.Project;
import castisvn.entities.Report;
import castisvn.entities.User;
import castisvn.formModel.ProjectForm;
import castisvn.repository.PositionRepository;
import castisvn.repository.ProjectRepository;
import castisvn.repository.ReportRepository;
import castisvn.repository.UserRepository;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminController extends BaseController {
	@Autowired
	private ReportRepository reportRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private PositionRepository positionRepository;
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public String index(@RequestParam(name = "page", defaultValue = "1") Integer page, Principal principal,
			Model model) {
		if (!this.hasPermission("ADMIN"))
			return "errors/access_denied";
//		List<Report> reports = reportRepository.findAllDescIssuedDate();
		Page<Report> reports = reportRepository
				.findAll(PageRequest.of(page - 1, CommonConst.ELEMENT_OF_PAGE, Sort.by(Direction.DESC, "issuedDate")));
//		Pageable pageable = reports.getPageable();	
		List<Project> projects = projectRepository.findAll();
		List<Position> positions = positionRepository.findAll();
		List<User> users = userRepository.getListUsers();
		model.addAttribute("name", principal.getName());
		model.addAttribute("reports", reports);
		model.addAttribute("projects", projects);
		model.addAttribute("positions", positions);
		model.addAttribute("users", users);
		model.addAttribute("pageable", IntStream.range(1, reports.getTotalPages() + 1).toArray());
		model.addAttribute("currentPage", page);
		return "admin/admin";
	}

	@GetMapping(value = { "/search" })
	public String search(@RequestParam(name = "reporter", required = false) String reporter,
			@RequestParam(name = "project", required = false) ArrayList<String> project,
			@RequestParam(name = "position", required = false) String position,
			@RequestParam(name = "page", defaultValue = "1") Integer page, Model model) {
		List<Project> projects = projectRepository.findAll();
		List<Position> positions = positionRepository.findAll();
		List<User> users = userRepository.getListUsers();
//		Page<Report> reports = reportRepository.findAllByCondition(reporter, project, position, PageRequest.of(page-1, CommonConst.ELEMENT_OF_PAGE, Sort.by(Direction.DESC, "issuedDate")));
//		Page<Report> reports = reportRepository.findByCriteria(reporter, project, position, PageRequest.of(page -1, CommonConst.ELEMENT_OF_PAGE, Sort.by(Direction.DESC, "issuedDate")));
		Page<Report> reports = reportRepository.findBySpecs(reporter, project, position,
				PageRequest.of(page - 1, CommonConst.ELEMENT_OF_PAGE, Sort.by(Direction.DESC, "issuedDate")));
//		Page<Report> reports = reportRepository.findBySpecsAndLevel(reporter, project, position, "BASIC WORK", null, PageRequest.of(page -1, CommonConst.ELEMENT_OF_PAGE, Sort.by(Direction.DESC, "issuedDate")));
		model.addAttribute("name", this.getUser().getUsername());
		model.addAttribute("reports", reports);
		model.addAttribute("projects", projects);
		model.addAttribute("positions", positions);
		model.addAttribute("users", users);
		model.addAttribute("pos", position);
		model.addAttribute("prjs", project);
		model.addAttribute("reporterName", reporter);
		model.addAttribute("pageable", IntStream.range(1, reports.getTotalPages() + 1).toArray());
		model.addAttribute("currentPage", page);

		return "admin/admin";
	}

	@GetMapping(value = { "/profile" })
	public String adminProfile() {
		return "admin/admin_profile";
	}

	@GetMapping(value = { "/project" })
	public String project(Model model) {
		List<User> users = userRepository.findAll();
		ArrayList<ProjectForm> prjectForms = new ArrayList<>();
		projectRepository.findAll().forEach(prj -> prjectForms.add(new ProjectForm(prj, users)));
		model.addAttribute("prjects", projectRepository.findAll());
		model.addAttribute("users", userRepository.findAll());
		return "admin/project";
	}

	@GetMapping(value = { "/project/add" })
	public String projectAdd(Model model) {
		model.addAttribute("project", new Project());
		return "admin/project-add";
	}

	@PostMapping(value = { "/project/add" })
	public String projectAdd(@ModelAttribute Project project, Model model) {
		project.setCreatorId(this.getUser().getId());
		projectRepository.saveAndFlush(project);
		model.addAttribute("msgAction", "Add new project successfully");
		return "admin/action-success";
	}

	@GetMapping(value = { "/project/edit/{projectId}" })
	public String projectEdit(@PathVariable(name = "projectId") Integer projectId, Model model) {
		model.addAttribute("project", projectRepository.findById(projectId));
		return "admin/project-edit";
	}

	@PostMapping(value = { "/project/edit" })
	public String projectEdit(@ModelAttribute Project project, Model model) {
		project.setUpdatedAt(LocalDateTime.now());
		projectRepository.saveAndFlush(project);
		return "redirect:/admin/project";
	}

	@GetMapping(value = { "/project/delete/{projectId}" })
	public String projectDelete(@PathVariable(name = "projectId") Integer projectId) {
		projectRepository.deleteById(projectId);
		return "redirect:/admin/project";
	}

	@RequestMapping(value = "/project/test", method = { RequestMethod.GET, RequestMethod.POST })
	public String test(HttpServletRequest request) {
		System.out.println(request.getMethod().equals("GET"));
		return "home/index";
	}
}
