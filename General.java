
public class General implements Customer{

	private String customerCode;//alpha-numerics
	private String customerType;
	private Person contactPerson;//person assigned as a contact
	private String name;
	private Address address;
	
	

	public General(String customerCode, String customerType, Person contactPerson, String name, Address address) {
		super();
		this.customerCode = customerCode;
		this.customerType = customerType;
		this.contactPerson = contactPerson;
		this.name = name;
		this.address = address;
	}


	
	
	public String getCustomerCode() {
		return customerCode;
	}




	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}




	public String getCustomerType() {
		return customerType;
	}




	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}




	public Person getContactPerson() {
		return contactPerson;
	}




	public void setContactPerson(Person contactPerson) {
		this.contactPerson = contactPerson;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public Address getAddress() {
		return address;
	}




	public void setAddress(Address address) {
		this.address = address;
	}




	public double getDiscount() {
		return 0;
	}


	public double getFee() {
		return 0;
	}

	
}
