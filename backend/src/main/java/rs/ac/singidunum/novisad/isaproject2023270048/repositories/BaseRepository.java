package rs.ac.singidunum.novisad.isaproject2023270048.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Long> {
	
	List<T> findByActiveTrue();
	
	Optional<T> findByIdAndActiveTrue(Long id);
	
}
