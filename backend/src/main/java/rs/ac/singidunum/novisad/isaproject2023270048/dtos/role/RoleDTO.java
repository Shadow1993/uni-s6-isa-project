package rs.ac.singidunum.novisad.isaproject2023270048.dtos.role;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.BaseDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.assignedrole.AssignedRoleDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.models.RoleModel;

public class RoleDTO extends BaseDTO<RoleModel> {

	private String name;
	private List<AssignedRoleDTOLeaf> assignedRoles = new ArrayList<AssignedRoleDTOLeaf>();

	public RoleDTO() {
		super();
	}

	public RoleDTO(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public RoleDTO(String name) {
		super();
		this.name = name;
	}

	public RoleDTO(String name, List<AssignedRoleDTOLeaf> assignedRoles) {
		super();
		this.name = name;
		this.assignedRoles = assignedRoles;
	}

	public RoleDTO(Long id, Boolean active, LocalDateTime createdAt, String name) {
		super(id, active, createdAt);
		this.name = name;
	}

	public RoleDTO(Long id, Boolean active, LocalDateTime createdAt, String name,
			List<AssignedRoleDTOLeaf> assignedRoles) {
		super(id, active, createdAt);
		this.name = name;
		this.assignedRoles = assignedRoles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AssignedRoleDTOLeaf> getAssignedRoles() {
		return assignedRoles;
	}

	public void setAssignedRoles(List<AssignedRoleDTOLeaf> assignedRoles) {
		this.assignedRoles = assignedRoles;
	}

}
