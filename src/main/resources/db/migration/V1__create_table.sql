create table if not exists digit_intervals(
    id bigserial not null unique,
    left_border int,
    right_border int,
    primary key (id)
);

create table if not exists character_intervals(
    id bigserial not null unique,
    left_border varchar(1),
    right_border varchar(1),
    primary key (id)
);