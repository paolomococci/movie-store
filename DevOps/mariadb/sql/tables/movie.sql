CREATE TABLE `movie` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `subtitle` varchar(100) DEFAULT NULL,
  `description` text NOT NULL,
  `comeout` date NOT NULL,
  `duration` time NOT NULL,
  `cost` double NOT NULL,
  `rent` double NOT NULL,
  `rating` double DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `desciption` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  FULLTEXT KEY `movie_title_IDX` (`title`,`subtitle`,`description`),
  CONSTRAINT `movie_FK` FOREIGN KEY (`id`) REFERENCES `category` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='movie data table';
