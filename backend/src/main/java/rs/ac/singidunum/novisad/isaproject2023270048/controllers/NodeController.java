package rs.ac.singidunum.novisad.isaproject2023270048.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.node.NodeDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.node.NodeDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.mappers.NodeMapper;
import rs.ac.singidunum.novisad.isaproject2023270048.models.NodeModel;
import rs.ac.singidunum.novisad.isaproject2023270048.services.NodeService;

@RestController
@RequestMapping(value = { "/api/nodes" })
public class NodeController extends BaseController<NodeModel, NodeDTO, NodeDTOLeaf, NodeMapper> {

	public NodeController(NodeService service, NodeMapper mapper) {
		super(service, mapper);
	}
	
}
