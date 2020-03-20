CREATE TABLE moviestoredb.movie_player (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	updated TIMESTAMP NOT NULL,
	CONSTRAINT movie_player_FK FOREIGN KEY (id) REFERENCES moviestoredb.movie(id) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT movie_player_FK_1 FOREIGN KEY (id) REFERENCES moviestoredb.player(id) ON DELETE RESTRICT ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='movie_player data table';
