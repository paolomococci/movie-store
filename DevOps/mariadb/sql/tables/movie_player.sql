CREATE TABLE `movie_player` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  KEY `movie_player_FK_1` (`id`),
  CONSTRAINT `movie_player_FK` FOREIGN KEY (`id`) REFERENCES `movie` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `movie_player_FK_1` FOREIGN KEY (`id`) REFERENCES `player` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='movie_player data table';
