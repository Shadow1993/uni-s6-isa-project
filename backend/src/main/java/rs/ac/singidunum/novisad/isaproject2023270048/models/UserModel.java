package rs.ac.singidunum.novisad.isaproject2023270048.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "application_user")
public class UserModel extends BaseModel {

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@OneToMany(mappedBy = "user")
	private List<AssignedRoleModel> assignedRoles = new ArrayList<AssignedRoleModel>();

	public UserModel() {
		super();
	}

	public UserModel(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public UserModel(String email, String password) {
		this();
		this.email = email;
		this.password = password;
	}

	public UserModel(String email, String password, List<AssignedRoleModel> assignedRoles) {
		this();
		this.email = email;
		this.password = password;
		this.assignedRoles = assignedRoles;
	}

	public UserModel(Long id, Boolean active, LocalDateTime createdAt, String email, String password) {
		this(id, active, createdAt);
		this.email = email;
		this.password = password;
	}

	public UserModel(Long id, Boolean active, LocalDateTime createdAt, String email, String password,
			List<AssignedRoleModel> assignedRoles) {
		this(id, active, createdAt);
		this.email = email;
		this.password = password;
		this.assignedRoles = assignedRoles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AssignedRoleModel> getAssignedRoles() {
		return assignedRoles;
	}

	public void setAssignedRoles(List<AssignedRoleModel> assignedRoles) {
		this.assignedRoles = assignedRoles;
	}

}
