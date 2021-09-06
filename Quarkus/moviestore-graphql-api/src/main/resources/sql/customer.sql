CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `address_fk` bigint(20) DEFAULT NULL,
  `store_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK28dg7c4ivpo97omo2dp3hfckj` (`address_fk`),
  KEY `FK3j55ur00kg6vqo5y3vv746w0n` (`store_fk`),
  CONSTRAINT `FK28dg7c4ivpo97omo2dp3hfckj` FOREIGN KEY (`address_fk`) REFERENCES `address` (`id`),
  CONSTRAINT `FK3j55ur00kg6vqo5y3vv746w0n` FOREIGN KEY (`store_fk`) REFERENCES `store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
