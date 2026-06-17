package rs.ac.singidunum.novisad.isaproject2023270048.services;

import java.lang.reflect.Field;
import java.util.List;

import rs.ac.singidunum.novisad.isaproject2023270048.exceptions.PatchFailedException;
import rs.ac.singidunum.novisad.isaproject2023270048.exceptions.ResourceNotFoundException;
import rs.ac.singidunum.novisad.isaproject2023270048.models.BaseModel;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.BaseRepository;

public abstract class BaseService<T extends BaseModel, R extends BaseRepository<T>> {

	R repo;

	public BaseService(R repo) {
		this.repo = repo;
	}

	public List<T> findAll() {
		return this.repo.findAll();
	}

	public T findById(Long id) {
		return this.repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not found"));
	}

	public T create(T item) {
		return this.repo.save(item);
	}

	public T update(Long id, T item) {
		this.findById(id);

		item.setId(id);

		return this.repo.save(item);
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
		return this.repo.save(exists);
	}

	public boolean delete(T item) {
		return this.deleteById(item.getId());
	}

	public boolean deleteById(Long id) {
		this.findById(id);
		this.repo.deleteById(id);
		return true;
	}
	
	public List<T> findAllActive() {
		return this.repo.findByActiveTrue();
	}
	
	public T findByIdActive(Long id) {
		return this.repo.findByIdAndActiveTrue(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not found"));
	}

}
