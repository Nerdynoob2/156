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
#Note: One query is necessary to change AddressID, but this design allows
	#for it to be changed to any address by replacing the above fields appropriately
UPDATE MovieTicket
	SET AddressID = (SELECT LAST_INSERT_ID())
    WHERE MovieTicketID = 1;

#4
DELETE FROM ProductOrder WHERE ProductType = 'MovieTicket' AND ProductID = 1;
DELETE FROM MovieTicket WHERE MovieTicketID = '1';

#5
SELECT * FROM ProductOrder po JOIN Invoice i ON po.InvoiceID = i.InvoiceID WHERE i.InvoiceCode = 'INV001';

#6
SELECT * FROM Invoice i JOIN Customers c ON i.CustomerID = c.CustomerID WHERE c.CustomerCode = 'A114';

#7
INSERT INTO ProductOrder (InvoiceID, ProductType, ProductID, Quantity)
	VALUES (1, 'Refreshment', (SELECT RefreshmentID FROM Refreshment WHERE RefreshmentCode = 'c3sd'), 5);

#8
SELECT SUM(MovieTicketCost) FROM MovieTicket;

#9
SELECT COUNT(MovieTicketID) FROM MovieTicket WHERE DayAndTime = '2017-05-16 17:30:00';

#10
SELECT PersonCode, FirstName, LastName, Count(*) AS InvoiceCount FROM Invoice, Persons WHERE Invoice.SalePerson = Persons.PersonID GROUP BY PersonID ORDER BY InvoiceID;

#11
SELECT MovieTitle, Count(*) AS InvoiceCount FROM Invoice, ProductOrder, MovieTicket WHERE ProductOrder.InvoiceID = Invoice.InvoiceID AND ProductOrder.ProductID = 1 AND ProductOrder.ProductType = 'MovieTicket';

#12
SELECT SUM(MovieTicketCost * Quantity) FROM ProductOrder po JOIN MovieTicket mt ON po.ProductID = mt.MovieTicketID AND po.ProductType = 'MovieTicket' WHERE mt.DayAndTime = '2017-05-16 17:30:00';

#13
SELECT ProductType, SUM(ParkingPassCost*Quantity)+SUM(RefreshmentCost*Quantity) AS Sums
	  FROM ProductOrder po JOIN ParkingPass pp ON po.ProductID = pp.ParkingPassID
		JOIN Refreshment r on po.ProductID = r.RefreshmentID WHERE (po.ProductType = 'Refreshment' OR po.ProductType = 'ParkingPass')
		GROUP BY po.ProductType;

#14 This method returns any duplicate invoice data
SELECT * FROM ProductOrder po1 JOIN ProductOrder po2 
	WHERE po1.ProductType = po2.ProductType 
		AND po1.ProductID = po2.ProductID 
		AND po1.InvoiceID = po2.InvoiceID 
		AND po1.ProductOrderID != po2.ProductOrderID; #ensures that it does not trigger on the same record

#15 This method returns any conflicts of interest, in the form of the person in question
SELECT * FROM Invoice i JOIN Customers c ON i.CustomerID = c.CustomerID
					JOIN Persons p1 ON i.SalePerson = p1.PersonID
					JOIN CustomerPersons cp ON c.CustomerID = cp.CustomerID
					JOIN Persons p2 ON p2.PersonID = cp.PersonID #join all necessary tables
			WHERE p1.PersonID = p2.PersonID; #compare salesperson to customer
