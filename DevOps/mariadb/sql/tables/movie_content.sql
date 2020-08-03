DROP TABLE IF EXISTS moviestoredb.movie_content;
CREATE TABLE moviestoredb.movie_content (
  `movie_id` bigint(20) unsigned NOT NULL,
  `content_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`movie_id`,`content_id`),
  KEY `movie_content_to_content_fk` (`content_id`),
  CONSTRAINT `movie_content_to_content_fk` FOREIGN KEY (`content_id`) REFERENCES `content` (`id`),
  CONSTRAINT `movie_content_to_movie_fk` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
