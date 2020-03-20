CREATE TABLE moviestoredb.`language` (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	name varchar(30) NOT NULL,
	updated TIMESTAMP NOT NULL,
	CONSTRAINT language_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='language data table';
