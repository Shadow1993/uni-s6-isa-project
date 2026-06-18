package rs.ac.singidunum.novisad.isaproject2023270048.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.isaproject2023270048.exceptions.BusinessException;
import rs.ac.singidunum.novisad.isaproject2023270048.exceptions.PatchFailedException;
import rs.ac.singidunum.novisad.isaproject2023270048.models.AssignedRoleModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.RoleModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserPrincipal;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.AssignedRoleRepository;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.RoleRepository;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.UserRepository;
import rs.ac.singidunum.novisad.isaproject2023270048.utils.EmailValidator;

@Service
public class UserService extends BaseService<UserModel, UserRepository> {
	
	private BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder(10);
	private RoleRepository roleRepository;
	private AssignedRoleRepository assignedRoleRepository;
	
	public UserService(UserRepository repo, RoleRepository roleRepository, AssignedRoleRepository assignedRoleRepository) {
		super(repo);
		this.roleRepository = roleRepository;
		this.assignedRoleRepository = assignedRoleRepository;
	}
	
	public UserModel register(String email, String rawPassword) {
		
		RoleModel role = roleRepository.findByName("USER");
		
        return register(email, rawPassword, role);
    }
	
	public UserModel register(String email, String rawPassword, RoleModel role) {
		
		if (!EmailValidator.isValid(email)) {
			throw new BusinessException("Provided email is not valid");
		}
		
		if (repo.existsByEmailAndActiveTrue(email)) {
			throw new BusinessException("A user with this email already exists");
		}
		
		UserModel savedUser = saveValidUser(email, rawPassword);
		
        return setupUserRole(savedUser, role);
    }
	
	public Boolean changePassword(String rawOldPassword, String rawNewPassword) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Object principal = authentication.getPrincipal();
        
        if (principal instanceof UserPrincipal user) {
            UserModel savedUser = repo.findByEmailAndActiveTrue(user.getUsername());
            if (!encoder.matches(rawOldPassword, savedUser.getPassword())) {
            	throw new PatchFailedException("Incorrect original password.");
            }
            savedUser.setPassword(encoder.encode(rawNewPassword));
            updatePatch(savedUser.getId(), savedUser);
            return true;
        }
        return false;
	}
	
	private UserModel saveValidUser(String email, String rawPassword) {
		String password = encoder.encode(rawPassword);

		UserModel user = new UserModel(email, password);
		
		UserModel savedUser = repo.save(user);
		
		return savedUser;
	}
	
	private UserModel setupUserRole(UserModel savedUser, RoleModel role) {
		AssignedRoleModel assignedRole = new AssignedRoleModel(role, savedUser);
		
		AssignedRoleModel savedAssignedRole = assignedRoleRepository.save(assignedRole);
		
		List<AssignedRoleModel> roles = new ArrayList<AssignedRoleModel>();
		roles.add(savedAssignedRole);
		
		savedUser.setAssignedRoles(roles);
		
		return savedUser;
	}
	
	public UserModel findByEmail(String email) {
		return repo.findByEmailAndActiveTrue(email);
	}

}
