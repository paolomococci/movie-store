CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `civic` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `district_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfx5yqnw5eihcfaubq9sqq0ca1` (`district_fk`),
  CONSTRAINT `FKfx5yqnw5eihcfaubq9sqq0ca1` FOREIGN KEY (`district_fk`) REFERENCES `district` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
