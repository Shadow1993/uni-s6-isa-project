package rs.ac.singidunum.novisad.isaproject2023270048.dtos.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.BaseDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.assignedrole.AssignedRoleDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserModel;

public class UserCleanDTO extends BaseDTO<UserModel> {
	
	private String email;
	private List<AssignedRoleDTOLeaf> assignedRoles = new ArrayList<AssignedRoleDTOLeaf>();

	public UserCleanDTO() {
		super();
	}

	public UserCleanDTO(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public UserCleanDTO(String email) {
		this();
		this.email = email;
	}

	public UserCleanDTO(String email, List<AssignedRoleDTOLeaf> assignedRoles) {
		this();
		this.email = email;
		this.assignedRoles = assignedRoles;
	}

	public UserCleanDTO(Long id, Boolean active, LocalDateTime createdAt, String email) {
		this(id, active, createdAt);
		this.email = email;
	}

	public UserCleanDTO(Long id, Boolean active, LocalDateTime createdAt, String email, List<AssignedRoleDTOLeaf> assignedRoles) {
		this(id, active, createdAt);
		this.email = email;
		this.assignedRoles = assignedRoles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<AssignedRoleDTOLeaf> getAssignedRoles() {
		return assignedRoles;
	}

	public void setAssignedRoles(List<AssignedRoleDTOLeaf> assignedRoles) {
		this.assignedRoles = assignedRoles;
	}
}
