CREATE TABLE `MOVIE` (
  `id` bigint(20) NOT NULL,
  `comeout` date DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `duration` time DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `rent` double DEFAULT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
