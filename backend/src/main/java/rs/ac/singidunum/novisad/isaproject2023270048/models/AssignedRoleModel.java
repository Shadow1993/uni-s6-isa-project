package rs.ac.singidunum.novisad.isaproject2023270048.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "assigned_role")
public class AssignedRoleModel extends BaseModel {

	@ManyToOne(optional = false)
	@JoinColumn(name = "role_id", nullable = false)
	private RoleModel role;

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private UserModel user;

	public AssignedRoleModel() {
		super();
	}

	public AssignedRoleModel(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public AssignedRoleModel(RoleModel role, UserModel user) {
		this();
		this.role = role;
		this.user = user;
	}

	public AssignedRoleModel(Long id, Boolean active, LocalDateTime createdAt, RoleModel role, UserModel user) {
		this(id, active, createdAt);
		this.role = role;
		this.user = user;
	}

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

}
