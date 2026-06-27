package rs.ac.singidunum.novisad.isaproject2023270048.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.auth.LoginRequestDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.auth.LoginResponseDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserModel;

@Service
public class AuthenticationService {

	private AuthenticationManager authManager;
	private JWTService jwtService;
	private UserService userService;

	public AuthenticationService(AuthenticationManager authManager, JWTService jwtService, UserService userService) {
		super();
		this.authManager = authManager;
		this.jwtService = jwtService;
		this.userService = userService;
	}

	public LoginResponseDTO verify(LoginRequestDTO loginDTO) {
		LoginResponseDTO loginResponse = new LoginResponseDTO();
		Authentication auth = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
		if (auth.isAuthenticated()) {
			UserModel user = userService.findByEmail(loginDTO.getEmail());
			if (user != null && user.getActive()) {
				String token = jwtService.generateToken(user);				
				loginResponse.setToken(token);
			} else {
				throw new BadCredentialsException("Check credentials");
			}
		}

		return loginResponse;
	}
}
