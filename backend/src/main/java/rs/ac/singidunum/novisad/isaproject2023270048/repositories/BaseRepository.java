package rs.ac.singidunum.novisad.isaproject2023270048.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import rs.ac.singidunum.novisad.isaproject2023270048.models.BaseModel;

@NoRepositoryBean
public interface BaseRepository<T extends BaseModel> extends JpaRepository<T, Long> {
	
}
