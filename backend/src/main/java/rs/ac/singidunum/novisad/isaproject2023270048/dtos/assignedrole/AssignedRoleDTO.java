package rs.ac.singidunum.novisad.isaproject2023270048.dtos.assignedrole;

import java.time.LocalDateTime;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.BaseDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.role.RoleDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.user.UserDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.models.AssignedRoleModel;

public class AssignedRoleDTO extends BaseDTO<AssignedRoleModel> {

	private RoleDTOLeaf role;
	private UserDTOLeaf user;

	public AssignedRoleDTO() {
		super();
	}

	public AssignedRoleDTO(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public AssignedRoleDTO(RoleDTOLeaf role, UserDTOLeaf user) {
		this();
		this.role = role;
		this.user = user;
	}

	public AssignedRoleDTO(Long id, Boolean active, LocalDateTime createdAt, RoleDTOLeaf role, UserDTOLeaf user) {
		this(id, active, createdAt);
		this.role = role;
		this.user = user;
	}

	public RoleDTOLeaf getRole() {
		return role;
	}

	public void setRole(RoleDTOLeaf role) {
		this.role = role;
	}

	public UserDTOLeaf getUser() {
		return user;
	}

	public void setUser(UserDTOLeaf user) {
		this.user = user;
	}

}
