package rs.ac.singidunum.novisad.isaproject2023270048.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.image.ImageCreateDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.exceptions.BusinessException;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ImageModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserPrincipal;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.ImageRepository;

@Service
public class ImageService extends BaseService<ImageModel, ImageRepository> {

	UserService userService;
	
	public ImageService(ImageRepository repo, UserService userService) {
		super(repo);
		this.userService = userService;
	}
	
	@Transactional
	public ImageModel create(ImageCreateDTO imageDto) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		if (principal instanceof UserPrincipal userPrincipal) {
			UserModel user = userService.findByEmail(userPrincipal.getUsername());

			ImageModel image = new ImageModel(imageDto.getName(), imageDto.getRequiredRam(), imageDto.getRequiredStorage(), imageDto.getUrl(), imageDto.getVersion(), user);
			
			if (image.getRequiredRam() < 1) {
				throw new BusinessException("requiredRam cannot be less than 1 MB");
			}
			if (image.getRequiredStorage() < 1) {
				throw new BusinessException("requiredStorage cannot be less than 1 MB");
			}
			if (image.getVersion() < 1) {
				throw new BusinessException("version cannot be less than 1");
			}
			
			return super.create(image);
		}
		return null;

	}
	
	@Transactional
	public ImageModel update(Long id, ImageCreateDTO imageDto) {

		ImageModel image = findById(id);
		image.setName(imageDto.getName());
		image.setUrl(imageDto.getUrl());
		
		if (image.getRequiredRam() < 1) {
			throw new BusinessException("requiredRam cannot be less than 1 MB");
		}
		image.setRequiredRam(imageDto.getRequiredRam());
		if (image.getRequiredStorage() < 1) {
			throw new BusinessException("requiredStorage cannot be less than 1 MB");
		}
		image.setRequiredStorage(imageDto.getRequiredStorage());
		if (image.getVersion() < 1) {
			throw new BusinessException("version cannot be less than 1");
		}
		image.setVersion(imageDto.getVersion());
		
		return super.create(image);

	}
	
	@Transactional
	public ImageModel updatePatch(Long id, ImageCreateDTO imageDto) {

		ImageModel image = findById(id);
		
		if (imageDto.getName() != null) {			
			image.setName(imageDto.getName());
		}
		if (imageDto.getUrl() != null) {
			image.setUrl(imageDto.getUrl());
		}

		if (image.getRequiredRam() < 1) {
			throw new BusinessException("requiredRam cannot be less than 1 MB");
		}
		image.setRequiredRam(imageDto.getRequiredRam());

		if (image.getRequiredStorage() < 1) {
			throw new BusinessException("requiredStorage cannot be less than 1 MB");
		}
		image.setRequiredStorage(imageDto.getRequiredStorage());
		if (image.getVersion() < 1) {
			throw new BusinessException("version cannot be less than 1");
		}
		image.setVersion(imageDto.getVersion());
		
		return super.create(image);
	}

}
