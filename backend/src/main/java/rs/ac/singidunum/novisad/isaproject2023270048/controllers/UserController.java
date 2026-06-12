package rs.ac.singidunum.novisad.isaproject2023270048.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.user.UserDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.user.UserDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.mappers.UserMapper;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserModel;
import rs.ac.singidunum.novisad.isaproject2023270048.services.UserService;

@RestController
@RequestMapping(value = { "/api/users" })
public class UserController extends BaseController<UserModel, UserDTO, UserDTOLeaf, UserMapper> {

	public UserController(UserService service, UserMapper mapper) {
		super(service, mapper);
	}

}
