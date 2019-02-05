create database cars;
\c cars;

create table car
(
  id   serial primary key,
  name varchar(200)
);

create table body
(
  id   serial primary key,
  name varchar(200),
  body_type varchar(100),
  car_id int not null,
  constraint body_car_id_fk
  foreign key (car_id)
  references car(id)
);

create table engine
(
  id   serial primary key,
  name varchar(200),
  car_id int not null,
  constraint engine_car_id_fk
  foreign key (car_id)
  references car(id)
);

create table transmission
(
  id   serial primary key,
  name varchar(200),
  car_id int not null,
  constraint transmission_car_id_fk
  foreign key (car_id)
  references car(id)
);

insert into body ()
values (
       );

insert into engine ()
values (
       );
insert into transmission ()
values (
       );

insert into car ()
values (
       );
