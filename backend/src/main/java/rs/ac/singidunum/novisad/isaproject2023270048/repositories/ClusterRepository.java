package rs.ac.singidunum.novisad.isaproject2023270048.repositories;

import org.springframework.stereotype.Repository;

import rs.ac.singidunum.novisad.isaproject2023270048.models.ClusterModel;

@Repository
public interface ClusterRepository extends BaseRepository<ClusterModel> {
	boolean existsByName(String name);
}
