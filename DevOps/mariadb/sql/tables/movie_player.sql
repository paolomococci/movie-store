CREATE TABLE `movie_player` (
  `movie_id` bigint(20) unsigned NOT NULL,
  `player_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`movie_id`,`player_id`),
  KEY `movie_player_to_player_fk` (`player_id`),
  CONSTRAINT `movie_player_to_movie_fk` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`),
  CONSTRAINT `movie_player_to_player_fk` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
