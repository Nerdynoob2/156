
public class Student extends Customer{

	public Student(String customerCode, Person contactPerson, String name, Address address) {
		super(customerCode, contactPerson, name, address);
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
