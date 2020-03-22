CREATE TABLE `customer` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `nickname` varchar(100) DEFAULT NULL,
  `surname` varchar(100) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `created` date NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT 1,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  CONSTRAINT `customer_FK` FOREIGN KEY (`id`) REFERENCES `address` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `customer_FK_1` FOREIGN KEY (`id`) REFERENCES `store` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='customer data table';
