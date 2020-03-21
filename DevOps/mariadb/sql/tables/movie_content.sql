CREATE TABLE moviestoredb.movie_content (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	content TEXT NOT NULL,
	updated TIMESTAMP NOT NULL,
	CONSTRAINT movie_content_PK PRIMARY KEY (id),
	CONSTRAINT movie_content_FK FOREIGN KEY (id) REFERENCES moviestoredb.movie(id) ON DELETE RESTRICT ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='movie_content data table';
