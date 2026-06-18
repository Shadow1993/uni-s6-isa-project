package rs.ac.singidunum.novisad.isaproject2023270048.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.security.auth.message.AuthException;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.auth.ChangePasswordDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.auth.LoginRequestDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.auth.LoginResponseDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.user.UserDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.mappers.UserMapper;
import rs.ac.singidunum.novisad.isaproject2023270048.services.AuthenticationService;
import rs.ac.singidunum.novisad.isaproject2023270048.services.UserService;

@RestController
@RequestMapping(value = { "/auth" })
public class AuthenticationController {

	private AuthenticationService authService;
	private UserService userService;
	private UserMapper userMapper;

	public AuthenticationController(AuthenticationService authService, UserService userService, UserMapper userMapper) {
		super();
		this.authService = authService;
		this.userService = userService;
		this.userMapper = userMapper;
	}

	@PreAuthorize("isAnonymous()")
	@PostMapping("/register")
	public UserDTO register(@RequestBody LoginRequestDTO dto) {
		return userMapper.entityToDTO(userService.register(dto.getEmail(), dto.getPassword()));
	}

	@PreAuthorize("isAnonymous()")
	@PostMapping("/login")
	public LoginResponseDTO login(@RequestBody LoginRequestDTO dto) throws AuthException {

		LoginResponseDTO response = authService.verify(dto);

		return response;
	}

	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	@PostMapping("/changepassword")
	public Boolean changePassword(@RequestBody ChangePasswordDTO dto) {
		return userService.changePassword(dto.getOldPassword(), dto.getNewPassword());
	}

}
