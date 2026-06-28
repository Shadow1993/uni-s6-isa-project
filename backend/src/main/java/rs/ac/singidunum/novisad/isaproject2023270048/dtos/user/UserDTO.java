package rs.ac.singidunum.novisad.isaproject2023270048.dtos.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.BaseDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.assignedrole.AssignedRoleDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserModel;

public class UserDTO extends BaseDTO<UserModel> {

	private String email;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private List<AssignedRoleDTO> assignedRoles = new ArrayList<AssignedRoleDTO>();

	public UserDTO() {
		super();
	}

	public UserDTO(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public UserDTO(String email, String password) {
		this();
		this.email = email;
		this.password = password;
	}

	public UserDTO(String email, String password, List<AssignedRoleDTO> assignedRoles) {
		this();
		this.email = email;
		this.password = password;
		this.assignedRoles = assignedRoles;
	}

	public UserDTO(Long id, Boolean active, LocalDateTime createdAt, String email, String password) {
		this(id, active, createdAt);
		this.email = email;
		this.password = password;
	}

	public UserDTO(Long id, Boolean active, LocalDateTime createdAt, String email, String password,
			List<AssignedRoleDTO> assignedRoles) {
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

	public List<AssignedRoleDTO> getAssignedRoles() {
		return assignedRoles;
	}

	public void setAssignedRoles(List<AssignedRoleDTO> assignedRoles) {
		this.assignedRoles = assignedRoles;
	}

}
