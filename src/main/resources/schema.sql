create table if not exists country(countryId INT PRIMARY KEY AUTO_INCREMENT,
countryName VARCHAR(255),
currency VARCHAR(255),
population INT,
latitude VARCHAR(255),
longitude VARCHAR(255));

CREATE TABLE if not exists CITY(cityId INT PRIMARY KEY AUTO_INCREMENT,
cityName VARCHAR(255),
population INT,
latitude VARCHAR(255),
longitude VARCHAR(255),
countryId INT, FOREIGN KEY(countryId) REFERENCES country(countryId));