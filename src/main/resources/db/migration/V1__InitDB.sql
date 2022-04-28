create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to eddytep;

create table flyway_schema_history
(
    installed_rank integer                 not null
        constraint flyway_schema_history_pk
            primary key,
    version        varchar(50),
    description    varchar(200)            not null,
    type           varchar(20)             not null,
    script         varchar(1000)           not null,
    checksum       integer,
    installed_by   varchar(100)            not null,
    installed_on   timestamp default now() not null,
    execution_time integer                 not null,
    success        boolean                 not null
);

alter table flyway_schema_history
    owner to eddytep;

create index flyway_schema_history_s_idx
    on flyway_schema_history (success);

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

