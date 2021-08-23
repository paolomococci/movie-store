CREATE TABLE moviestore_db.store (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `address_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9iciaukn8x9vpvqpfvwfde2fu` (`address_fk`),
  CONSTRAINT `FK9iciaukn8x9vpvqpfvwfde2fu` FOREIGN KEY (`address_fk`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
