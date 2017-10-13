
public class Student extends Customer{

	public Student(String customerCode, String customerType, Person contactPerson, String name, Address address) {
		super(customerCode, customerType, contactPerson, name, address);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getDiscount() {
		return .08;
	}

	@Override
	public double getFee() {
		return 6.75;
	}
	
}
