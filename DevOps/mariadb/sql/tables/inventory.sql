CREATE TABLE `inventory` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  CONSTRAINT `inventory_movie_fk` FOREIGN KEY (`id`) REFERENCES `movie` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `inventory_store_fk` FOREIGN KEY (`id`) REFERENCES `store` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='inventory data table';
