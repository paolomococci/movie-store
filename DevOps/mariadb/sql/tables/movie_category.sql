CREATE TABLE moviestoredb.movie_category (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	updated TIMESTAMP NOT NULL,
	CONSTRAINT movie_category_PK PRIMARY KEY (id),
	CONSTRAINT movie_category_FK FOREIGN KEY (id) REFERENCES moviestoredb.movie(id) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT movie_category_FK_1 FOREIGN KEY (id) REFERENCES moviestoredb.category(id) ON DELETE RESTRICT ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='movie_category data table';
