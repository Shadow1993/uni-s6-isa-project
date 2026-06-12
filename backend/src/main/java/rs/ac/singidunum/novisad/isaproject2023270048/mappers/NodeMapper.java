package rs.ac.singidunum.novisad.isaproject2023270048.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.node.NodeDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.node.NodeDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.models.NodeModel;

@Component
@Mapper(componentModel = "spring", uses = { ContainerMapper.class })
public abstract class NodeMapper extends BaseMapper<NodeModel, NodeDTO, NodeDTOLeaf> {

}
