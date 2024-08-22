
create table caregivers(

    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    document varchar(10) not null,
    street varchar(100) not null,
    city varchar(100) not null,
    district varchar(100) not null,

    primary key(id)

);