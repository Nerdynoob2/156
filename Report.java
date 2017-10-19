import java.util.ArrayList;

public class Report {

	public void summaryReport(ArrayList<Invoice> invoiceList){
		System.out.println("Executive Summary Report");
		line(24);
		System.out.printf("%-10s %-50s %-30s %-15s %-15s %-15s %-15s %-15s",
				"Invoice", "Customer", "Salesperson", "Subtotal", "Fees",
				"Taxes", "Discounts", "Total");
		for(Invoice invoice : invoiceList){
			if(invoice.getCustomer().getCustomerType().equals("G")){
				System.out.printf("%-10s %-50s %-30s $ %-14d $ %-14d %-14d %-14d %-14d", 
					invoice.getInvoiceCode(), invoice.getCustomer().getName() + "[General]", 
					invoice.getSalesperson().getFullName(), invoice.getSubtotal(),
					invoice.getFees(), invoice.getTaxes(), invoice.getReimbursement(), invoice.getTotal());
			} else if(invoice.getCustomer().getCustomerType().equals("S")){
				System.out.printf("%-10s %-50s %-30s $ %-14d $ %-14d %-14d %-14d %-14d", 
						invoice.getInvoiceCode(), invoice.getCustomer().getName() + "[Student]", 
						invoice.getSalesperson().getFullName(), invoice.getSubtotal(),
						invoice.getFees(), invoice.getTaxes(), invoice.getReimbursement(), invoice.getTotal());
			}	else{
				System.out.printf("Error: Customer Type not found");
			}
		}
		line(148);
		System.out.printf("%-90s $ %-14d $ %-14d %-14d %-14d %-14d" , "TOTALS", 
				this.subtotal(invoiceList), this.fees(invoiceList), 
				this.taxes(invoiceList), this.discount(invoiceList), this.total(invoiceList) );
		newLine();
		newLine();
		newLine();
		newLine();
		newLine();
		
	}
	
	
	public void detailReport(ArrayList<Invoice> invoiceList){
		System.out.println("Individual Invoice Detail Reports");
		line(50);
		for(Invoice invoice : invoiceList){
			System.out.println("Invoice " + invoice.getInvoiceCode());
			line(24);
			System.out.println("Salesperson: " + invoice.getSalesperson().getFullName());
			System.out.println("Customer Info: \n\t" + invoice.getCustomer().getName() + 
					" ("+ invoice.getCustomer().getCustomerCode() + ")");
			if(invoice.getCustomer().getCustomerType().equals("G")){
				System.out.println("\t[General]");
			} else if(invoice.getCustomer().getCustomerType().equals("S")){
				System.out.println("\t[Student]");
			} else {
				System.out.println("ERROR: customer type not found");
			}
			System.out.println("\t" + invoice.getCustomer().getContactPerson().getFullName());	
			System.out.println("\t" + invoice.getCustomer().getAddress().getStreet());
			System.out.println("\t" + invoice.getCustomer().getAddress().getCity() + 
					invoice.getCustomer().getAddress().getState() + invoice.getCustomer().getAddress().getZip() +
					invoice.getCustomer().getAddress().getCountry());
			thinLine(43);
			System.out.println(""); //code, item, subtotal, etc
			
			//call itemDetail on the item list
			
			
			
			
			
			
			
			
			
		}
		
	
	}
	
	
	
	
	
	
	public double subtotal(ArrayList<Invoice> invoiceList){
		double sum = 0;
		for(Invoice invoice : invoiceList){
			sum = sum + invoice.getSubtotal();
		}
		return sum;
	}
	
	public double fees(ArrayList<Invoice> invoiceList){
		double sum = 0;
		for(Invoice invoice : invoiceList){
			sum = sum + invoice.getFees();
		}
		return sum;
	}
	
	public double taxes(ArrayList<Invoice> invoiceList){
		double sum = 0;
		for(Invoice invoice : invoiceList){
			sum = sum + invoice.getTaxes();
		}
		return sum;
	}
	
	public double discount(ArrayList<Invoice> invoiceList){
		double sum = 0;
		for(Invoice invoice : invoiceList){
			sum = sum + invoice.getReimbursement();
		}
		return sum;
	}
	
	public double total(ArrayList<Invoice> invoiceList){
		double sum = 0;
		for(Invoice invoice : invoiceList){
			sum = sum + invoice.getTotal();
		}
		return sum;
	}
	
	
	
	public void newLine(){
		System.out.printf("\n");
	}
	
	public void line(int n){
		for (int i=0; i<n;i++){
			System.out.printf("=");
		}
		//long: 148
		//footer: 118
		//medium: 50
		//subtotal: 36
		//short: 24
	}
	
	public void thinLine(int n){
		for (int i=0; i<n;i++){
			System.out.printf("-");
		}
	}
	//43
	
}
