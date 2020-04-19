CREATE TABLE `rental` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `rent` date NOT NULL,
  `back` date NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `inventory_fk` bigint(20) unsigned DEFAULT NULL,
  `customer_fk` bigint(20) unsigned DEFAULT NULL,
  `staff_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rental_to_inventory_fk` (`inventory_fk`),
  KEY `rental_to_customer_fk` (`customer_fk`),
  KEY `rental_to_staff_fk` (`staff_fk`),
  CONSTRAINT `rental_to_customer_fk` FOREIGN KEY (`customer_fk`) REFERENCES `customer` (`id`) ON DELETE SET NULL,
  CONSTRAINT `rental_to_inventory_fk` FOREIGN KEY (`inventory_fk`) REFERENCES `inventory` (`id`) ON DELETE SET NULL,
  CONSTRAINT `rental_to_staff_fk` FOREIGN KEY (`staff_fk`) REFERENCES `staff` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='rental data table'
