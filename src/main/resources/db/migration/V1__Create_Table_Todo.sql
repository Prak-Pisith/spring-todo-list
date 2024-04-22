CREATE TABLE if not exists todos (
    id integer,
    description varchar(250),
    status boolean,
    created_at timestamp,
    updated_at timestamp,
    PRIMARY KEY (id)
);