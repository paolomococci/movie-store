CREATE TABLE moviestoredb.movie (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	title varchar(100) NOT NULL,
	subtitle varchar(100) NULL,
	description TEXT NOT NULL,
	comeout DATE NOT NULL,
	duration TIME NOT NULL,
	cost DOUBLE NOT NULL,
	rent DOUBLE NOT NULL,
	rating DOUBLE NULL,
	updated TIMESTAMP NOT NULL,
	CONSTRAINT movie_PK PRIMARY KEY (id),
	CONSTRAINT movie_FK FOREIGN KEY (id) REFERENCES moviestoredb.category(id) ON DELETE RESTRICT ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='movie data table';
CREATE FULLTEXT INDEX movie_title_IDX ON moviestoredb.movie (title,subtitle,description);
