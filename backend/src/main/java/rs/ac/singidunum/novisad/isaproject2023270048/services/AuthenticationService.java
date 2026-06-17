package rs.ac.singidunum.novisad.isaproject2023270048.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.auth.LoginRequestDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.auth.LoginResponseDTO;

@Service
public class AuthenticationService {

	private AuthenticationManager authManager;
	private JWTService jwtService;

	public AuthenticationService(AuthenticationManager authManager, JWTService jwtService) {
		super();
		this.authManager = authManager;
		this.jwtService = jwtService;
	}

	public LoginResponseDTO verify(LoginRequestDTO loginDTO) {
		LoginResponseDTO loginResponse = new LoginResponseDTO();
		Authentication auth = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
		if (auth.isAuthenticated()) {
			String token = jwtService.generateToken(loginDTO.getEmail());
			loginResponse.setToken(token);
		}

		return loginResponse;
	}
}
