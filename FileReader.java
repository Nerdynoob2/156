	import java.io.File;
	import java.io.FileNotFoundException;

import java.util.ArrayList;
	import java.util.Scanner;

	public class FileReader {
		ArrayList<Person> personList = new ArrayList<Person>();
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();
				
		
		public ArrayList<Person> readPerson() {
			Scanner sc = null;
				
				try {
					sc = new Scanner(new File("data/Person.dat"));
					sc.nextLine(); // reads the number of records from the first line

					while(sc.hasNext()) {
						String line = sc.nextLine(); // reads each line starting from 2nd line
						String data[] = line.split(";"); // tokenizes the line and stores in a string array 
						
						// Stores the 4 array elements of each line into strings
						String personCode = data[0];
						String name = data[1];
						String address = data[2];
						String email = null;
						if(data.length == 4){
							email = data[3];
						}
						
						
						// Creates an Address object
						String addressArray[] = address.split(",");
						String street = addressArray[0];
						String city = addressArray[1];
						String state = addressArray[2];
						String zip = addressArray[3];
						Address addressObject;
						if(addressArray.length == 5){
							String country = addressArray[4];
							addressObject = new Address(street, city, state, zip, country);
						}else{
						
						addressObject = new Address(street, city, state, zip);
						}
						// Creates a Person object
						//split up name
						String nameArray[] = name.split(",");
						String firstName = nameArray[1];
						String lastName = nameArray[0];
			
						Person person = new Person(personCode, firstName, lastName, addressObject);
						
						if(data.length == 4){
							person.addEmail(email);
						}
						
						// Adds the Person object into Person ArrayList
						personList.add(person);
					}
					sc.close();
					return personList;
					
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					return null;
				}	
			}
		
		public ArrayList<Customer> readCustomers() {
			Scanner sc = null;
				
				try {
					sc = new Scanner(new File("data/Customers.dat"));
					sc.nextLine(); // reads the number of records from the first line
					
					while(sc.hasNext()) {
						String line = sc.nextLine(); // reads each line starting from 2nd line
						String data[] = line.split(";"); // tokenizes the line and stores in a string array 
						
						// Stores the 4 array elements of each line into strings
						String customerCode = data[0];
						String customerType = data[1];
						String primaryContact = data[2];
						String name = data[3];
						String address = data[4];
						
						
						// Creates an Address object
						String addressArray[] = address.split(",");
						String street = addressArray[0];
						String city = addressArray[1];
						String state = addressArray[2];
						String zip = addressArray[3];
						String country = addressArray[4];
						
						Address addressObject;
						if(addressArray.length == 5){
							addressObject = new Address(street, city, state, zip, country);
						}else{
						
							addressObject = new Address(street, city, state, zip);
						}

						Person personObject = null;
						
						for (Person aPerson : personList) {
							
							if(aPerson.getPersonCode().equals(primaryContact)) {
								personObject = new Person(aPerson.getPersonCode(), aPerson.getFirstName(), aPerson.getLastName(), aPerson.getAddress());
							}
						}
						
						Customer newCustomer;
						if(customerType.equals("S")){
							newCustomer = new Student(customerCode, "Student", personObject, name, addressObject);
						} else {
							newCustomer = new General(customerCode, "General", personObject, name, addressObject);
						}
						// Adds the Customer object into Customer ArrayList
						customerList.add(newCustomer);
					}
					sc.close();
					return customerList;
					
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					return null;
				}	
			}

		public ArrayList<Product> readProducts() {
			Scanner sc = null;
				
				try {
					sc = new Scanner(new File("data/Products.dat"));
					sc.nextLine(); // reads the number of records from the first line
					
					while(sc.hasNext()) {
						String line = sc.nextLine(); // reads each line starting from 2nd line
						String data[] = line.split(";"); // tokenizes the line and stores in a string array 
						
						// Stores the 4 array elements of each line into strings
						String code = data[0];
						String type = data[1];
						Product newProduct;
						if(data.length == 7){
							String dateTime = data[2];
							String movieName = data[3];
							String address = data[4];
							//create address object
							String addressArray[] = address.split(",");
							String street = addressArray[0];
							String city = addressArray[1];
							String state = addressArray[2];
							String zip = addressArray[3];
							String country = addressArray[4];
							Address addressObject = null;
						if(addressArray.length == 5){
								addressObject = new Address(street, city, state, zip, country);
						}else{
							
							addressObject = new Address(street, city, state, zip);
							}
							String screenNo = data[5];
							double pricePerUnit = Double.parseDouble(data[6]);
							//create movie ticket object
							newProduct = new MovieTicket(code, type, dateTime, "'" + movieName + "'", addressObject, screenNo, pricePerUnit);
							
						}else if(data.length == 6){
							String name = data[2];
							String startDate = data[3];
							String endDate = data[4];
							double cost = Double.parseDouble(data[5]);
							//create season pass object
							newProduct = new SeasonPass(code, type, name, startDate, endDate, cost);
						
						}else if(data.length == 4){
							String name = data[2];
							double cost = Double.parseDouble(data[3]);
							//create refreshment object
							newProduct = new Refreshment(code, type, name, cost);
						
						}else{
							double parkingFee = Double.parseDouble(data[2]);
							//create parking pass
							newProduct = new ParkingPass(code, type, parkingFee);
						
						}
						
						//add to productList
						productList.add(newProduct);
					
					}
					sc.close();
					return productList;
					
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					return null;
				}	
			}
		
		public ArrayList<Invoice> readInvoice() {
			Scanner sc = null;
				
				try {
					sc = new Scanner(new File("data/Invoice.dat"));
					sc.nextLine(); // reads the number of records from the first line

					while(sc.hasNext()) {
						String line = sc.nextLine(); // reads each line starting from 2nd line
						String data[] = line.split(";"); // tokenizes the line and stores in a string array 
						
						// Stores the 4 array elements of each line into strings
						String invoiceCode = data[0];
						String customerCode = data[1];
						String salespersonCode = data[2];
						String invoiceDate = data[3];
						String productListTransfer = data[4];
						
						Person personObject = null;
						
						for (Person aPerson : personList) {
							
							if(aPerson.getPersonCode().equals(salespersonCode)) {
								personObject = new Person(aPerson.getPersonCode(), aPerson.getFirstName(), aPerson.getLastName(), aPerson.getAddress());
							}
						}
						
						Customer customerObject = null;
						for (Customer aCustomer : customerList) {
							
							if(aCustomer.getCustomerCode().equals(customerCode)) {
								if(aCustomer.getCustomerType().equals("Student")){
									Student s = (Student) aCustomer;
									customerObject = new Student(s.getCustomerCode(), s.getCustomerType(), s.getContactPerson(), s.getName(), s.getAddress());
								} else {
									General g = (General) aCustomer;
									customerObject = new General(g.getCustomerCode(), g.getCustomerType(), g.getContactPerson(), g.getName(), g.getAddress());
								}
							}
						}
						//brace yourselves
						ArrayList<Product> productListLocal = new ArrayList<Product>();
						String productListTokenizedComma[] = productListTransfer.split(",");
						//separate each object type
						for(String test : productListTokenizedComma) {
							String productListTokenized[] = test.split(":");
							String objectCode = productListTokenized[0];
							int count = Integer.parseInt(productListTokenized[1]);

							
							
							
							//successfully scan in a COPY of the object from the list (DEEP COPY)
							for(Product testProduct : productList) {
								if(testProduct.getProductCode().equals(objectCode)){
										Product newProduct = null;
										if(testProduct instanceof MovieTicket) {
											MovieTicket m = (MovieTicket) testProduct;
											newProduct = new MovieTicket(m.getProductCode(), m.getProductType(),
													m.getDateTime(), m.getMovieName(), m.getAddress(), m.getScreenNumber(),
													m.getPricePerUnit());
										
										} else if (testProduct instanceof ParkingPass) {
											ParkingPass p = (ParkingPass)testProduct;
											newProduct = new ParkingPass(p.getProductCode(), p.getProductType(), p.getParkingFee());
											
										} else if (testProduct instanceof Refreshment) {
											Refreshment r = (Refreshment) testProduct;
											newProduct = new Refreshment(r.getProductCode(), r.getProductType(), r.getName(), r.getCost());
											
										} else if (testProduct instanceof SeasonPass) {
											SeasonPass s = (SeasonPass) testProduct;
											newProduct = new SeasonPass(s.getProductCode(), s.getProductType(), s.getName(), s.getStartDate(),
													s.getEndDate(), s.getCost());
										}
										productListLocal.add(newProduct);
										newProduct.setUnits(count);
										
									
								}
							}
						}
						
						// Creates a Invoice object
						Invoice invoice = new Invoice(invoiceCode, customerObject, personObject, productListLocal, invoiceDate);
			
						
						
						
						
						// Adds the Invoice object into Invoice ArrayList
						invoiceList.add(invoice);
					}
					sc.close();
					return invoiceList;
					
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					return null;
				}	
			}
	}




