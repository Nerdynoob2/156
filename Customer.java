public class Customer {
	private String customerCode;//alpha-numerics
	private Persons contactPerson;//person assigned as a contact
	private String name;
	private Address address;
	
	
	//Constructor
	public Customer(String customerCode, Persons contactPerson, String name, Address address){
		this.customerCode = customerCode;
		this.contactPerson = contactPerson;
		this.name = name;
		this.address = address;
	}
	//setters
	public void setCustomerCode(String customerCode){
		this.customerCode = customerCode;
	}
	
	
	public void setPersonContact(Persons contactPerson){
		this.contactPerson = contactPerson;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public void setAddress(Address address){
		this.address = address;
	}
	
	
	
	
	//getters
	public String getCustomerCode(){
		return this.customerCode;
	}
	
	public Persons getContactPersons(){
		return this.contactPerson;
	}
	
	
	public String getName(){
		return this.name;
	}
	
	public Address getAddress(){
		return this.address;
	}
	
	
	
	
	
	
}