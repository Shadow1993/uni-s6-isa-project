package rs.ac.singidunum.novisad.isaproject2023270048.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.cluster.ClusterCreateDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.exceptions.BusinessException;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ClusterModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserPrincipal;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.ClusterRepository;

@Service
public class ClusterService extends BaseService<ClusterModel, ClusterRepository> {

	UserService userService;
	
	public ClusterService(ClusterRepository repo, UserService userService) {
		super(repo);
		this.userService = userService;
	}
	
	@Transactional
	public ClusterModel create(ClusterCreateDTO clusterDto) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		if (principal instanceof UserPrincipal userPrincipal) {
			UserModel user = userService.findByEmail(userPrincipal.getUsername());
			boolean exists = repo.existsByName(clusterDto.getName());
			if (exists) {
				throw new BusinessException("Name is already taken");
			}
			ClusterModel cluster = new ClusterModel(clusterDto.getName(), user);
			return super.create(cluster);
		}
		return null;

	}

}
