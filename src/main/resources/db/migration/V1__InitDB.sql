create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to eddytep;

create table usr
(
    id          bigint not null
        primary key,
    birthday    timestamp,
    email       varchar(255),
    first_name  varchar(255),
    last_name   varchar(255),
    middle_name varchar(255),
    password    varchar(255),
    username    varchar(255)
);

alter table usr
    owner to eddytep;

create table user_role
(
    user_id bigint not null
        constraint fkfpm8swft53ulq2hl11yplpr5
            references usr,
    roles   varchar(255)
);

alter table user_role
    owner to eddytep;

