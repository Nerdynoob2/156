import java.util.ArrayList;

public class Person {
	private String personCode;
	private String firstName;
	private String lastName;
	private Address address;
	private ArrayList<String> email;
	
	//Constructor
	public Person(String personCode, String firstName, String lastName, Address address){
		this.personCode = personCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	public Person(Person aPerson){
		this.personCode = aPerson.getPersonCode();
		this.firstName = aPerson.getFirstName();
		this.lastName = aPerson.getLastName();
		this.address = aPerson.getAddress();
		this.email = aPerson.getEmail();
	}
	
	//setters
	public void setPersonCode(String personCode){
		this.personCode = personCode;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public void setAddress(Address address){
		this.address = address;
	}
	public void setEmail(ArrayList<String> email){
		this.email = email;
	}
	
	//getters
	public String getPersonCode(){
		return this.personCode;
	}
	public String getFirstName(){
		return this.firstName;
	}
	public String getLastName(){
		return this.lastName;
	}
	public Address getAddress(){
		return this.address;
	}
	public ArrayList<String> getEmail(){
		return this.email;
	}
	
	public String getFullName(){
		return this.getLastName() + ", " + this.getFirstName();
	}
	
	//method for adding email
	
	public void addEmail(String email){
		String emails[] = email.split(",");
		ArrayList<String> returnThis = new ArrayList<String>();
		for(String s : emails){
			returnThis.add(s);
		}
		this.email = returnThis;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
