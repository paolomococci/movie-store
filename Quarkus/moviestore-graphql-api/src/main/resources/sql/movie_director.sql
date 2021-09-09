CREATE TABLE `movie_director` (
  `movie_id` bigint(20) NOT NULL,
  `director_id` bigint(20) NOT NULL,
  KEY `FKgn1rkfh7ioiax467kc9dcrcrr` (`director_id`),
  KEY `FKbay4b2v2db4yfaww2oocpld9m` (`movie_id`),
  CONSTRAINT `FKbay4b2v2db4yfaww2oocpld9m` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`),
  CONSTRAINT `FKgn1rkfh7ioiax467kc9dcrcrr` FOREIGN KEY (`director_id`) REFERENCES `director` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
