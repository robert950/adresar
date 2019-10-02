drop table if exists data1;
drop table if exists contact;
drop table if exists address;
drop table if exists country;
drop table if exists city;
drop table if exists sex;

CREATE TABLE data1 (
	id BIGINT(11) IDENTITY PRIMARY KEY,
	contactFirstName VARCHAR(50),
	contactLastName VARCHAR(50),
	contactPhone VARCHAR(50),
	contactEmail VARCHAR(50),
	addressStreetName VARCHAR(50),
	addressStreetNO VARCHAR(50),
	countryName VARCHAR(50),
	cityName VARCHAR(50),
	cityZip VARCHAR(50),
	sexName VARCHAR(50)
);

CREATE TABLE contact (
	id BIGINT(11) IDENTITY PRIMARY KEY,
	firstName VARCHAR(20),
	lastName VARCHAR(50),
	phone VARCHAR(13),
	email VARCHAR(50),
	sexId BIGINT (10),
	addressId BIGINT (10)
);

CREATE TABLE address (
	id BIGINT(10) IDENTITY PRIMARY KEY,
	street VARCHAR(50),
	streetNo VARCHAR(5),
	cityId BIGINT 
);

CREATE TABLE country (
	id BIGINT(10) IDENTITY PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE city (
	id BIGINT(10) IDENTITY PRIMARY KEY,
	name VARCHAR(50),
	zipCode VARCHAR(50),
	countryId BIGINT(10)
);
CREATE TABLE sex (
	id BIGINT(10) IDENTITY PRIMARY KEY,
	name VARCHAR(50)
);


