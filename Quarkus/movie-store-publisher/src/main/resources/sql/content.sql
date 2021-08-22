CREATE TABLE `CONTENT` (
  `id` bigint(20) NOT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
