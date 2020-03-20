CREATE TABLE moviestoredb.city (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	country BIGINT UNSIGNED NOT NULL,
	updated TIMESTAMP NOT NULL,
	CONSTRAINT city_PK PRIMARY KEY (id),
	CONSTRAINT city_FK FOREIGN KEY (id) REFERENCES moviestoredb.country(id) ON DELETE RESTRICT ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='city data table';
