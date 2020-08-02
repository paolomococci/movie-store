DROP TABLE IF EXISTS moviestoredb.country;
CREATE TABLE moviestoredb.country (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `iso3166_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `country_to_iso3166_fk` (`iso3166_id`),
  CONSTRAINT `country_to_iso3166_fk` FOREIGN KEY (`iso3166_id`) REFERENCES `iso3166` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='country data table';
