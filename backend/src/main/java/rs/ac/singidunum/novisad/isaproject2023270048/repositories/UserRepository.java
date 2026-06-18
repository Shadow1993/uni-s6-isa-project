package rs.ac.singidunum.novisad.isaproject2023270048.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.novisad.isaproject2023270048.models.UserModel;

@Repository
public interface UserRepository extends BaseRepository<UserModel> {
	
//	Does a left join fetch grabbing roles
	@EntityGraph(attributePaths = {"assignedRoles", "assignedRoles.role"})
	UserModel findByEmailAndActiveTrue(String email);
	
	Boolean existsByEmailAndActiveTrue(String email);
	
}
