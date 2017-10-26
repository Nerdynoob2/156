drop table if exists ProductOrder;
drop table if exists Invoice;
drop table if exists Refreshment;
drop table if exists ParkingPass;
drop table if exists SeasonPass;
drop table if exists MovieTickets;
drop table if exists CustomerPersons;
drop table if exists Customers;
drop table if exists Email;
drop table if exists Persons;
drop table if exists Address;
drop table if exists CityZip;
drop table if exists CountryState;

drop table if exists CountryState;
create table CountryState(
CountryStateID int not null auto_increment,
primary key (CountryStateID),
StateName varchar (50),
CountryName varchar (50)
);

drop table if exists CityZip;
create table CityZip(
CityZipID int not null auto_increment,
primary key (CityZipID),
Street varchar (50),
CityName varchar (50),
ZipCode varchar (15)
);

drop table if exists Address;
create table Address(
AddressID int not null auto_increment,
primary key (AddressID),
CityZipID INT NULL,
foreign key (CityZipID) references CityZip(CityZipID),
CountryStateID INT NULL,
foreign key (CountryStateID) references CountryState(CountryStateID)
);

drop table if exists Persons;
create table Persons(
PersonID int not null auto_increment,
primary key (PersonID),
PersonCode varchar (10),
FirstName varchar (50),
LastName varchar (50),
AddressID INT NULL,
foreign key (AddressID) references Address(AddressID)
);

drop table if exists Email;
create table Email(
EmailID int not null auto_increment,
primary key (EmailID),
Email varchar (250),
PersonID INT NULL,
foreign key (PersonID) references Persons(PersonID)
);

drop table if exists Customers;
create table Customers(
CustomerID int not null auto_increment,
primary key (CustomerID),
CustomerCode varchar (10),
CustomerType varchar (20),
CompanyName varchar (50),
AddressID INT NULL,
foreign key (AddressID) references Address(AddressID)
);

drop table if exists CustomerPersons;
create table CustomerPersons(
CustomerPersonsID int not null auto_increment,
primary key (CustomerPersonsID),
CustomerID INT NULL,
foreign key (CustomerID) references Customers(CustomerID),
PersonID INT NULL,
foreign key (PersonID) references Persons(PersonID)
);





drop table if exists MovieTickets;
create table MovieTickets(
MovieTicketsID int not null auto_increment,
primary key (MovieTicketsID),
MovieCode varchar (10),
DayAndTime datetime,
MovieTitle varchar (250),
AddressID INT NULL,
foreign key (AddressID) references Address(AddressID),
Screen varchar (5),
MovieTicketsCost decimal (6,2)
);

drop table if exists SeasonPass;
create table SeasonPass(
SeasonPassID int not null auto_increment,
primary key (SeasonPassID),
SeasonPassCode varchar (10),
SeasonPassName varchar (250),
StartDate date,
EndDate date,
SeasonPassCost decimal (6,2)
);

drop table if exists ParkingPass;
create table ParkingPass(
ParkingPassID int not null auto_increment,
primary key (ParkingPassID),
ParkingPassCode varchar (10),
ParkingPassCost decimal (6,2)
);

drop table if exists Refreshment;
create table Refreshment(
RefreshmentID int not null auto_increment,
primary key (RefreshmentID),
RefreshmentCode varchar (10),
RefreshmentName varchar (250),
RefreshmentCost decimal (6,2)
);

drop table if exists Invoice;
create table Invoice(
InvoiceID int not null auto_increment,
primary key (InvoiceID),
InvoiceCode varchar (10),
CustomerID INT NULL,
foreign key (CustomerID) references Customers(CustomerID),
SalePerson INT NULL,
foreign key (SalePerson) references Persons(PersonID),
DateOfPurchase date
);


drop table if exists ProductOrder;
create table ProductOrder(
ProductOrderID int not null auto_increment,
primary key (ProductOrderID),
InvoiceID INT NULL,
foreign key (InvoiceID) references Invoice(InvoiceID),
ProductType varchar (25),
ProductID int,
Quantity int
);

# -------------
# Inserted Data
# -------------

insert into CountryState
	(StateName, CountryName)
