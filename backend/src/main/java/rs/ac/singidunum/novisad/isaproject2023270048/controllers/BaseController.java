package rs.ac.singidunum.novisad.isaproject2023270048.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.BaseDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.mappers.BaseMapper;
import rs.ac.singidunum.novisad.isaproject2023270048.models.BaseModel;
import rs.ac.singidunum.novisad.isaproject2023270048.services.BaseService;

public abstract class BaseController<
		T extends BaseModel,
		DTO extends BaseDTO<T>,
		DTOLeaf extends BaseDTO<T>,
		Mapper extends BaseMapper<T, DTO, DTOLeaf>
> {

    BaseService<T> service;
    Mapper mapper;

    public BaseController(BaseService<T> service, Mapper mapper){
        this.service = service;
        this.mapper = mapper;
    }
	@GetMapping
	public List<DTO> findAll() {
		List<DTO> result = new ArrayList<>();
		service.findAll().forEach(item -> result.add(mapper.entityToDTO(item)));
		return result;
	}

	@GetMapping("/{id}")
	public DTO findById(@PathVariable Long id) {
		return mapper.entityToDTO(service.findById(id));
	}

	@PostMapping
	public DTO create(@RequestBody DTO item) {
		return mapper.entityToDTO(service.create(mapper.DTOToEntity(item)));
	}

	@PutMapping("/{id}")
	public DTO updatePut(@PathVariable  Long id, @RequestBody DTO item) {
		return mapper.entityToDTO(service.update(id, mapper.DTOToEntity(item)));
	}

	@PatchMapping("/{id}")
	public DTO updatePatch(@PathVariable Long id, @RequestBody DTO item) {
		return mapper.entityToDTO(service.updatePatch(id, mapper.DTOToEntity(item)));
	}

	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable Long id) {
		return service.deleteById(id);
	}
}
