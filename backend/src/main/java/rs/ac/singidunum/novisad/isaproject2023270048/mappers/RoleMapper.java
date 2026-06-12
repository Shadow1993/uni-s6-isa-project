package rs.ac.singidunum.novisad.isaproject2023270048.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.role.RoleDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.role.RoleDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.models.RoleModel;

@Component
@Mapper(componentModel = "spring", uses = { AssignedRoleMapper.class })
public abstract class RoleMapper extends BaseMapper<RoleModel, RoleDTO, RoleDTOLeaf> {

}
