CREATE TABLE `movie_player` (
  `movie_id` bigint(20) NOT NULL,
  `player_id` bigint(20) NOT NULL,
  KEY `FKgf0p5d0ufjmd4laj8gca35t0f` (`player_id`),
  KEY `FKhhyh6b04umdfgow640dsqttpl` (`movie_id`),
  CONSTRAINT `FKgf0p5d0ufjmd4laj8gca35t0f` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`),
  CONSTRAINT `FKhhyh6b04umdfgow640dsqttpl` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
