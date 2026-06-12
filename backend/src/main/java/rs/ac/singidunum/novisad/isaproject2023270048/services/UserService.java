package rs.ac.singidunum.novisad.isaproject2023270048.services;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.isaproject2023270048.models.UserModel;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.UserRepository;

@Service
public class UserService extends BaseService<UserModel> {

	public UserService(UserRepository repo) {
		super(repo);
	}

}
