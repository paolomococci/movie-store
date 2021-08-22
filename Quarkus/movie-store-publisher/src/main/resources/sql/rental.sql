CREATE TABLE `RENTAL` (
  `id` bigint(20) NOT NULL,
  `back` date DEFAULT NULL,
  `rent` date DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
