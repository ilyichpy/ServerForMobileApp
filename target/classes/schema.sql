drop schema if exists Users cascade;
create schema if not exists Users;

create table Users.Info (
                              Id SERIAL PRIMARY KEY,
                              Email varchar(50) NOT NULL,
                              Password varchar(50) NOT NULL,
                              VerificationCode varchar(5) NOT NULL
);