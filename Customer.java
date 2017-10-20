public interface Customer {
		
	//TODO calculate reimbursement (nonexistent for General)
	double getDiscount();
	//TODO calculating fees (nonexistent for General)
	double getFee();
	
	//necessary to properly index and access from ArrayLists
	String getCustomerCode();
	String getCustomerType();
	Person getContactPerson();
	String getName();
	Address getAddress();
}