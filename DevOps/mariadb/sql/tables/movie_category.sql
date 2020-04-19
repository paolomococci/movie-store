CREATE TABLE `movie_category` (
  `movie_id` bigint(20) unsigned NOT NULL,
  `category_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`movie_id`,`category_id`),
  KEY `movie_category_to_category_fk` (`category_id`),
  CONSTRAINT `movie_category_to_category_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `movie_category_to_movie_fk` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
