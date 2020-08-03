DROP TABLE IF EXISTS moviestoredb.payment;
CREATE TABLE moviestoredb.payment (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `payed` date NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `customer_fk` bigint(20) unsigned DEFAULT NULL,
  `staff_fk` bigint(20) unsigned DEFAULT NULL,
  `rental_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `payment_to_customer_fk` (`customer_fk`),
  KEY `payment_to_rental_fk` (`rental_fk`),
  KEY `payment_to_staff_fk` (`staff_fk`),
  CONSTRAINT `payment_to_customer_fk` FOREIGN KEY (`customer_fk`) REFERENCES `customer` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `payment_to_rental_fk` FOREIGN KEY (`rental_fk`) REFERENCES `rental` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `payment_to_staff_fk` FOREIGN KEY (`staff_fk`) REFERENCES `staff` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='payment data table';
