CREATE TABLE moviestoredb.category (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	name varchar(50) NOT NULL,
	description varchar(200) NULL,
	updated TIMESTAMP NOT NULL,
	CONSTRAINT category_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='category data table';
