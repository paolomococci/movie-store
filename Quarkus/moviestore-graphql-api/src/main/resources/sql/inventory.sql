CREATE TABLE `inventory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `updated` datetime(6) DEFAULT NULL,
  `store_fk` bigint(20) DEFAULT NULL,
  `movie_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmt509f7cu666uym7sud2mtw2r` (`store_fk`),
  KEY `FK9e1xmu2xtghox18wyrlr4rog2` (`movie_fk`),
  CONSTRAINT `FK9e1xmu2xtghox18wyrlr4rog2` FOREIGN KEY (`movie_fk`) REFERENCES `movie` (`id`),
  CONSTRAINT `FKmt509f7cu666uym7sud2mtw2r` FOREIGN KEY (`store_fk`) REFERENCES `store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
