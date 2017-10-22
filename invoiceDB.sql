drop table if exists Albums;

create table Country(
CountryID int not null auto_increment,
primary key (CountryID),
CountryName varchar (250)
);

create table State(
StateID int not null auto_increment,
primary key (StateID),
StateName varchar (50)
);

create table CityZip(
CityZipID int not null auto_increment,
primary key (CityZipID),
CityName varchar (50),
ZipCode varchar (15)
);

create table Address(
AddressID int not null auto_increment,
primary key (AddressID),

CityZipID INT NULL,
foreign key (CityZipID) references CityZipID(CityZipID),

StateID INT NULL,
foreign key (StateID) references StateID(StateID),

Country INT NULL,
foreign key (Country) references Country(Country)
);

