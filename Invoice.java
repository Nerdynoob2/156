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
		return -1 * (this.customer.getDiscount() * this.getSubtotal() + this.getTaxes());
	}
	
	//total
	public double getTotal(){
		return this.getSubtotal() + this.getTaxes(); 	
	}
	
	public double getGrandTotal(){
		return this.getTotal()  + this.getFees() + this.getReimbursement();	
	}
	
	// TODO check for all other methods of calculation!!
	//TODO check for misc. methods needed
	
	public int numMovieTickets() {
		int count = 0;
		for(Product product : this.getProductList()) {
			if(product instanceof MovieTicket) {
				count = product.getUnits() + count;
			}
		}
		return count;
	}
	public String movieTicketCode() {
	
		for(Product product : this.getProductList()) {
			if(product instanceof MovieTicket || product instanceof SeasonPass) {
				return product.getProductCode();
			}
		}
		return null;
	}
	
	public void itemDetail(){
			
		
		
		for(Product product : this.productList){
			if(product instanceof MovieTicket){
				
				MovieTicket movieTicket = null;
				movieTicket = (MovieTicket) product;
				
				
				
				
				System.out.printf("%-15s MovieTicket '%s' @ %s %90s %-14f $ %-14f $ %-14f", 
								movieTicket.getProductCode(), movieTicket.getMovieName(), movieTicket.getAddress().getStreet(),
								"$", movieTicket.getSubtotal(this.invoiceDate)*movieTicket.getUnits(), movieTicket.getTax(this.invoiceDate)*movieTicket.getUnits(),
								movieTicket.getTotal(this.invoiceDate)*movieTicket.getUnits());
				System.out.printf("\n");
				if(movieTicket.discountCheck(this.invoiceDate)){
					System.out.printf("%15s (%d units @ $%f/unit - Tue/Thu 7% off)", movieTicket.getDateTime(), movieTicket.getUnits(), movieTicket.getPricePerUnit());
				}
				else{
					System.out.printf("%15s (%d units @ $%f/unit)", movieTicket.getDateTime(), movieTicket.getUnits(), movieTicket.getPricePerUnit());
				}
				System.out.printf("\n");
				
				
			} else if(product instanceof ParkingPass){
				
				ParkingPass parkingPass = null;
				parkingPass = (ParkingPass) product;
				
				//ParkingPass parkingPass = product.returnItself();
				Boolean movieTicketExists;
				if(this.movieTicketCode() == null) {
					movieTicketExists = false;
				} else {
					movieTicketExists = true;
				}
				
				System.out.printf("%-15s ParkingPass", 
								parkingPass.getProductCode(), parkingPass.getProductCode());
				//movie ticket check
				if(movieTicketExists) {
					System.out.printf("%s (%d units @ $%.2f with %d free)", this.movieTicketCode(), parkingPass.getUnits(), parkingPass.getParkingFee(), this.numMovieTickets() );
				} else {
					System.out.printf("%s (%d units @ $%.2f)", this.movieTicketCode(), parkingPass.getUnits(), parkingPass.getParkingFee());
				}
				//subtotal, tax, total
				//this.getTotal( PASS INT );
				
				System.out.printf("%90s %-15f $ %-15f $ %-15f", "$", parkingPass.getSubtotal(this.invoiceDate) * parkingPass.getUnits(), parkingPass.getTax(this.invoiceDate) * parkingPass.getUnits(), parkingPass.getTotal(this.numMovieTickets()));
				System.out.println();
			} else if(product instanceof SeasonPass){
				
				SeasonPass seasonPass = null;
				seasonPass = (SeasonPass) product;
				
				
				System.out.printf("%-15s SeasonPass - %s %90s %-14f $ %-14f $ %-14f", 
								seasonPass.getProductCode(), seasonPass.getName(), "$",
								seasonPass.getSubtotal(this.invoiceDate)*seasonPass.getUnits(), seasonPass.getTax(this.invoiceDate)*seasonPass.getUnits(),
								seasonPass.getTotal(this.invoiceDate)*seasonPass.getUnits());
				System.out.printf("\n");
				
				System.out.printf("(%d units @ $%f/unit + $%d fee/unit)", seasonPass.getUnits(), seasonPass.getCost(), 8);
				
				System.out.printf("\n");
				
				
			} else if(product instanceof Refreshment){
			
				//if movie ticket, 5% discount
				Refreshment refreshment = null;
				refreshment = (Refreshment) product;
				Boolean movieTicketExists;
				if(this.movieTicketCode() == null) {
					movieTicketExists = false;
				} else {
					movieTicketExists = true;
				}
				
				System.out.printf("%s %-15s", 
								refreshment.getProductCode(), refreshment.getName());
				
				//movie ticket check
				if(movieTicketExists) {
					System.out.printf("(%d units @ $%.2f with 5% off)", refreshment.getUnits(), refreshment.getCost());
					refreshment.setCost(refreshment.getCost()*.95);
				} else {
					System.out.printf("(%d units @ $%.2f)", refreshment.getUnits(), refreshment.getCost());
				}
	
				
				System.out.printf("%90s %-15f $ %-15f $ %-15f", "$", refreshment.getSubtotal(this.invoiceDate) * refreshment.getUnits(), refreshment.getTax(this.invoiceDate) * refreshment.getUnits(), refreshment.getTotal(this.invoiceDate));
				System.out.println();
			} 
			
			
			
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
	
}
