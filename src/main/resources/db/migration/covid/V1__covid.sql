create table zip_codes(
    id int AUTO_INCREMENT,
	zipcode int not null,
	city varchar (30) not null,
	city_part varchar (30),
	PRIMARY KEY (id));

create table Citizens(
    citizen_id bigint AUTO_INCREMENT,
    citizen_name varchar (200) not null,
    zip int not null,
    age bigint not null,
    email varchar (100),
    ssn bigint,
    number_of_vaccination bigint(20) UNSIGNED NULL DEFAULT '0',
    last_vaccination datetime,
    primary key (citizen_id));

create table Vaccinations(
    vaccination_id bigint AUTO_INCREMENT,
    citizen_id bigint not null,
    vaccination_date datetime not null,
    status varchar (10),
    note varchar (200),
    vaccination_type varchar (20),
    primary key (vaccination_id),
    foreign key (citizen_id) references Citizens(citizen_id));

LOAD DATA LOW_PRIORITY LOCAL INFILE 'C:/training/training-solutions/training-solutions/zipcode2021.csv'
REPLACE INTO TABLE `covid`.`zip_codes`
CHARACTER SET utf8
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\n'
IGNORE 1 LINES (`zipcode`, `city`, `city_part`);