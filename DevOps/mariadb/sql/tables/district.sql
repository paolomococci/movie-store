CREATE TABLE `district` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `code` varchar(6) NOT NULL,
  `updated` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `city_fk` FOREIGN KEY (`id`) REFERENCES `city` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='district data table';
