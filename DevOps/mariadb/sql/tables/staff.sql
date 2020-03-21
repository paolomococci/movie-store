CREATE TABLE moviestoredb.staff (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	nickname varchar(100) NULL,
	surname varchar(100) NOT NULL,
	picture BLOB NULL,
	phone varchar(20) NULL,
	mobile varchar(20) NOT NULL,
	email varchar(50) NOT NULL,
	username varchar(100) NOT NULL,
	password varchar(20) NOT NULL,
	active BOOL DEFAULT true NOT NULL,
	updated TIMESTAMP NOT NULL,
	CONSTRAINT staff_PK PRIMARY KEY (id),
	CONSTRAINT staff_FK FOREIGN KEY (id) REFERENCES moviestoredb.address(id) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT staff_FK_1 FOREIGN KEY (id) REFERENCES moviestoredb.store(id) ON DELETE RESTRICT ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='staff data table';
