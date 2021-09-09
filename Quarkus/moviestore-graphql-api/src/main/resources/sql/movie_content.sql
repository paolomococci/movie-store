CREATE TABLE `movie_content` (
  `movie_id` bigint(20) NOT NULL,
  `content_id` bigint(20) NOT NULL,
  KEY `FKr2bt7doqeihqo2jiieyr6xo4p` (`content_id`),
  KEY `FKsxi6kjwd6w964wk4urng1ptsf` (`movie_id`),
  CONSTRAINT `FKr2bt7doqeihqo2jiieyr6xo4p` FOREIGN KEY (`content_id`) REFERENCES `content` (`id`),
  CONSTRAINT `FKsxi6kjwd6w964wk4urng1ptsf` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
