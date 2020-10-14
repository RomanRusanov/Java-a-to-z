--Create table Country
create table country(
    country_id serial primary key,
	title varchar(100)
);
--Create table Participants
create table participants(
    participants_id serial primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    rating int not null,
    country_id int references country(country_id)
);

