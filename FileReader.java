	import java.io.File;
	import java.io.FileNotFoundException;

import java.util.ArrayList;
	import java.util.Scanner;

	public class FileReader {
		ArrayList<Person> personList = new ArrayList<Person>();
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		ArrayList<Product> productList = new ArrayList<Product>();
		// TODO add ArrayList of invoices
				
		
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
							newCustomer = new Student(customerCode, personObject, name, addressObject);
						} else {
							newCustomer = new General(customerCode, personObject, name, addressObject);
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
							String pricePerUnit = data[6];
							//create movie ticket object
							newProduct = new MovieTicket(code, type, dateTime, movieName, addressObject, screenNo, pricePerUnit);
							
						}else if(data.length == 6){
							String name = data[2];
							String startDate = data[3];
							String endDate = data[4];
							String cost = data[5];
							//create season pass object
							newProduct = new SeasonPass(code, type, name, startDate, endDate, cost);
						
						}else if(data.length == 4){
							String name = data[2];
							String cost = data[3];
							//create refreshment object
							newProduct = new Refreshment(code, type, name, cost);
						
						}else{
							String parkingFee = data[2];
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
		// TODO method for instantiating invoices
		// ** base off of existing structure for products, customers, etc.
	}




