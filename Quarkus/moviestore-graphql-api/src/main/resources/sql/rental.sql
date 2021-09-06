CREATE TABLE `rental` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `back` date DEFAULT NULL,
  `rent` date DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `customer_fk` bigint(20) DEFAULT NULL,
  `inventory_fk` bigint(20) DEFAULT NULL,
  `staff_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiecnvd41i35nq7ibbnfttpkh2` (`customer_fk`),
  KEY `FK6xt8djnvyg3ecfbte3lam5jk0` (`inventory_fk`),
  KEY `FKb4d7xkoh25h5si9f0wocay8i8` (`staff_fk`),
  CONSTRAINT `FK6xt8djnvyg3ecfbte3lam5jk0` FOREIGN KEY (`inventory_fk`) REFERENCES `inventory` (`id`),
  CONSTRAINT `FKb4d7xkoh25h5si9f0wocay8i8` FOREIGN KEY (`staff_fk`) REFERENCES `staff` (`id`),
  CONSTRAINT `FKiecnvd41i35nq7ibbnfttpkh2` FOREIGN KEY (`customer_fk`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
