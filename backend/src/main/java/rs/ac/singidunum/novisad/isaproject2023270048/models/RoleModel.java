package rs.ac.singidunum.novisad.isaproject2023270048.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class RoleModel extends BaseModel {

	@Column(nullable = false, unique = true)
	private String name;

	@OneToMany(mappedBy = "role")
	private List<AssignedRoleModel> assignedRoles = new ArrayList<AssignedRoleModel>();

	public RoleModel() {
		super();
	}

	public RoleModel(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public RoleModel(String name) {
		this();
		this.name = name;
	}

	public RoleModel(String name, List<AssignedRoleModel> assignedRoles) {
		this();
		this.name = name;
		this.assignedRoles = assignedRoles;
	}

	public RoleModel(Long id, Boolean active, LocalDateTime createdAt, String name) {
		this(id, active, createdAt);
		this.name = name;
	}

	public RoleModel(Long id, Boolean active, LocalDateTime createdAt, String name,
			List<AssignedRoleModel> assignedRoles) {
		this(id, active, createdAt);
		this.name = name;
		this.assignedRoles = assignedRoles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AssignedRoleModel> getAssignedRoles() {
		return assignedRoles;
	}

	public void setAssignedRoles(List<AssignedRoleModel> assignedRoles) {
		this.assignedRoles = assignedRoles;
	}

}
