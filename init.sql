CREATE DATABASE IF NOT EXISTS `isaproject_2023270048`;
USE `isaproject_2023270048`;

-- ------------------------------------------------------
-- Table: application_user
-- ------------------------------------------------------
CREATE TABLE IF NOT EXISTS `application_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKcb61p28hanadv7k0nx1ec0n5l` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `application_user` VALUES 
(1, 1, '2026-06-20 19:02:31.377660', 'admin@example.com', '$2a$10$Hw.y.S5zl1ErROrCV8qgYeeC9a5/M1BNQd9rKL7dy8ymD.V1aQU2K'),
(2, 1, '2026-06-20 19:02:31.549213', 'user1@example.com', '$2a$10$KFog6Mr6EpojlZLdVBbSQufPZUikCfj.eTYd9ST4mHaeaE2l.UjDa'),
(3, 0, '2026-06-20 19:02:31.908784', 'user2@example.com', '$2a$10$kkxu/iHRVjpcJf9dN.DaqOSdrCD1pbJ2hcduwk2B/ZX8zynIzDsAK'),
(4, 1, '2026-06-20 19:02:32.215142', 'user3@example.com', '$2a$10$urxmXAjyFlTqZLN84wH6HuT6FrTSzjtE96D7VDjB2WHHnmKdX5WGi'),
(5, 1, '2026-06-20 19:14:52.130464', 'testing@test.com', '$2a$10$NvWKSaUxVwgnTFzn0D/v9.3VCw0H0vlxuJ6SogqPoHSd8Zv0dJVCu') ON duplicate key UPDATE id=id;

-- ------------------------------------------------------
-- Table: role
-- ------------------------------------------------------
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK8sewwnpamngi6b1dwaa88askk` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `role` VALUES 
(1, 1, '2026-06-20 19:02:31.065488', 'ADMIN'),
(2, 1, '2026-06-20 19:02:31.152844', 'USER') ON duplicate key UPDATE id=id;

-- ------------------------------------------------------
-- Table: assigned_role
-- ------------------------------------------------------
CREATE TABLE IF NOT EXISTS `assigned_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `role_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe2xidm130oikyce9i721wmj2h` (`role_id`),
  KEY `FK5hhti9me7ybi0ruaxe7v6duga` (`user_id`),
  CONSTRAINT `FK5hhti9me7ybi0ruaxe7v6duga` FOREIGN KEY (`user_id`) REFERENCES `application_user` (`id`),
  CONSTRAINT `FKe2xidm130oikyce9i721wmj2h` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `assigned_role` VALUES 
(1, 1, '2026-06-20 19:02:31.419639', 1, 1),
(2, 1, '2026-06-20 19:02:31.724177', 2, 2),
(3, 1, '2026-06-20 19:02:32.052180', 2, 3),
(4, 1, '2026-06-20 19:02:32.323731', 2, 4),
(5, 1, '2026-06-20 19:14:52.210334', 2, 5) ON duplicate key UPDATE id=id;

-- ------------------------------------------------------
-- Table: cluster
-- ------------------------------------------------------
CREATE TABLE IF NOT EXISTS `cluster` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `name` varchar(255) NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK9ig73x9wropf95ogrffcvyahk` (`name`),
  KEY `FK6ebavbgqf21o4y8sxifrwwgmw` (`user_id`),
  CONSTRAINT `FK6ebavbgqf21o4y8sxifrwwgmw` FOREIGN KEY (`user_id`) REFERENCES `application_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `cluster` VALUES 
(1, 1, '2026-06-20 19:02:32.424216', 'cluster1', 1),
(2, 1, '2026-06-20 19:02:32.547521', 'cluster2', 1),
(3, 1, '2026-06-20 19:02:32.659226', 'cluster3', 1);

