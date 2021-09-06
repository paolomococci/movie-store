CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `payed` date DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `customer_fk` bigint(20) DEFAULT NULL,
  `staff_fk` bigint(20) DEFAULT NULL,
  `rental_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5j2uj2gqovn84ffi1nx3q29io` (`customer_fk`),
  KEY `FK5gqbi37x0oolfhk5naiutpf68` (`staff_fk`),
  KEY `FKjm17ljmts2eavkoxqv1384mvx` (`rental_fk`),
  CONSTRAINT `FK5gqbi37x0oolfhk5naiutpf68` FOREIGN KEY (`staff_fk`) REFERENCES `staff` (`id`),
  CONSTRAINT `FK5j2uj2gqovn84ffi1nx3q29io` FOREIGN KEY (`customer_fk`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKjm17ljmts2eavkoxqv1384mvx` FOREIGN KEY (`rental_fk`) REFERENCES `rental` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
