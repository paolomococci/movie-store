CREATE TABLE `rental` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `rent` date NOT NULL,
  `back` date NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  CONSTRAINT `rental_customer_fk` FOREIGN KEY (`id`) REFERENCES `customer` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `rental_inventory_fk` FOREIGN KEY (`id`) REFERENCES `inventory` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `rental_staff_fk` FOREIGN KEY (`id`) REFERENCES `staff` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='rental data table';
