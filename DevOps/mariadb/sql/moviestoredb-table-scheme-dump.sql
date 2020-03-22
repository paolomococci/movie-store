--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `civic` varchar(10) NOT NULL,
  `district` varchar(100) NOT NULL,
  `city` bigint(20) unsigned NOT NULL,
  `code` varchar(10) NOT NULL,
  `country` bigint(20) unsigned NOT NULL,
  `phone` varchar(25) DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `address_city_IDX` (`city`) USING BTREE,
  CONSTRAINT `address_FK` FOREIGN KEY (`id`) REFERENCES `city` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='address data table';

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='category data table';

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `country` bigint(20) unsigned NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  CONSTRAINT `city_FK` FOREIGN KEY (`id`) REFERENCES `country` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='city data table';

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `code` varchar(3) NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  CONSTRAINT `country_FK` FOREIGN KEY (`id`) REFERENCES `iso3166` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `nickname` varchar(100) DEFAULT NULL,
  `surname` varchar(100) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `created` date NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT 1,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  CONSTRAINT `customer_FK` FOREIGN KEY (`id`) REFERENCES `address` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `customer_FK_1` FOREIGN KEY (`id`) REFERENCES `store` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='customer data table';

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  CONSTRAINT `inventory_FK` FOREIGN KEY (`id`) REFERENCES `store` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `inventory_FK_1` FOREIGN KEY (`id`) REFERENCES `movie` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='inventory data table';

--
-- Table structure for table `iso3166`
--

DROP TABLE IF EXISTS `iso3166`;
CREATE TABLE `iso3166` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `code` int(11) NOT NULL,
  `signature` varchar(3) NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  FULLTEXT KEY `iso3166_signature_IDX` (`signature`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
CREATE TABLE `language` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='language data table';

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
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
  PRIMARY KEY (`id`),
  FULLTEXT KEY `movie_title_IDX` (`title`,`subtitle`,`description`),
  CONSTRAINT `movie_FK` FOREIGN KEY (`id`) REFERENCES `category` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='movie data table';

--
-- Table structure for table `movie_category`
--

DROP TABLE IF EXISTS `movie_category`;
CREATE TABLE `movie_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  CONSTRAINT `movie_category_FK` FOREIGN KEY (`id`) REFERENCES `movie` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `movie_category_FK_1` FOREIGN KEY (`id`) REFERENCES `category` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='movie_category data table';

--
-- Table structure for table `movie_content`
--

DROP TABLE IF EXISTS `movie_content`;
CREATE TABLE `movie_content` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  CONSTRAINT `movie_content_FK` FOREIGN KEY (`id`) REFERENCES `movie` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='movie content data table';

--
-- Table structure for table `movie_player`
--

DROP TABLE IF EXISTS `movie_player`;
CREATE TABLE `movie_player` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  KEY `movie_player_FK_1` (`id`),
  CONSTRAINT `movie_player_FK` FOREIGN KEY (`id`) REFERENCES `movie` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `movie_player_FK_1` FOREIGN KEY (`id`) REFERENCES `player` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='movie_player data table';

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `amount` decimal(10,0) NOT NULL,
  `payed` date NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  CONSTRAINT `payment_FK` FOREIGN KEY (`id`) REFERENCES `rental` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `payment_FK_1` FOREIGN KEY (`id`) REFERENCES `customer` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `payment_FK_2` FOREIGN KEY (`id`) REFERENCES `staff` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='payment data table';

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `nickname` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='players data table';

--
-- Table structure for table `rental`
--

DROP TABLE IF EXISTS `rental`;
CREATE TABLE `rental` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `rent` date NOT NULL,
  `back` date NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  CONSTRAINT `rental_FK` FOREIGN KEY (`id`) REFERENCES `staff` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `rental_FK_1` FOREIGN KEY (`id`) REFERENCES `inventory` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `rental_FK_2` FOREIGN KEY (`id`) REFERENCES `customer` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='rental data table';

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `nickname` varchar(100) DEFAULT NULL,
  `surname` varchar(100) NOT NULL,
  `picture` blob DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(20) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT 1,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  CONSTRAINT `staff_FK` FOREIGN KEY (`id`) REFERENCES `address` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `staff_FK_1` FOREIGN KEY (`id`) REFERENCES `store` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='staff data table';

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `store_name_IDX` (`name`) USING BTREE,
  CONSTRAINT `store_FK` FOREIGN KEY (`id`) REFERENCES `address` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='store data table';
