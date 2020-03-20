CREATE TABLE moviestoredb.player (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	nickname varchar(100) NOT NULL,
	surname varchar(100) NOT NULL,
	uptodate TIMESTAMP NOT NULL,
	CONSTRAINT player_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='players data table';

ALTER TABLE moviestoredb.player CHANGE uptodate updated timestamp DEFAULT current_timestamp() on update current_timestamp() NOT NULL;
