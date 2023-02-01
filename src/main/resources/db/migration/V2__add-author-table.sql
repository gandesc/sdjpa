CREATE TABLE author (
    id BIGINT NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE author_seq(
    next_val BIGINT
) ENGINE = InnoDB;

INSERT INTO author_seq VALUES (1);