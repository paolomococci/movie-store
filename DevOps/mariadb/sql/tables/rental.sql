CREATE TABLE `rental` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `rent` date NOT NULL,
  `back` date NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  CONSTRAINT `rental_FK` FOREIGN KEY (`id`) REFERENCES `staff` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `rental_FK_1` FOREIGN KEY (`id`) REFERENCES `inventory` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `rental_FK_2` FOREIGN KEY (`id`) REFERENCES `customer` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='rental data table';
