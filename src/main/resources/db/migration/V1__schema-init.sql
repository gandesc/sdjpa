DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS book_seq;

CREATE TABLE book
(
    id        BIGINT NOT NULL,
    isbn      VARCHAR(255),
    publisher VARCHAR(255),
    title     VARCHAR(255),
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE book_seq
(
    next_val BIGINT
) ENGINE = InnoDB;

INSERT INTO book_seq VALUES (1);