package rs.ac.singidunum.novisad.isaproject2023270048.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import rs.ac.singidunum.novisad.isaproject2023270048.models.ContainerModel;

@Repository
public interface ContainerRepository extends BaseRepository<ContainerModel> {
	List<ContainerModel> findAllByActiveTrueAndUserId(Long userid);
	Optional<ContainerModel> findByIdAndActiveTrueAndUserId(Long id, Long userid);
}
