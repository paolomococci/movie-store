CREATE TABLE `address` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `civic` varchar(10) NOT NULL,
  `district` varchar(100) NOT NULL,
  `city` bigint(20) unsigned NOT NULL,
  `code` varchar(10) NOT NULL,
  `country` bigint(20) unsigned NOT NULL,
  `phone` varchar(25) DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `address_city_IDX` (`city`) USING BTREE,
  CONSTRAINT `address_FK` FOREIGN KEY (`id`) REFERENCES `city` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='address data table';
