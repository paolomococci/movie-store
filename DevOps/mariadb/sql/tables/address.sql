DROP TABLE IF EXISTS moviestoredb.address;
CREATE TABLE moviestoredb.address (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `civic` varchar(10) NOT NULL,
  `phone` varchar(25) DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `type` varchar(255) DEFAULT NULL,
  `district_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `address_to_district_fk` (`district_fk`),
  CONSTRAINT `address_to_district_fk` FOREIGN KEY (`district_fk`) REFERENCES `district` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='address data table';
