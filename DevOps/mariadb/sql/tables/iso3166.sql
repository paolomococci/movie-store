CREATE TABLE moviestoredb.iso3166 (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	code INT NOT NULL,
	signature varchar(3) NOT NULL,
	CONSTRAINT iso3166_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;
CREATE FULLTEXT INDEX iso3166_signature_IDX ON moviestoredb.iso3166 (signature);

ALTER TABLE moviestoredb.iso3166 ADD updated TIMESTAMP NOT NULL;
