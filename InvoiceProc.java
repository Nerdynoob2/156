
public class InvoiceProc {
	
	private Integer InvoiceID;
	private String InvoiceCode;
	private Integer CustomerID;
	private String SalePerson;
	private String DateOfPurchase;
	
	public InvoiceProc(){
		
	}
	
	public InvoiceProc(Integer InvoiceID, String InvoiceCode, Integer CustomerID, String SalePerson, String DateOfPurchase){
		this.InvoiceID = InvoiceID;
		this.InvoiceCode = InvoiceCode;
		this.CustomerID = CustomerID;
		this.SalePerson = SalePerson;
		this.DateOfPurchase = DateOfPurchase;
	}

	public Integer getInvoiceID() {
		return InvoiceID;
	}

	public void setInvoiceID(Integer invoiceID) {
		InvoiceID = invoiceID;
	}

	public String getInvoiceCode() {
		return InvoiceCode;
	}

	public void setInvoiceCode(String invoiceCode) {
		InvoiceCode = invoiceCode;
	}

	public Integer getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Integer customerID) {
		CustomerID = customerID;
	}

	public String getSalePerson() {
		return SalePerson;
	}

	public void setSalePerson(String salePerson) {
		SalePerson = salePerson;
	}

	public String getDateOfPurchase() {
		return DateOfPurchase;
	}

	public void setDateOfPurchase(String dateOfPurchase) {
		DateOfPurchase = dateOfPurchase;
	}
	
	
	
}
