CREATE TABLE moviestoredb.store (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	name varchar(50) NOT NULL,
	updated TIMESTAMP NOT NULL,
	CONSTRAINT store_PK PRIMARY KEY (id),
	CONSTRAINT store_FK FOREIGN KEY (id) REFERENCES moviestoredb.address(id) ON DELETE RESTRICT ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='store data table';
CREATE INDEX store_name_IDX USING BTREE ON moviestoredb.store (name);
