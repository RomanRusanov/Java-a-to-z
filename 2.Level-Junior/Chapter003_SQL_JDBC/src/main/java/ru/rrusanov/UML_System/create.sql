--Create DB
create database tracker;
--Connect DB
\c tracker;
--Create table Rols
create table role(
									 role_id serial primary key,
									 title varchar(100)
);
--Create table Ruls
create table ruls(
									 ruls_id serial primary key,
									 title varchar(100)
);
--Create table Users
create table users(
										user_id bigserial primary key,
										last_name varchar(50) not null,
										first_name varchar(50) not null,
										midle_name varchar(50) not null,
										role_id int not null,
										constraint role_role_id_fk
											foreign key (role_id)
												references role (role_id)
);
--Create table RoleRuls
create table role_ruls(
												role_id int not null,
												constraint role_role_id_fk
													foreign key (role_id)
														references role (role_id),
												ruls_id int not null,
												constraint ruls_ruls_id_fk
													foreign key (ruls_id)
														references ruls (ruls_id),
												primary key (role_id, ruls_id)
);
--Create table State
create table state(
										state_id serial primary key,
										title varchar(50)
);
--Create table Category
create table category(
											 category_id serial primary key,
											 title varchar(50)
);
--Create table Item
create table item(
									 item_id bigserial primary key,
									 title varchar(100),
									 description text,
									 state_id int not null,
									 date_create timestamp,
									 constraint state_state_id_fk
										 foreign key (state_id)
											 references state (state_id),
									 category_id int not null,
									 constraint category_category_id_fk
										 foreign key (category_id)
											 references category (category_id)
);
--create table Users_Item
create table Users_Item(
												 user_id bigint not null,
												 constraint users_user_id
													 foreign key (user_id)
														 references users(user_id),
												 item_id bigint not null,
												 constraint item_item_id
													 foreign key (item_id)
														 references item(item_id),
												 primary key(user_id, item_id)
);
--Create table Attached
create table attached(
											 attached_id serial primary key,
											 item_id int not null,
											 path_to_file varchar(256) not null,
											 constraint item_item_id_fk
												 foreign key (item_id)
													 references item (item_id)
);
--Create table Comments
create table comments(
											 coment_id serial primary key,
											 item_id int not null,
											 comments text,
											 constraint item_item_id_fk
												 foreign key (item_id)
													 references item (item_id)
);

--Add entry in table
insert into state (title) values ('open'),('closed');
insert into category (title) values ('First'),('Second'),('Third');
insert into ruls (title) values ('full'),('half');
insert into role (title) values ('admin'),('user');
insert into role_ruls (role_id, ruls_id) values (1, 1),(2, 2);
insert into users (last_name, first_name, midle_name, role_id) 
values ('Иванов', 'Иван', 'Иванович', 1),('Петров', 'Петр', 'Петрович', 2);
insert into item (item_id, date_create, title, category_id, description, state_id)
values (1, '2004-10-19 10:23:54', 'заявка1', 1, 'Текст заявки 1', 1),(2, '2005-12-05 18:53:04', 'заявка2', 2, 'Текст заявки 2', 1);
insert into comments (item_id, comments) 
values (1, 'Коментарий 1 к заявке 1'),(2, 'Коментарий 1 к заявке 2');
insert into attached (item_id, path_to_file) 
values (1, '\attached\attached1item1.zip'),(2, '\attached\attached1item2.zip');
