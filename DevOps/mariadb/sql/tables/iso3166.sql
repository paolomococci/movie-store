CREATE TABLE `iso3166` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `code` int(11) NOT NULL,
  `signature` varchar(3) NOT NULL,
  `updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  FULLTEXT KEY `iso3166_signature_IDX` (`signature`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
