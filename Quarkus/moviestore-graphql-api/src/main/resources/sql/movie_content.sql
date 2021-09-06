CREATE TABLE `movie_content` (
  `movie_id` bigint(20) NOT NULL,
  `content_id` bigint(20) NOT NULL,
  KEY `FK1bm8a757jlnq4qu4jqeouy6ap` (`content_id`),
  KEY `FKsxi6kjwd6w964wk4urng1ptsf` (`movie_id`),
  CONSTRAINT `FK1bm8a757jlnq4qu4jqeouy6ap` FOREIGN KEY (`content_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKsxi6kjwd6w964wk4urng1ptsf` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