-- ------------------------------------------------------
-- Table: image
-- ------------------------------------------------------
CREATE TABLE IF NOT EXISTS `image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `name` varchar(255) NOT NULL,
  `required_ram` bigint NOT NULL,
  `required_storage` bigint NOT NULL,
  `url` varchar(255) NOT NULL,
  `version` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKslbkrjwmowtwl5nyjcr2gv3ag` (`user_id`),
  CONSTRAINT `FKslbkrjwmowtwl5nyjcr2gv3ag` FOREIGN KEY (`user_id`) REFERENCES `application_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `image` VALUES 
(1, 1, '2026-06-20 19:02:33.925380', 'image1', 128, 300, 'https://some.storage.io/image1', 1, 1),
(2, 1, '2026-06-20 19:02:34.037715', 'image2', 228, 700, 'https://some.storage.io/image2', 2, 1),
(3, 1, '2026-06-20 19:02:34.160713', 'image3', 828, 1100, 'https://some.storage.io/image3', 4, 1),
(4, 1, '2026-06-20 19:02:34.316846', 'image4', 2228, 3300, 'https://some.storage.io/image4', 5, 1),
(5, 1, '2026-06-20 19:02:34.377302', 'image5', 528, 500, 'https://some.storage.io/image5', 2, 1),
(6, 1, '2026-06-20 19:02:34.455583', 'image6', 728, 350, 'https://some.storage.io/image6', 11, 1),
(7, 1, '2026-06-20 19:02:34.532844', 'image7', 1028, 5300, 'https://some.storage.io/image7', 12, 1);

-- ------------------------------------------------------
-- Table: node
-- ------------------------------------------------------
CREATE TABLE IF NOT EXISTS `node` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `name` varchar(255) NOT NULL,
  `ram` bigint NOT NULL,
  `status` enum('MAINTENANCE','OFFLINE','ONLINE') NOT NULL,
  `storage` bigint NOT NULL,
  `url` varchar(255) NOT NULL,
  `cluster_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf1rk6rhkl24eodvi603oftldl` (`cluster_id`),
  KEY `FKdy2h2ti7y1xpgjcpi4k1t8e6h` (`user_id`),
  CONSTRAINT `FKdy2h2ti7y1xpgjcpi4k1t8e6h` FOREIGN KEY (`user_id`) REFERENCES `application_user` (`id`),
  CONSTRAINT `FKf1rk6rhkl24eodvi603oftldl` FOREIGN KEY (`cluster_id`) REFERENCES `cluster` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `node` VALUES 
(1, 1, '2026-06-20 19:02:32.783588', 'node1', 1024, 'ONLINE', 500000, 'https://testurl.com/node1', 1, 1),
(2, 1, '2026-06-20 19:02:32.885581', 'node2', 2048, 'ONLINE', 1000000, 'https://testurl.com/node2', 1, 1),
(3, 1, '2026-06-20 19:02:32.987696', 'node3', 8192, 'ONLINE', 2000000, 'https://testurl.com/node3', 1, 1),
(4, 1, '2026-06-20 19:02:33.090647', 'node4', 4096, 'ONLINE', 1500000, 'https://testurl.com/node4', 2, 1),
(5, 1, '2026-06-20 19:02:33.204760', 'node5', 1024, 'ONLINE', 500000, 'https://testurl.com/node5', 2, 1),
(6, 1, '2026-06-20 19:02:33.395737', 'node6', 512, 'ONLINE', 1500000, 'https://testurl.com/node6', 2, 1),
(7, 1, '2026-06-20 19:02:33.497181', 'node7', 512, 'ONLINE', 250000, 'https://testurl.com/node7', 3, 1),
(8, 1, '2026-06-20 19:02:33.598393', 'node8', 256, 'ONLINE', 500000, 'https://testurl.com/node8', 3, 1),
(9, 1, '2026-06-20 19:02:33.699669', 'node9', 128000, 'ONLINE', 500000, 'https://testurl.com/node9', 3, 1),
(10, 1, '2026-06-20 19:02:33.813105', 'node10', 256000, 'ONLINE', 500000, 'https://testurl.com/node10', 3, 1);

-- ------------------------------------------------------
-- Table: container
-- ------------------------------------------------------
CREATE TABLE IF NOT EXISTS `container` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `name` varchar(255) NOT NULL,
  `started_at` datetime(6) DEFAULT NULL,
  `status` enum('FAILED','RUNNING','STOPPED') NOT NULL,
  `stopped_at` datetime(6) DEFAULT NULL,
  `image_id` bigint NOT NULL,
  `node_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK42igijl9c5598jpx1ognd9hgp` (`image_id`),
  KEY `FKhy2fv9wkl7f2b0m0yjmmk7cc7` (`node_id`),
  KEY `FKq7orspbwo4jqt8tjkymew6yvd` (`user_id`),
  CONSTRAINT `FK42igijl9c5598jpx1ognd9hgp` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`),
  CONSTRAINT `FKhy2fv9wkl7f2b0m0yjmmk7cc7` FOREIGN KEY (`node_id`) REFERENCES `node` (`id`),
  CONSTRAINT `FKq7orspbwo4jqt8tjkymew6yvd` FOREIGN KEY (`user_id`) REFERENCES `application_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `container` VALUES 
(1, 1, '2026-06-20 19:02:34.610429', 'PFSense', NULL, 'STOPPED', NULL, 7, 10, 4),
(2, 1, '2026-06-20 19:02:34.688657', 'WSEasy', NULL, 'STOPPED', NULL, 1, 1, 3),
(3, 1, '2026-06-20 19:02:34.755384', 'PFSense', NULL, 'STOPPED', NULL, 7, 10, 3),
(4, 1, '2026-06-20 19:02:34.821493', 'Jellyfin', NULL, 'STOPPED', NULL, 2, 2, 4),
(5, 1, '2026-06-20 19:02:34.899201', 'Jellyfin', NULL, 'STOPPED', NULL, 5, 2, 4),
(6, 1, '2026-06-20 19:02:34.966234', 'TeamSpeak3', NULL, 'STOPPED', NULL, 7, 3, 2),
(7, 1, '2026-06-20 19:02:35.033668', 'WebServer', NULL, 'STOPPED', NULL, 5, 3, 2),
(8, 1, '2026-06-20 19:02:35.110705', 'Postgres', NULL, 'STOPPED', NULL, 4, 10, 2),
(9, 1, '2026-06-20 19:02:35.188738', 'Container', NULL, 'STOPPED', NULL, 6, 1, 4),
(10, 1, '2026-06-20 19:02:35.255228', 'VPN', NULL, 'STOPPED', NULL, 6, 2, 3),
(11, 1, '2026-06-20 19:02:35.333357', 'PIHole', NULL, 'STOPPED', NULL, 2, 5, 2),
(12, 1, '2026-06-20 19:02:35.410870', 'WireGuard', NULL, 'STOPPED', NULL, 2, 5, 3),
(13, 1, '2026-06-20 19:02:35.478350', 'WIREGUARD', NULL, 'STOPPED', NULL, 1, 7, 3),
(14, 1, '2026-06-20 19:02:35.556754', 'AngularApp', NULL, 'STOPPED', NULL, 7, 9, 4),
(15, 1, '2026-06-20 19:02:35.632940', 'Backend', NULL, 'STOPPED', NULL, 1, 9, 4),
(16, 1, '2026-06-20 19:02:35.711477', 'Frontend', NULL, 'STOPPED', NULL, 3, 6, 2),
(17, 1, '2026-06-20 19:02:35.789522', 'Playground', NULL, 'STOPPED', NULL, 3, 6, 2),
(18, 1, '2026-06-20 19:02:35.855951', 'Testbox', '2026-06-20 19:15:14.559785', 'STOPPED', '2026-06-20 19:15:20.421330', 4, 6, 2),
(19, 1, '2026-06-20 19:02:35.922677', 'OpenWRT', NULL, 'STOPPED', NULL, 6, 10, 2),
(20, 1, '2026-06-20 19:02:36.000717', 'MyGit', NULL, 'STOPPED', NULL, 4, 10, 4),
(21, 1, '2026-06-20 19:02:36.067505', 'Gameserver', NULL, 'STOPPED', NULL, 7, 4, 3),
(22, 1, '2026-06-20 19:02:36.178258', 'Have I Gone too far?', NULL, 'STOPPED', NULL, 5, 8, 4);