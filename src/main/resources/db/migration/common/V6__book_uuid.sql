create table book_uuid
(
    id        VARBINARY(16) not null,
    isbn      varchar(255),
    publisher varchar(255),
    title     varchar(255),
    primary key (id)
) engine = InnoDB;