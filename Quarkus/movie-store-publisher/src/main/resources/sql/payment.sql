CREATE TABLE `PAYMENT` (
  `id` bigint(20) NOT NULL,
  `amount` double DEFAULT NULL,
  `payed` date DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
