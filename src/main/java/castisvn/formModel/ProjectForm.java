package castisvn.formModel;

import java.util.List;
import java.util.stream.Collectors;

import castisvn.entities.Project;
import castisvn.entities.User;

public class ProjectForm {
	private Integer id;
	private String projectName;
	private String createdAt;
	private String updatedAt;
	private String creatorName;
	
	
	public ProjectForm(Project prj, List<User> users) {
		this.id = prj.getId();
		this.projectName = prj.getProjectName();
		this.createdAt = prj.getCreatedAt();
		this.updatedAt = prj.getUpdatedAt();
		this.creatorName = users.stream().filter(a -> a.getId() == prj.getCreatorId()).collect(Collectors.toList()).get(0).getFullName();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}	
}
