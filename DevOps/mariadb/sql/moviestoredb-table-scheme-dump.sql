--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `civic` varchar(10) NOT NULL,
  `phone` varchar(25) DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `type` varchar(255) DEFAULT NULL,
  `district_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `address_to_district_fk` (`district_fk`),
  CONSTRAINT `address_to_district_fk` FOREIGN KEY (`district_fk`) REFERENCES `district` (`id`) ON DELETE SET NULL
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
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `country_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `city_to_country_fk` (`country_fk`),
  CONSTRAINT `city_to_country_fk` FOREIGN KEY (`country_fk`) REFERENCES `country` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='city data table';

--
-- Table structure for table `content`
--

DROP TABLE IF EXISTS `content`;
CREATE TABLE `content` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `subject` varchar(255) DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='content data table';

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `iso3166_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `country_to_iso3166_fk` (`iso3166_id`),
  CONSTRAINT `country_to_iso3166_fk` FOREIGN KEY (`iso3166_id`) REFERENCES `iso3166` (`id`) ON DELETE SET NULL
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
  `birthday` date NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT 1,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `address_fk` bigint(20) unsigned DEFAULT NULL,
  `store_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_to_address_fk` (`address_fk`),
  KEY `customer_to_store_fk` (`store_fk`),
  CONSTRAINT `customer_to_address_fk` FOREIGN KEY (`address_fk`) REFERENCES `address` (`id`) ON DELETE SET NULL,
  CONSTRAINT `customer_to_store_fk` FOREIGN KEY (`store_fk`) REFERENCES `store` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='customer data table';

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
CREATE TABLE `district` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `code` varchar(6) NOT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `city_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `district_to_city_fk` (`city_fk`),
  CONSTRAINT `district_to_city_fk` FOREIGN KEY (`city_fk`) REFERENCES `city` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='district data table';

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `store_fk` bigint(20) unsigned DEFAULT NULL,
  `movie_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `inventory_to_store_fk` (`store_fk`),
  KEY `inventory_to_movie_fk` (`movie_fk`),
  CONSTRAINT `inventory_to_movie_fk` FOREIGN KEY (`movie_fk`) REFERENCES `movie` (`id`) ON DELETE SET NULL,
  CONSTRAINT `inventory_to_store_fk` FOREIGN KEY (`store_fk`) REFERENCES `store` (`id`) ON DELETE SET NULL
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
  UNIQUE KEY `code_UN` (`code`),
  UNIQUE KEY `signature_UN` (`signature`),
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
  `desciption` varchar(255) NOT NULL,
  `language_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `movie_to_language_fk` (`language_fk`),
  FULLTEXT KEY `movie_title_IDX` (`title`,`subtitle`,`description`),
  CONSTRAINT `movie_to_language_fk` FOREIGN KEY (`language_fk`) REFERENCES `language` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='movie data table';

--
-- Table structure for table `movie_category`
--

DROP TABLE IF EXISTS `movie_category`;
CREATE TABLE `movie_category` (
  `movie_id` bigint(20) unsigned NOT NULL,
  `category_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`movie_id`,`category_id`),
  KEY `movie_category_to_category_fk` (`category_id`),
  CONSTRAINT `movie_category_to_category_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `movie_category_to_movie_fk` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `movie_content`
--

DROP TABLE IF EXISTS `movie_content`;
CREATE TABLE `movie_content` (
  `movie_id` bigint(20) unsigned NOT NULL,
  `content_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`movie_id`,`content_id`),
  KEY `movie_content_to_content_fk` (`content_id`),
  CONSTRAINT `movie_content_to_content_fk` FOREIGN KEY (`content_id`) REFERENCES `content` (`id`),
  CONSTRAINT `movie_content_to_movie_fk` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `movie_player`
--

DROP TABLE IF EXISTS `movie_player`;
CREATE TABLE `movie_player` (
  `movie_id` bigint(20) unsigned NOT NULL,
  `player_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`movie_id`,`player_id`),
  CONSTRAINT `movie_player_to_movie_fk` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`),
  CONSTRAINT `movie_player_to_player_fk` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `payed` date NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `customer_fk` bigint(20) unsigned DEFAULT NULL,
  `staff_fk` bigint(20) unsigned DEFAULT NULL,
  `rental_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `payment_to_customer_fk` (`customer_fk`),
  KEY `payment_to_rental_fk` (`rental_fk`),
  KEY `payment_to_staff_fk` (`staff_fk`),
  CONSTRAINT `payment_to_customer_fk` FOREIGN KEY (`customer_fk`) REFERENCES `customer` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `payment_to_rental_fk` FOREIGN KEY (`rental_fk`) REFERENCES `rental` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `payment_to_staff_fk` FOREIGN KEY (`staff_fk`) REFERENCES `staff` (`id`) ON UPDATE CASCADE
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
  `inventory_fk` bigint(20) unsigned DEFAULT NULL,
  `customer_fk` bigint(20) unsigned DEFAULT NULL,
  `staff_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rental_to_inventory_fk` (`inventory_fk`),
  KEY `rental_to_customer_fk` (`customer_fk`),
  KEY `rental_to_staff_fk` (`staff_fk`),
  CONSTRAINT `rental_to_customer_fk` FOREIGN KEY (`customer_fk`) REFERENCES `customer` (`id`) ON DELETE SET NULL,
  CONSTRAINT `rental_to_inventory_fk` FOREIGN KEY (`inventory_fk`) REFERENCES `inventory` (`id`) ON DELETE SET NULL,
  CONSTRAINT `rental_to_staff_fk` FOREIGN KEY (`staff_fk`) REFERENCES `staff` (`id`) ON DELETE SET NULL
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
  `address_fk` bigint(20) unsigned DEFAULT NULL,
  `store_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `staff_to_address_fk` (`address_fk`),
  KEY `staff_to_store_fk` (`store_fk`),
  CONSTRAINT `staff_to_address_fk` FOREIGN KEY (`address_fk`) REFERENCES `address` (`id`) ON DELETE SET NULL,
  CONSTRAINT `staff_to_store_fk` FOREIGN KEY (`store_fk`) REFERENCES `store` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='staff data table';

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `address_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `store_name_IDX` (`name`) USING BTREE,
  KEY `store_to_address_fk` (`address_fk`),
  CONSTRAINT `store_to_address_fk` FOREIGN KEY (`address_fk`) REFERENCES `address` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='store data table';
