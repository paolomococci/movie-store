CREATE TABLE `payment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `amount` decimal(10,0) NOT NULL,
  `payed` date NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  CONSTRAINT `payment_to_customer_FK` FOREIGN KEY (`id`) REFERENCES `customer` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `payment_to_rental_FK` FOREIGN KEY (`id`) REFERENCES `rental` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `payment_to_staff_FK` FOREIGN KEY (`id`) REFERENCES `staff` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='payment data table';
