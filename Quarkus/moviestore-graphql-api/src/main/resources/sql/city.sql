CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `country_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8mipuflnidcgu8cvvk595f9ot` (`country_fk`),
  CONSTRAINT `FK8mipuflnidcgu8cvvk595f9ot` FOREIGN KEY (`country_fk`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