values
	('OR','USA'),
    ('NJ','USA'),
    ('AL','USA'),
    ('WY','USA'),
    ('NE','USA'),
    ('VA','USA'),
    ('FL','USA'),
    ('HI','USA'),
    ('MD','USA'),
    ('IL','USA'),
    ('CT','USA'),
    ('CA','USA'),
    ('OH','USA'),
    ('NY','USA'),
    ('UT','USA'),
    ('ND','USA'),
    ('TN','USA'),
    ('GA','USA');
    
insert into CityZip
	(Street, CityName, ZipCode)
values
	('1481 Morningglory Lane','Portland','55108'),
    ('10 Smith Drive','Fairport','11111'),
    ('880 Fairfield Lane','Hong Kong','80193'),
    ('700 Gabriel Court','Cheyenne','82009'),
    ('16th St.','Lincoln','60508'),
    ('4040 Dell Range','Cheyenne','82009'),
    ('14 Heimster Blvd','Norfolk','80808'),
    ('2920 Pine Lake Rd', 'Lincoln', '68516'),
    ('1101 P St', 'Lincoln', '68508'),
    ('123 6th St.','Melbourne','32904'),
    ('4 Goldfield Rd.','Honolulu','96815'),
    ('71 Pilgrim Avenue','Chevy Chase','20815'),
    ('44 Shirley Ave.','West Chicago','60185'),
    ('70 Bowman St.','South Windsor','06074'),
    ('514 S. Magnolia St.','Orlando','32806'),
    ('996 Kent Court','Duarte','91010'),
    ('19 Bay Meadows Drive','Clearwater','33756'),
    ('12 South Cedar Drive','Bedford','44146'),
    ('65 Carson Road','Troy','92180'),
    ('8173 Sussex Lane','Palos Verdes Peninsula','90274'),
    ('7880 East Brandywine Street','Ogden','84404'),
    ('18 Sussex St.','Jupiter','33458'),
    ('9 Peg Shop Rd.','North Haven','06473'),
    ('169 South Pierce Lane','West Fargo','58078'),
    ('29 Circle Ave.','Mount Juliet','37122'),
    ('22 Shadow Brook St.','Bowie','20715'),
    ('998 Temple Street','Northbrook','60062'),
    ('816 Atlantic Street','Decatur','30030'),
    ('235 Illinois St.','Suitland','20746');

insert into Address
	(CityZipID, CountryStateID)
values
	(1,1),
    (2,2),
    (3,3),
    (4,4),
    (5,5),
    (6,4),
    (7,6),
    (8,5),
    (9,5),
    (10,7),
    (11,8),
    (12,9),
    (13,10),
    (14,11),
    (15,7),
    (16,12),
    (17,7),
    (18,13),
    (19,14),
    (20,12),
    (21,15),
    (22,7),
    (23,11),
    (24,16),
    (25,17),
    (26,9),
    (27,10),
    (28,18),
    (29,9);

#trying to show all info address, not working
#select Street, CityName, ZipCode, State, Country from Address a inner join CityZip cz on a.CityZipID = cz.CityZipID  inner join CountryState cs on a.CountryStateID = cs.CountryStateID;

insert into Persons
	(PersonCode, LastName,FirstName, AddressID)
values
	('cig','Morales','Bob',10),
    ('832','Richardson', 'Dean',11),
    ('fid','Hudson', 'Gwen',12),
    ('2382','Norman', 'Marion',13),
    ('aksj','Austin', 'Randolph',14),
    ('cich','Quinn', 'Leslie',15),
    ('diej','Higgins', 'Chris',16),
    ('sisu','Pena', 'Vincent',17),
    ('aisje','McCormick', 'Sidney',18),
    ('fv8fq','Day', 'Otis',19),
    ('viofu','Stokes', 'Rick',20),
    ('skgn8','Cox', 'Ebony',21),
    ('null','Burke', 'Alex',22),
    ('9383s','Ramirez', 'Terrance',23),
    ('tt194','Leonard', 'George',24),
    ('j5k4l','Owens', 'Brad',25),
    ('15','Vargas', 'Ethel',26),
    ('hello','Sandoval', 'Kelley',27),
    ('8178','Warner', 'Taylor',28),
    ('198h','Fisher', 'Mona',29);

