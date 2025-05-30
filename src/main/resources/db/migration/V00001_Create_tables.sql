CREATE TABLE vk (
    id SERIAL PRIMARY KEY,
    name varchar(50) UNIQUE NOT NULL
);

CREATE TABLE ubisoft (
    id SERIAL PRIMARY KEY,
    name varchar(50) UNIQUE NOT NULL
);

CREATE TABLE egs (
    id SERIAL PRIMARY KEY,
    name varchar(50) UNIQUE NOT NULL
);

CREATE TABLE battle_net (
    id SERIAL PRIMARY KEY,
    name varchar(50) UNIQUE NOT NULL
);

CREATE TABLE steam (
    id SERIAL PRIMARY KEY,
    name varchar(50),
    manifest_id varchar(50) UNIQUE NOT NULL
);

CREATE TABLE guide (
    id SERIAL PRIMARY KEY,
    title varchar(100) UNIQUE NOT NULL ,
    link varchar(100) NOT NULL
);