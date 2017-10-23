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
foreign key (CityZipID) references CityZip(CityZipID),
StateID INT NULL,
foreign key (StateID) references State(StateID),
CountryID INT NULL,
foreign key (CountryID) references Country(CountryID)
);

create table Persons(
PersonID int not null auto_increment,
primary key (PersonID),
PersonCode varchar (10),
FirstName varchar (50),
LastName varchar (50),
AddressID INT NULL,
foreign key (AddressID) references Address(AddressID)
);

create table Email(
EmailID int not null auto_increment,
primary key (EmailID),
Email varchar (250),
PersonID INT NULL,
foreign key (PersonID) references Persons(PersonID)
);

create table Customers(
CustomerID int not null auto_increment,
primary key (CustomerID),
CustomerCode varchar (10),
CustomerType varchar (1),
ContactPersonID INT NULL,
foreign key (ContactPersonID) references Persons(PersonID),
CompanyName varchar (50),
AddressID INT NULL,
foreign key (AddressID) references Address(AddressID)
);

create table CustomerPersons(
CustomerPersonsID int not null auto_increment,
primary key (CustomerPersonsID),
CustomerID INT NULL,
foreign key (CustomerID) references Customers(CustomerID),
PersonID INT NULL,
foreign key (PersonID) references Persons(PersonID)
);

#---------------------------
#Products UNDER CONSTRUCTION
#---------------------------

create table ProductOrder(
ProductOrderID int not null auto_increment,
primary key (ProductOrderID),
ProductCode varchar (10),

foreign key (CustomerID) references Customers(CustomerID),
ProductCode varchar (1)
);

create table MovieTickets(
MovieTicketsID int not null auto_increment,
primary key (MovieTicketsID),
MovieCode varchar (10),
DateTime datetime,
MovieTitle varchar (50),
AddressID INT NULL,
foreign key (AddressID) references Address(AddressID),
Screen varchar (2),
Cost 
);

create table ParkingPass(
ParkingPassID int not null auto_increment,
primary key (ParkingPassID),
ParkingPassCode varchar (10),
DateTime datetime,
MovieTitle varchar (50),
AddressID INT NULL,
foreign key (AddressID) references Address(AddressID)
);
