package rs.ac.singidunum.novisad.isaproject2023270048.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.auth.LoginRequestDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.user.UserCleanDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.user.UserDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.user.UserDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserModel;

@Component
@Mapper(componentModel = "spring", uses = { AssignedRoleMapper.class })
public abstract class UserMapper extends BaseMapper<UserModel, UserDTO, UserDTOLeaf> {
	public abstract UserDTO toResponse(UserModel user);
	public abstract UserModel registerToEntity(LoginRequestDTO dto);
	public abstract UserCleanDTO entityToCleanDTO(UserModel user);
}
