import java.util.List;

public class DataConverter {

	public static void main(String[] args) {
		
		// Create a FileReader object
		FileReader fr = new FileReader();
		
		/* fr Reads data from the flat file;
		 * Creates Person objects; and
		 * Stores Person objects in a Person ArrayList
		 */
		List<Persons> personList = fr.readPersons();
		
		/* fr Reads data from the flat file;
		 * Creates Customer objects; and
		 * Stores Customer objects in a Customer ArrayList
		 */
		List<Customer> customerList = fr.readCustomers();
		/* fr Reads data from the flat file;
		 * Creates Product objects; and
		 * Stores Product objects in a Product ArrayList
		 */
		List<Product> productList = fr.readProducts();
		
		//Create a FileWriter object
		FileWriter fw = new FileWriter();		
		
		// Write Person ArrayList into a Json file
		fw.jsonConverterPeople(personList);
		
		// Write Customer ArrayList into a Json file
		fw.jsonConverterCustomer(customerList);

		
		// Write Product ArrayList into a Json file
		fw.jsonConverterProduct(productList);
		
		
	
		// Write Person ArrayList into an XML file
		//XMLWriter xmlWriter = new XMLWriter();
	    //xmlWriter.xmlConverter(personList);
	}
}
