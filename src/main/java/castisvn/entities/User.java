package castisvn.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import org.hibernate.annotations.ManyToAny;

import castisvn.commonUtils.CommonGenerator;

@Entity
@Table(name = "user")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "full_name")
	private String fullName;
	private String password;
	private byte enabled;
	@Column(name = "updated_at")	
	private LocalDateTime updatedAt;
	@Column(name = "created_at")	
	private LocalDateTime createdAt;
	
	@ManyToAny(fetch = FetchType.EAGER,metaColumn = @Column(name = "id"))	
	@JoinTable(name = "user_role", joinColumns = {@JoinColumn(name="user_id")}, inverseJoinColumns = {@JoinColumn(name="role_id")})	
	private Set<Role> roles = new HashSet<>();
	
	
	
	public User() {		
		this.password = CommonGenerator.passwordGenetor("castis1502");
		this.enabled = 1;
	}

	public Set<Role> getRoles() {
		return roles;
	}
	
	public String getRolesName() {
		return this.roles.stream().reduce("", (a,b) -> a  + b.getName() + " , ", String::concat).replaceAll("[, ].$", "");
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte getEnabled() {
		return enabled;
	}
	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}
	public String getUpdatedAt() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(updatedAt);
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getCreatedAt() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(createdAt);
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}	
}
