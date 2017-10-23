drop table if exists Albums;


create table CountryState(
CountryStateID int not null auto_increment,
primary key (CountryStateID),
StateName varchar (50),
CountryName varchar (250)
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
CountryStateID INT NULL,
foreign key (CountryStateID) references CountryState(CountryStateID)
);

create table Persons(
PersonID int not null auto_increment,
primary key (PersonID),
PersonCode varchar (4),
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
CustomerCode varchar (4),
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
ProductCode varchar (1),
MovieTicketsID varchar (4),
foreign key (MovieTicketsID) references MovieTickets(MovieTicketsID),
SeasonPassID varchar (4),
foreign key (SeasonPassID) references SeasonPass(SeasonPassID),
ParkingPassID varchar (4),
foreign key (ParkingPassID) references ParkingPass(ParkingPassID),
RefreshmentID varchar (4),
foreign key (RefreshmentID) references Refreshment(RefreshmentID),
Quantity int
);

create table MovieTickets(
MovieTicketsID int not null auto_increment,
primary key (MovieTicketsID),
MovieCode varchar (4),
DateTime datetime,
MovieTitle varchar (50),
AddressID INT NULL,
foreign key (AddressID) references Address(AddressID),
Screen varchar (2),
MovieTicketsCost decimal (6,2)
);

create table SeasonPass(
SeasonPassID int not null auto_increment,
primary key (SeasonPassID),
SeasonPassCode varchar (4),
SeasonPassName varchar (50),
StartDate date,
EndDate date,
AddressID INT NULL,
SeasonPassCost decimal (6,2)
);

create table ParkingPass(
ParkingPassID int not null auto_increment,
primary key (ParkingPassID),
ParkingPassCode varchar (4),
ParkingPassCost decimal (6,2)
);

create table Refreshment(
RefreshmentID int not null auto_increment,
primary key (RefreshmentID),
RefreshmentCode varchar (4),
RefreshmentName varchar (50),
RefreshmentCost decimal (6,2)
);

create table Invoice(
InvoiceID int not null auto_increment,
primary key (InvoiceID),
ProductOrderID varchar (4),
foreign key (ProductOrderID) references ProductOrder(ProductOrderID)
);

create table InvoicePersons(
InvoicePersonsID int not null auto_increment,
primary key (InvoicePersonsID),
InvoiceID varchar (4),
foreign key (InvoiceID) references Invoice(InvoiceID),
PersonID varchar (4),
foreign key (PersonID) references Person(PersonID)
);
