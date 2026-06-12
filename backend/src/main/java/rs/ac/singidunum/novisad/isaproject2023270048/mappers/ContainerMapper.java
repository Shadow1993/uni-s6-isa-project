package rs.ac.singidunum.novisad.isaproject2023270048.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.container.ContainerDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.container.ContainerDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ContainerModel;

@Component
@Mapper(componentModel = "spring")
public abstract class ContainerMapper extends BaseMapper<ContainerModel, ContainerDTO, ContainerDTOLeaf> {

}
