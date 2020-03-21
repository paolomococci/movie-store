CREATE TABLE moviestoredb.inventory (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	updated TIMESTAMP NOT NULL,
	CONSTRAINT inventory_PK PRIMARY KEY (id),
	CONSTRAINT inventory_FK FOREIGN KEY (id) REFERENCES moviestoredb.store(id) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT inventory_FK_1 FOREIGN KEY (id) REFERENCES moviestoredb.movie(id) ON DELETE RESTRICT ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='inventory data table';
