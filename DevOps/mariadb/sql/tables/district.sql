CREATE TABLE `district` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `code` varchar(6) NOT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `city_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `district_to_city_fk` (`city_fk`),
  CONSTRAINT `district_to_city_fk` FOREIGN KEY (`city_fk`) REFERENCES `city` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='district data table';
