Create schema mayfield;
use  mayfield;

CREATE TABLE users(
    id int auto_increment not null,
    fullname varchar(50) not null,
    email varchar(50) not null,
    password char(120) not null,
    primary key(id)
);

