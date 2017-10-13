
public class General extends Customer{

	public General(String customerCode, String customerType, Person contactPerson, String name, Address address) {
		super(customerCode, customerType, contactPerson, name, address);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getDiscount() {
		return 0;
	}

	@Override
	public double getFee() {
		return 0;
	}

	
}
