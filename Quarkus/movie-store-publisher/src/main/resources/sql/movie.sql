CREATE TABLE moviestore_db.movie (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comeout` date DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `duration` time DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `rent` double DEFAULT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `language_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKec85gtqm6ya7kbd5e16fxr5lp` (`language_fk`),
  CONSTRAINT `FKec85gtqm6ya7kbd5e16fxr5lp` FOREIGN KEY (`language_fk`) REFERENCES `language` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
