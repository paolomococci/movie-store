CREATE TABLE `district` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `city_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKssu7out7o2kj77x6q2i109e6` (`city_fk`),
  CONSTRAINT `FKssu7out7o2kj77x6q2i109e6` FOREIGN KEY (`city_fk`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
