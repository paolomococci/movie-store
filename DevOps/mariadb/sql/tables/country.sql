CREATE TABLE moviestoredb.country (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	code varchar(3) NOT NULL,
	CONSTRAINT country_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

ALTER TABLE moviestoredb.country ADD CONSTRAINT country_FK FOREIGN KEY (id) REFERENCES moviestoredb.iso3166(id) ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE moviestoredb.country ADD updated TIMESTAMP NOT NULL;
