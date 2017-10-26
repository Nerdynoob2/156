#1
SELECT PersonCode, FirstName, LastName, Street, CityName, ZipCode, StateName, CountryName
	FROM Persons p JOIN Address a ON p.AddressID = a.AddressID 
		JOIN CityZip cz ON a.CityZipID = cz.CityZipID
        JOIN CountryState cs ON a.CountryStateID = cs.CountryStateID;

#2        
INSERT INTO Email (Email, PersonID) VALUES
	('testing123@anemailprovider.com', (SELECT PersonID FROM Persons WHERE FirstName = 'Bob' AND LastName = 'Morales'));

#3
INSERT INTO CityZip(Street, CityName, ZipCode)
	VALUES ('123 ASDF Court', 'Test', 82009);
INSERT INTO Address(CityZipID, CountryStateID)
	VALUES((SELECT CityZipID FROM CityZip cz WHERE (cz.Street = '123 ASDF Court' AND cz.CityName = 'Test' AND cz.ZipCode = 82009)),
		(SELECT CountryStateID FROM CountryState cs WHERE (cs.StateName = 'WY' AND cs.CountryName = 'USA')));
UPDATE MovieTicket
	SET AddressID = (SELECT LAST_INSERT_ID())
    WHERE MovieTitle = 'Lord of the Rings' AND DayAndTime = '2017-05-16 17:30:00';