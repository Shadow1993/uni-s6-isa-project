package rs.ac.singidunum.novisad.isaproject2023270048.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import rs.ac.singidunum.novisad.isaproject2023270048.models.ClusterModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ContainerModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ImageModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.NodeModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.NodeStatusEnum;
import rs.ac.singidunum.novisad.isaproject2023270048.models.RoleModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserModel;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.RoleRepository;
import rs.ac.singidunum.novisad.isaproject2023270048.services.ClusterService;
import rs.ac.singidunum.novisad.isaproject2023270048.services.ContainerService;
import rs.ac.singidunum.novisad.isaproject2023270048.services.ImageService;
import rs.ac.singidunum.novisad.isaproject2023270048.services.NodeService;
import rs.ac.singidunum.novisad.isaproject2023270048.services.UserService;

@Configuration
public class DataInitializer {

	@Bean
	CommandLineRunner initDatabase(UserService userService, RoleRepository roleRepository,
			ClusterService clusterService, NodeService nodeService, ImageService imageService, ContainerService containerService) {

		return args -> {
			if (roleRepository.count() == 0) {
				RoleModel roleAdmin = roleRepository.save(new RoleModel("ADMIN"));
				RoleModel roleUser = roleRepository.save(new RoleModel("USER"));

				UserModel userAdmin = userService.register("admin@example.com", "admin", roleAdmin);
				UserModel userUser1 = userService.register("user1@example.com", "password", roleUser);
				UserModel userUser2 = userService.register("user2@example.com", "password", roleUser);
				UserModel userUser3 = userService.register("user3@example.com", "password", roleUser);

				ClusterModel cluster1 = clusterService.create(new ClusterModel("cluster1", userAdmin));
				ClusterModel cluster2 =clusterService.create(new ClusterModel("cluster2", userAdmin));
				ClusterModel cluster3 =clusterService.create(new ClusterModel("cluster3", userAdmin));

				NodeModel node1 = nodeService.create(new NodeModel("node1", 1024l, 500000l, "https://testurl.com/node1",
						NodeStatusEnum.ONLINE, cluster1, userAdmin));
				NodeModel node2 = nodeService.create(new NodeModel("node2", 2048l, 1000000l, "https://testurl.com/node2",
						NodeStatusEnum.ONLINE, cluster1, userAdmin));
				NodeModel node3 = nodeService.create(new NodeModel("node3", 8192l, 2000000l, "https://testurl.com/node3",
						NodeStatusEnum.ONLINE, cluster1, userAdmin));
				NodeModel node4 = nodeService.create(new NodeModel("node4", 4096l, 1500000l, "https://testurl.com/node4",
						NodeStatusEnum.ONLINE, cluster2, userAdmin));
				NodeModel node5 = nodeService.create(new NodeModel("node5", 1024l, 500000l, "https://testurl.com/node5",
						NodeStatusEnum.ONLINE, cluster2, userAdmin));
				NodeModel node6 = nodeService.create(new NodeModel("node6", 512l, 1500000l, "https://testurl.com/node6",
						NodeStatusEnum.ONLINE, cluster2, userAdmin));
				NodeModel node7 = nodeService.create(new NodeModel("node7", 512l, 250000l, "https://testurl.com/node7",
						NodeStatusEnum.ONLINE, cluster3, userAdmin));
				NodeModel node8 = nodeService.create(new NodeModel("node8", 256l, 500000l, "https://testurl.com/node8",
						NodeStatusEnum.ONLINE, cluster3, userAdmin));
				NodeModel node9 = nodeService.create(new NodeModel("node9", 128000l, 500000l, "https://testurl.com/node9",
						NodeStatusEnum.ONLINE, cluster3, userAdmin));
				NodeModel node10 = nodeService.create(new NodeModel("node10", 256000l, 500000l, "https://testurl.com/node10",
						NodeStatusEnum.ONLINE, cluster3, userAdmin));
				
				ImageModel image1 = imageService.create(new ImageModel("image1", 128l, 300l, "https://some.storage.io/image1", 1l, userAdmin));
				ImageModel image2 = imageService.create(new ImageModel("image2", 228l, 700l, "https://some.storage.io/image2", 2l, userAdmin));
				ImageModel image3 = imageService.create(new ImageModel("image3", 828l, 1100l, "https://some.storage.io/image3", 4l, userAdmin));
				ImageModel image4 = imageService.create(new ImageModel("image4", 2228l, 3300l, "https://some.storage.io/image4", 5l, userAdmin));
				ImageModel image5 = imageService.create(new ImageModel("image5", 528l, 500l, "https://some.storage.io/image5", 2l, userAdmin));
				ImageModel image6 = imageService.create(new ImageModel("image6", 728l, 350l, "https://some.storage.io/image6", 11l, userAdmin));
				ImageModel image7 = imageService.create(new ImageModel("image7", 1028l, 5300l, "https://some.storage.io/image7", 12l, userAdmin));
				
				containerService.create(new ContainerModel("PFSense", image7, node10, userUser3));
				containerService.create(new ContainerModel("WSEasy", image1, node1, userUser2));
				containerService.create(new ContainerModel("PFSense", image7, node10, userUser2));
				containerService.create(new ContainerModel("Jellyfin", image2, node2, userUser3));
				containerService.create(new ContainerModel("Jellyfin", image5, node2, userUser3));
				containerService.create(new ContainerModel("TeamSpeak3", image7, node3, userUser1));
				containerService.create(new ContainerModel("WebServer", image5, node3, userUser1));
				containerService.create(new ContainerModel("Postgres", image4, node10, userUser1));
				containerService.create(new ContainerModel("Container", image6, node1, userUser3));
				containerService.create(new ContainerModel("VPN", image6, node2, userUser2));
				containerService.create(new ContainerModel("PIHole", image2, node5, userUser1));
				containerService.create(new ContainerModel("WireGuard", image2, node5, userUser2));
				containerService.create(new ContainerModel("WIREGUARD", image1, node7, userUser2));
				containerService.create(new ContainerModel("AngularApp", image7, node9, userUser3));
				containerService.create(new ContainerModel("Backend", image1, node9, userUser3));
				containerService.create(new ContainerModel("Frontend", image3, node6, userUser1));
				containerService.create(new ContainerModel("Playground", image3, node6, userUser1));
				containerService.create(new ContainerModel("Testbox", image4, node6, userUser1));
				containerService.create(new ContainerModel("OpenWRT", image6, node10, userUser1));
				containerService.create(new ContainerModel("MyGit", image4, node10, userUser3));
				containerService.create(new ContainerModel("Gameserver", image7, node4, userUser2));
				containerService.create(new ContainerModel("Have I Gone too far?", image5, node8, userUser3));

			}
		};
	}
}
