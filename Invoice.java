import java.util.ArrayList;

public class Invoice {
	
	
	private String invoiceCode;
	//private String customerCode;
	private Customer customer;
	//private String salespersoncode;
	private Person salesperson;
	private String invoiceDate;
	private ArrayList<Product> productList;
	
	
	
	public Invoice(String invoiceCode, Customer customer, Person salesperson, ArrayList<Product> productList,
			String currentDate) {
		super();
		this.invoiceCode = invoiceCode;
		this.customer = customer;
		this.salesperson = salesperson;
		this.productList = productList;
		this.invoiceDate = currentDate;
	}
	
	public String getInvoiceCode() {
		return invoiceCode;
	}

	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Person getSalesperson() {
		return salesperson;
	}

	public void setSalesperson(Person salesperson) {
		this.salesperson = salesperson;
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public double getSubtotal(){
		//sum of subtotals of all products in list
		double sum=0;
		for(Product product : this.productList){
			sum = sum + product.getSubtotal(this.getInvoiceDate());
		}
		return sum;
	}
	
	//fees
	public double getFees(){
		return this.customer.getFee();
	}
	
	//taxes
	public double getTaxes(){
		double sum=0;
		for(Product product : this.productList){
			sum = sum + product.getTax(this.getInvoiceDate());
		}
		return sum;
	}
	
	//discount
	public double getReimbursement(){
		return this.customer.getDiscount() * this.getSubtotal();
	}
	
	//total
	public double getTotal(){
		return this.getSubtotal() - this.getTaxes() 
					- this.getFees() + this.getReimbursement();		
	}
	
	// TODO check for all other methods of calculation!!
	//TODO check for misc. methods needed
	
}
