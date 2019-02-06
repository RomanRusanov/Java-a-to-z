create database products;
\c products;

create table type(id serial primary key, name varchar(200));

create table product(id serial primary key, 
					name varchar(200),
					type_id int not null,
					expired_date date, 
					price money,
					constraint product_type_id_fk
					foreign key (type_id)
					references type (id)
);

insert into type (name)
values ('Молоко'), ('Сыр'), ('Хлеб'), ('Мясо'), ('Вода');
insert into product (name, type_id, expired_date, price)
values
('Молоко Домик в деревне 3.2 жир.', 1, '2018-12-31', 45.12),
('Молоко Домик в деревне 3.2 жир.', 1, '2019-01-01', 45.12),
('Сыр гауда 45%', 2, '2019-03-20', 520.15),
('Сыр Российский 50%', 2, '2019-02-10', 42.10),
('Хлеб Батон нарезной', 3, '2019-02-15', 40.05),
('Хлеб Дарницкий', 3, '2019-02-10', 37.35),
('Свинина вырезка', 4, '2019-02-25', 350.67),
('Говядина на кости', 4, '2019-02-22', 373.13),
('Святой источник 0,5л', 5, '2019-12-25', 15.12),
('Бон Аква 0,5л', 5, '2019-12-25', 35.45),
('Мороженое Максибон', 1, '2019-05-13', 95.12),
('Мороженое Сникерс', 1, '2019-06-10', 120.12);

--1
select p.name from product as p inner join type as t on t.id = p.type_id and p.type_id = 2;
--2
select * from product as p where p.name like '%Мороженое%';
--3
select * from product as p where p.expired_date < '2019-01-29';
--4
select p.name, max(p.price) from product as p group by p.name order by max(p.price) desc limit 1;
--5
select count(*) as "product_type = 1" from product as p where p.type_id = 1;
--6
select * from product as p where p.type_id = 1 or p.type_id = 2;
--7
select t.name, count(p.name) as "items left" from product as p inner join type as t on p.type_id = t.id group by t.name having count(p.name) < 10;
--8
select p.name, t.name from product as p inner join type as t on p.type_id = t.id;