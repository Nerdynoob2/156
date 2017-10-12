
public class General extends Customer{

	public General(String customerCode, Person contactPerson, String name, Address address) {
		super(customerCode, contactPerson, name, address);
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
