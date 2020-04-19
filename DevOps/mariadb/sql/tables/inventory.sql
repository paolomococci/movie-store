CREATE TABLE `inventory` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `store_fk` bigint(20) unsigned DEFAULT NULL,
  `movie_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `inventory_to_store_fk` (`store_fk`),
  KEY `inventory_to_movie_fk` (`movie_fk`),
  CONSTRAINT `inventory_to_movie_fk` FOREIGN KEY (`movie_fk`) REFERENCES `movie` (`id`) ON DELETE SET NULL,
  CONSTRAINT `inventory_to_store_fk` FOREIGN KEY (`store_fk`) REFERENCES `store` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='inventory data table'
