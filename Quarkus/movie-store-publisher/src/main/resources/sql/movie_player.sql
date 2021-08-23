CREATE TABLE moviestore_db.movie_player (
  `movie_id` bigint(20) NOT NULL,
  `player_id` bigint(20) NOT NULL,
  KEY `FKpiw9mlbjj8i7hwuyokuumnqsv` (`player_id`),
  KEY `FKhhyh6b04umdfgow640dsqttpl` (`movie_id`),
  CONSTRAINT `FKhhyh6b04umdfgow640dsqttpl` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`),
  CONSTRAINT `FKpiw9mlbjj8i7hwuyokuumnqsv` FOREIGN KEY (`player_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
