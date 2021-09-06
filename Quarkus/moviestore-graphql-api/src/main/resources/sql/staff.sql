CREATE TABLE `staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `address_fk` bigint(20) DEFAULT NULL,
  `store_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf5wtla3qxsp9cy2732od0i46g` (`address_fk`),
  KEY `FK1iva18n4rivfkcqm4x5fuixkq` (`store_fk`),
  CONSTRAINT `FK1iva18n4rivfkcqm4x5fuixkq` FOREIGN KEY (`store_fk`) REFERENCES `store` (`id`),
  CONSTRAINT `FKf5wtla3qxsp9cy2732od0i46g` FOREIGN KEY (`address_fk`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
