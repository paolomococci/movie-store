DROP TABLE IF EXISTS moviestoredb.customer;
CREATE TABLE moviestoredb.customer (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `nickname` varchar(100) DEFAULT NULL,
  `surname` varchar(100) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `birthday` date NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT 1,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `address_fk` bigint(20) unsigned DEFAULT NULL,
  `store_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_to_address_fk` (`address_fk`),
  KEY `customer_to_store_fk` (`store_fk`),
  CONSTRAINT `customer_to_address_fk` FOREIGN KEY (`address_fk`) REFERENCES `address` (`id`) ON DELETE SET NULL,
  CONSTRAINT `customer_to_store_fk` FOREIGN KEY (`store_fk`) REFERENCES `store` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='customer data table';
