package castisvn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import castisvn.entities.Report;
import castisvn.repository.LevelOfWorkRepository;
import castisvn.repository.PositionRepository;
import castisvn.repository.ProjectRepository;
import castisvn.repository.ReportRepository;

@Controller
public class ReportController extends BaseController{
	
	private ReportRepository reportRepository;	
	private ProjectRepository projectRepository;
	private PositionRepository positionRepository;
	private LevelOfWorkRepository levelWorkRepository;
	
	public ReportController(@Autowired ReportRepository repository, ProjectRepository project, PositionRepository position,
			LevelOfWorkRepository level) {
		// TODO Auto-generated constructor stub
		this.reportRepository = repository;		
		this.projectRepository = project;
		this.positionRepository = position;
		this.levelWorkRepository = level;
	}
	
	@GetMapping(value = {"/report/add"})
	public String addReport(Model model) {
		if(!this.hasPermission("USER")) return "errors/access_denied";
		Report report = new Report();		
		report.setReporter(this.getUser().getFullName());
		model.addAttribute("report", report);
		model.addAttribute("projects", projectRepository.findAll());
		model.addAttribute("positions", positionRepository.findAll());
		model.addAttribute("levelOfWorks", levelWorkRepository.findAll());
		return "report/add";
	}
	
	@PostMapping(value = {"/report/add"})
	public String addReport(@ModelAttribute Report report) {
		if(!this.hasPermission("USER")) return "errors/access_denied";
		report.setUserId(this.getUser().getId());
		report.setReporter(this.getUser().getFullName());
		report.setScore(report.getTimeRequired());
		reportRepository.saveAndFlush(report);
		return "report/add_success";
	}
	
	@GetMapping(value = {"/admin/report/edit/{id}"})
	public String editScore(@PathVariable(name = "id") Integer reportId, Model model) {
		Report report = reportRepository.getOne(reportId);		
		model.addAttribute("report", report);
		return "report/editScore";
	}
	
	@PostMapping(value = {"/admin/report/edit"})
	public String editScore(@ModelAttribute Report report, Model model) {		
		Report saveReport = reportRepository.getOne(report.getId());
		saveReport.setScore(report.getScore());		
		reportRepository.saveAndFlush(saveReport);
		model.addAttribute("msgAction", "Modify Score successfully");
		model.addAttribute("actionRoute","/admin");
		model.addAttribute("actionButtonText", "Go to Report screen");
		return "action-success";
	}
}
