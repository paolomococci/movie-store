CREATE TABLE moviestore_db.country (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `iso3166_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4nwmqywexxigox0ml7vnbalfk` (`iso3166_id`),
  CONSTRAINT `FK4nwmqywexxigox0ml7vnbalfk` FOREIGN KEY (`iso3166_id`) REFERENCES `iso3166` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
