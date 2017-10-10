
public class Student extends Customer{

	public Student(String customerCode, Person contactPerson, String name, Address address) {
		super(customerCode, contactPerson, name, address);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getReimbursement() {
		// TODO calculate reimbursement
		return 0;
	}

	@Override
	public double getFee() {
		// TODO calculate fee
		return 0;
	}
	
}
