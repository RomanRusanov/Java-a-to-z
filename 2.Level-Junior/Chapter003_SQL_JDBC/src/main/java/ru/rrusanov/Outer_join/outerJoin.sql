create database cars;
\c cars;

create table body
(
  id   serial primary key,
  name varchar(100),
  body_type varchar(100),
  color varchar(50),
  number_seat int,
  number_doors int
);

create table engine
(
  id   serial primary key,
  name varchar(100),
  en_type varchar(100),
  horse_power int
);

create table transmission
(
  id   serial primary key,
  name varchar(100),
  tr_type varchar(100),
  num_speed int
);

create table car
(
  car_id   serial primary key,
  name varchar(100),
  body_id int,
  engine_id int,
  transmission_id int,
  constraint car_body_id_fk
    foreign key (body_id)
      references body(id),
  constraint car_engine_id_fk
    foreign key (engine_id)
      references engine(id),
  constraint car_transmission_if_fk
    foreign key (transmission_id)
      references transmission(id)
);

insert into body (name, body_type, color, number_seat, number_doors)
values ('B1', 'sedan', 'white', 4, 4),
       ('B2', 'coupe', 'red', 4, 2),
       ('B3', 'sport-cope', 'black', 2, 2),
       ('B4', 'hatchback', 'grey', 4, 5),
       ('B5', 'krosover', 'white', 4, 5)
;

insert into engine (name, en_type, horse_power)
values ('E1', 'gasoline', 150),
       ('E2', 'gasoline', 70),
       ('E3', 'gasoline', 350),
       ('E4', 'diesel', 140),
       ('E5', 'diesel', 120),
       ('E6', 'diesel', 230),
       ('E7', 'diesel', 180),
       ('E8', 'electric', 150),
       ('E9', 'electric', 190),
       ('E10', 'electric', 50)
;

insert into transmission (name, tr_type, num_speed)
values ('T1', 'Robot', 9),
       ('T2', 'GidroAvtomat', 4),
       ('T3', 'Variator', 1),
       ('T4', 'Robot', 6),
       ('T5', 'GidroAvtomat', 6),
       ('T6', 'Mechanical', 5)
;

insert into car (name, body_id, engine_id, transmission_id)
values ('Lada Granta', 1, 1, 2),
       ('Audi A4', 4, 4, 3),
       ('Porsche Boxter', 3, 3, 6),
       ('Volkswagen Polo', 1, 2, 5),
       ('Volkswagen Tiguan', 5, 4, 1),
       ('Renault Kaptur', 5, 5, 3)
;
--Query
select c.name, b.body_type as "body", e.en_type as "engine", t.tr_type as "transmission" from car as c
      left join body as b on c.body_id = b.id
      left join engine as e on c.engine_id = e.id
      left join transmission as t on c.transmission_id = t.id
      order by c.name;

select b.* from body as b left join car as c on b.id = c.body_id where c.body_id is null;
select e.* from engine as e left join car as c on e.id = c.engine_id where c.body_id is null;
select t.* from transmission as t left join car as c on t.id = c.transmission_id where c.transmission_id is null;