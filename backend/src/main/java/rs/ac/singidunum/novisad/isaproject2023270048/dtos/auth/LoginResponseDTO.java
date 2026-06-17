package rs.ac.singidunum.novisad.isaproject2023270048.dtos.auth;

public class LoginResponseDTO {

	private String token;

	public LoginResponseDTO() {
		super();
	}

	public LoginResponseDTO(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
