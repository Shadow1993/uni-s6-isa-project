package rs.ac.singidunum.novisad.isaproject2023270048.dtos.user;

import java.time.LocalDateTime;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.BaseDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserModel;

public class UserDTOLeaf extends BaseDTO<UserModel> {

	private String email;
	private String password;

	public UserDTOLeaf() {
		super();
	}

	public UserDTOLeaf(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public UserDTOLeaf(String email, String password) {
		this();
		this.email = email;
		this.password = password;
	}

	public UserDTOLeaf(Long id, Boolean active, LocalDateTime createdAt, String email, String password) {
		this(id, active, createdAt);
		this.email = email;
		this.password = password;
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

}
