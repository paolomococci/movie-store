CREATE TABLE moviestoredb.address (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	civic varchar(10) NOT NULL,
	district varchar(100) NOT NULL,
	city BIGINT UNSIGNED NOT NULL,
	code varchar(10) NOT NULL,
	country BIGINT UNSIGNED NOT NULL,
	phone varchar(25) NULL,
	updated TIMESTAMP NOT NULL,
	CONSTRAINT address_PK PRIMARY KEY (id),
	CONSTRAINT address_FK FOREIGN KEY (id) REFERENCES moviestoredb.city(id) ON DELETE RESTRICT ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='address data table';
CREATE INDEX address_city_IDX USING BTREE ON moviestoredb.address (city);
