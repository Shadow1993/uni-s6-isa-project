package rs.ac.singidunum.novisad.isaproject2023270048.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.cluster.ClusterDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.cluster.ClusterDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ClusterModel;

@Component
@Mapper(componentModel = "spring")
public abstract class ClusterMapper extends BaseMapper<ClusterModel, ClusterDTO, ClusterDTOLeaf> {

}