insert into Email
	(Email, PersonID)
values
	('jugalator@sbcglobal.net',5),
    ('jfmulder@aol.com',6),
    ('rnelson@att.net',7),
    ('citizenl@me.com',8),
    ('yzheng@outlook.com',9),
    ('johndo@outlook.com',10),
    ('eidac@gmail.com',11),
    ('drolsky@verizon.net',11),
    ('kramulous@msn.com',12),
    ('barlow@yahoo.ca',12),
    ('dmiller@aol.com',13),
    ('crowl@aol.com',13),
    ('calin@yahoo.ca',14),
    ('msherr@comcast.net',14),
    ('mlewan@aol.com',15),
    ('pajas@live.com',15),
    ('josephw@icloud.com',16),
    ('eegsa@msn.com',16),
    ('jdhildeb@me.com',17),
    ('benanov@msn.com',17),
    ('gilmoure@icloud.com',18),
    ('skajan@icloud.com',18),
    ('mcast@gmail.com',18),
    ('granboul@optonline.net',19),
    ('dsowsy@att.net',19),
    ('pspoole@yahoo.com',19),
    ('osaru@yahoo.ca',20),
    ('scarlet@yahoo.com',20),
    ('pfitza@live.com',20);
    
insert into Customers
	(CustomerCode, CustomerType, CompanyName, AddressID)
values
	('A110','Student',"Billy Joe's Metalsmithy",1),
    ('A111','General','Absolute Nothing, Incorporated',2),
    ('A112','General','Information Systems and Networks',3),
    ('A113','Student','Outback Steakhaus',4),
    ('A114','General','University of Nebraska',5),
    ('A115','Student','Target',6),
    ('A116','Student','nullInc',7);
   
insert into CustomerPersons
	(CustomerID, PersonID)
values
	(1,20),
    (2,19),
    (3,18),
    (4,17),
    (5,16),
    (6,15),
    (7,13);

insert into MovieTickets
	(MovieCode, DayAndTime, MovieTitle, AddressID, Screen, MovieTicketsCost)
values
	('gr93','2017-05-16 17:30:00','Lord of the Rings',8,'16A',8.75),
    ('gbw3','2017-09-28 18:00:00','Hook',9,'7C',6.50);
    
insert into SeasonPass
	(SeasonPassCode, SeasonPassName, StartDate, EndDate, SeasonPassCost)
values
	('4d81','Christmas Special','2017-11-21','2018-01-12',95.00),
    ('71e8','Halloween Spooky Deal','2017-10-01','2017-11-08',50.00);

insert into ParkingPass
	(ParkingPassCode, ParkingPassCost)
values
	('d7a9',35.00),
    ('v6he',15.00),
    ('vl51',25.00);

insert into Refreshment
	(RefreshmentCode, RefreshmentName, RefreshmentCost)
values
	('c3sd','Raisinets',3.00),
    ('ts6h','Buttered Popcorn Large',8.50),
    ('scg5','Skittles',2.50),
    ('32kj','Hops Rising',5.00);
    
insert into Invoice
	(InvoiceCode, CustomerID, SalePerson, DateOfPurchase)
values
	('INV001',5,9,'2017-06-21'),
    ('INV002',7,15,'2017-09-28'),
    ('INV003',4,5,'2017-11-1'),
    ('INV004',2,2,'2017-05-31');
    
insert into ProductOrder
	(InvoiceID, ProductType, ProductID, Quantity)
values
	(1,'Refreshment',1,4),
    (1,'MovieTickets',1,6),
    (1,'ParkingPass',2,2),
    (1,'Refreshment',4,2),
    (2,'ParkingPass',3,4),
    (2,'Refreshment',2,7),
    (2,'MovieTickets',2,3),
    (3,'SeasonPass',2,15),
    (3,'MovieTickets',2,20),
    (3,'Refreshment',2,23),
    (4,'ParkingPass',1,2),
    (4,'Refreshment',3,6);

    
    
