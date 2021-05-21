package castisvn.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "daily_report")
public class Report implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "issued_date")		
	private LocalDateTime issuedDate;
	@Column(name = "reporter")
	private String reporter;
	@Column(name = "project")
	private String project;
	@Column(name = "position")
	private String position;
	@Column(name = "work_details")
	private String workDetails;
	@Column(name = "time_required")
	private float timeRequired;
	@Column(name = "score")
	private float score;
	@Column(name = "level_of_work")
	private String levelOfWork;
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
			
	public Report() {
		this.issuedDate = LocalDateTime.now();		
	}
		
	public String getReporter() {
		return reporter;
	}


	public void setReporter(String reporter) {
		this.reporter = reporter;
	}


	public String getProject() {
		return project;
	}


	public void setProject(String project) {
		this.project = project;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getIssuedDate() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(issuedDate);
	}
	public void setIssuedDate(LocalDateTime issuedDate) {
		this.issuedDate = issuedDate;
	}
	public String getWorkDetails() {
		return workDetails;
	}
	public void setWorkDetails(String workDetails) {
		this.workDetails = workDetails;
	}
	public float getTimeRequired() {
		return timeRequired;
	}
	public void setTimeRequired(float timeRequired) {
		this.timeRequired = timeRequired;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {		
		this.score = score;
	}
	public String getLevelOfWork() {
		return levelOfWork;
	}
	public void setLevelOfWork(String levelOfWork) {
		this.levelOfWork = levelOfWork;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {		
		return String.format("[id = %d, userId = %d, issuedDate = %s, reporter = %s, project = %s, position = %s, workDetails = %s, timeRequired = %f, score = %f, levelOfWork = %s, updatedAt = %s, createdAt = %s]", id, userId, this.getIssuedDate(), reporter, project, position, workDetails, timeRequired, score, levelOfWork, this.getUpdatedAt(), this.getCreatedAt());
	}
}
