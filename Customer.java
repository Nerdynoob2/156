public abstract class Customer {
	private String customerCode;//alpha-numerics
	private Person contactPerson;//person assigned as a contact
	private String name;
	private Address address;
	
	
	//Constructor
	public Customer(String customerCode, Person contactPerson, String name, Address address){
		this.customerCode = customerCode;
		this.contactPerson = contactPerson;
		this.name = name;
		this.address = address;
	}
	//setters
	public void setCustomerCode(String customerCode){
		this.customerCode = customerCode;
	}
	
	
	public void setPersonContact(Person contactPerson){
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
	
	public Person getContactPerson(){
		return this.contactPerson;
	}
	
	
	public String getName(){
		return this.name;
	}
	
	public Address getAddress(){
		return this.address;
	}
	
	
	//TODO calculate reimbursement (nonexistent for General)
	public abstract double getDiscount();
	//TODO calculating fees (nonexistent for General)
	public abstract double getFee();
	
	
}