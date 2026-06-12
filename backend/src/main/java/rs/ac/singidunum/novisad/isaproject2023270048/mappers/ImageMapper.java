package rs.ac.singidunum.novisad.isaproject2023270048.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.image.ImageDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.image.ImageDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ImageModel;

@Component
@Mapper(componentModel = "spring", uses = { ContainerMapper.class })
public abstract class ImageMapper extends BaseMapper<ImageModel, ImageDTO, ImageDTOLeaf> {

}
