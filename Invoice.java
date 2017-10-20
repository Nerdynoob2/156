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
			if(product instanceof MovieTicket) {
				MovieTicket m = (MovieTicket) product;
				sum = sum + m.getSubtotal(this.invoiceDate);
				
				
			} else if (product instanceof ParkingPass) {
				ParkingPass p = (ParkingPass) product;
				int numFreePasses = 0;
				if((this.numMovieTickets() - p.getUnits()) >= 0) {
					numFreePasses = p.getUnits();
				} else if ((this.numMovieTickets() - p.getUnits()) < 0) {
					numFreePasses = this.numMovieTickets();
				}
				sum = sum + p.getSubtotal(p.getUnits() - numFreePasses);
				
			} else if(product instanceof Refreshment) {
				Refreshment r = (Refreshment) product;
				Boolean movieTicketExists;
				if(this.movieTicketCode() == null) {
					movieTicketExists = false;
				} else {
					movieTicketExists = true;
				}
				sum = sum + r.getSubtotal(movieTicketExists);
				
				
			} else if(product instanceof SeasonPass) {
				SeasonPass s = (SeasonPass) product;
				sum = sum + s.getSubtotal(this.invoiceDate);
			}
		}
		return sum;
	}
	
	//fees
	public double getFees(){
		if (this.getCustomer().getCustomerType().equals("Student")) {
			return 6.75;
		}
		else {
			return 0;
		}
	}
	
	//taxes
	public double getTaxes(){
		double sum=0;
		for(Product product : this.productList){
			if(product instanceof MovieTicket) {
				MovieTicket m = (MovieTicket) product;
				sum = sum + m.getTax(this.invoiceDate);
				
				
			} else if (product instanceof ParkingPass) {
				ParkingPass p = (ParkingPass) product;
				int numFreePasses = 0;
				if((this.numMovieTickets() - p.getUnits()) >= 0) {
					numFreePasses = p.getUnits();
				} else if ((this.numMovieTickets() - p.getUnits()) < 0) {
					numFreePasses = this.numMovieTickets();
				}
				sum = sum + p.getTax(p.getUnits() - numFreePasses);
				
			} else if(product instanceof Refreshment) {
				Refreshment r = (Refreshment) product;
				Boolean movieTicketExists;
				if(this.movieTicketCode() == null) {
					movieTicketExists = false;
				} else {
					movieTicketExists = true;
				}
				sum = sum + r.getTax(movieTicketExists);
				
				
			} else if(product instanceof SeasonPass) {
				SeasonPass s = (SeasonPass) product;
				sum = sum + s.getTax(this.invoiceDate);
			}
		}
		return sum;
	}
	
	//discount
	public double getReimbursement(String customerType){
		if(customerType.equals("Student")) {
			return -1 * (.08 * this.getSubtotal() + this.getTaxes());
		}
		else {
			return 0;
		}
	}
	
	public double getDiscounts() {
		return -1 * (this.getCustomer().getDiscount() * this.getSubtotal());
	}
	
	//total
	public double getTotal(){
		return this.getSubtotal() + this.getTaxes(); 	
	}
	
	public double getGrandTotal(){
		return this.getTotal()  + this.getFees() + this.getReimbursement(this.getCustomer().getCustomerType());	
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
				
				
				
				
				System.out.printf("%-15s MovieTicket %-20s @ %-40s %10s %7.2f       $ %7.2f  $ %7.2f", 
								movieTicket.getProductCode(), movieTicket.getMovieName(), movieTicket.getAddress().getStreet(),
								"$", movieTicket.getSubtotal(this.invoiceDate), movieTicket.getTax(this.invoiceDate),
								movieTicket.getTotal(this.invoiceDate));
				
				
				System.out.printf("\n");
				
				
				if(movieTicket.discountCheck()){
					System.out.printf("\t\t%15s (%d units @ $%.2f/unit - Tue/Thu 7%% off)", movieTicket.getDateTime(), movieTicket.getUnits(), movieTicket.getPricePerUnit());
				}
				else{
					System.out.printf("\t\t%15s (%d units @ $%.2f/unit)", movieTicket.getDateTime(), movieTicket.getUnits(), movieTicket.getPricePerUnit());
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
				
				System.out.printf("%-15s ParkingPass %-8s", 
								parkingPass.getProductCode(), parkingPass.getProductCode(), "");
				//movie ticket check
				int numFreePasses = 0;
				if((this.numMovieTickets() - parkingPass.getUnits()) >= 0) {
					numFreePasses = parkingPass.getUnits();
				} else if ((this.numMovieTickets() - parkingPass.getUnits()) < 0) {
					numFreePasses = this.numMovieTickets();
				}
				if(movieTicketExists) {
					System.out.printf("(%-3d units @ $%7.2f with %-3d free)%26s", parkingPass.getUnits(), parkingPass.getParkingFee(), numFreePasses, "" );
				} else {
					System.out.printf("(%-3d units @ $%7.2f)%40s", parkingPass.getUnits(), parkingPass.getParkingFee(), "");
				}
				//subtotal, tax, total
				//this.getTotal( PASS INT );
				
				System.out.printf("%4s %7.2f       $ %7.2f  $ %7.2f", "$", parkingPass.getSubtotal(parkingPass.getUnits() - numFreePasses), parkingPass.getTax(parkingPass.getUnits() - numFreePasses), parkingPass.getTotal(parkingPass.getUnits() - numFreePasses));
				System.out.println();
				
				
				
				
			} else if(product instanceof SeasonPass){
				
				SeasonPass seasonPass = null;
				seasonPass = (SeasonPass) product;
				
				
				System.out.printf("%-15s SeasonPass - %-60s %12s %7.2f       $ %7.2f  $ %7.2f", 
								seasonPass.getProductCode(), seasonPass.getName(), "$",
								seasonPass.getSubtotal(this.invoiceDate), seasonPass.getTax(this.invoiceDate),
								seasonPass.getTotal(this.invoiceDate));
				System.out.printf("\n");
				
				System.out.printf("\t\t(%d units @ $%.2f/unit + $%d fee/unit)", seasonPass.getUnits(), seasonPass.getCost(), 8);
				
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
				
				System.out.printf("%-15s %-20s", 
								refreshment.getProductCode(), refreshment.getName());
				
				//movie ticket check
				if(movieTicketExists) {
					System.out.printf("(%-3d units @ $%7.2f with 5%% off)%-22s", refreshment.getUnits(), refreshment.getCost(), "");
				} else {
					System.out.printf("(%-3d units @ $%7.2f)%-34s", refreshment.getUnits(), refreshment.getCost(), "");
				}
	
				
				System.out.printf("%10s %7.2f       $ %7.2f  $ %7.2f", "$", refreshment.getSubtotal(movieTicketExists), refreshment.getTax(movieTicketExists), refreshment.getTotal(movieTicketExists));
				System.out.println();
			} 

		}
	}
	
}
