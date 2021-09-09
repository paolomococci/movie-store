CREATE TABLE moviestore_db.movie_producer (
  `movie_id` bigint(20) NOT NULL,
  `producer_id` bigint(20) NOT NULL,
  KEY `FK36mw05cutwof3spqh2i1wdrku` (`producer_id`),
  KEY `FKe04q3b68c56s40c2nqdrw8hcx` (`movie_id`),
  CONSTRAINT `FK36mw05cutwof3spqh2i1wdrku` FOREIGN KEY (`producer_id`) REFERENCES `producer` (`id`),
  CONSTRAINT `FKe04q3b68c56s40c2nqdrw8hcx` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
