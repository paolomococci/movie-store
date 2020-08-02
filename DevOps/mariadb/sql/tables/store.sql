DROP TABLE IF EXISTS moviestoredb.store;
CREATE TABLE moviestoredb.store (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `address_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `store_name_IDX` (`name`) USING BTREE,
  KEY `store_to_address_fk` (`address_fk`),
  CONSTRAINT `store_to_address_fk` FOREIGN KEY (`address_fk`) REFERENCES `address` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='store data table';
