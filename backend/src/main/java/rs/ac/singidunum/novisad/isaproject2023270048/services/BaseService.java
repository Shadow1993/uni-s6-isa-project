package rs.ac.singidunum.novisad.isaproject2023270048.services;

import java.lang.reflect.Field;
import java.util.List;

import rs.ac.singidunum.novisad.isaproject2023270048.exceptions.PatchFailedException;
import rs.ac.singidunum.novisad.isaproject2023270048.exceptions.ResourceNotFoundException;
import rs.ac.singidunum.novisad.isaproject2023270048.models.BaseModel;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.BaseRepository;

public abstract class BaseService<T extends BaseModel> {

	BaseRepository<T> repo;

	public BaseService(BaseRepository<T> repo) {
		this.repo = repo;
	}

	public List<T> findAll() {
		return repo.findAll();
	}

	public T findById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not found"));
	}

	public T create(T item) {
		return repo.save(item);
	}

	public T update(Long id, T item) {
		this.findById(id);

		item.setId(id);

		return repo.save(item);
	}

	public T updatePatch(Long id, T item) {
		T exists = this.findById(id);
		for (Field field : item.getClass().getDeclaredFields()) {
			// private field access
			field.setAccessible(true);
			try {
				Object value = field.get(item);
				if (value != null) {
					field.set(exists, value);
				}
			} catch (IllegalAccessException e) {
				throw new PatchFailedException("Patch failed for field: " + field.getName());
			}
		}
		return repo.save(exists);
	}

	public boolean delete(T item) {
		return this.deleteById(item.getId());
	}

	public boolean deleteById(Long id) {
		this.findById(id);
		repo.deleteById(id);
		return true;
	}

}
