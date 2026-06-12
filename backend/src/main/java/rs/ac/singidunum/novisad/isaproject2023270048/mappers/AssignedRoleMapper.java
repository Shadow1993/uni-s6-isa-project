package rs.ac.singidunum.novisad.isaproject2023270048.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.assignedrole.AssignedRoleDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.assignedrole.AssignedRoleDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.models.AssignedRoleModel;

@Component
@Mapper(componentModel = "spring")
public abstract class AssignedRoleMapper extends BaseMapper<AssignedRoleModel, AssignedRoleDTO, AssignedRoleDTOLeaf> {

}
