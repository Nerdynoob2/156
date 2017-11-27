

public class Report {

	public void summaryReport(MyList<Invoice> invoiceList){
		System.out.println("Executive Summary Report");
		line(24);
		System.out.printf("%-10s %-50s %-30s %-15s %-15s %-15s %-15s %-15s\n",
				"Invoice", "Customer", "Salesperson", "Subtotal", "Fees",
				"Taxes", "Discounts", "Total");
		for(Node<Invoice> invoice : invoiceList){
			if(invoice.getItem().getCustomer().getCustomerType().equals("General")){
				General g = (General)invoice.getItem().getCustomer();
				System.out.printf("%-10s %-50s %-30s $ %7.2f      $ %7.2f      $ %7.2f      $ %7.2f      $ %7.2f\n", 
					invoice.getItem().getInvoiceCode(), g.getName() + "[General]", 
					invoice.getItem().getSalesperson().getFullName(), invoice.getItem().getSubtotal(),
					invoice.getItem().getFees(), invoice.getItem().getTaxes(), invoice.getItem().getReimbursement(invoice.getItem().getCustomer().getCustomerType()), invoice.getItem().getGrandTotal());
			} else if(invoice.getItem().getCustomer().getCustomerType().equals("Student")){
				Student s = (Student)invoice.getItem().getCustomer();
				System.out.printf("%-10s %-50s %-30s $ %7.2f      $ %7.2f      $ %7.2f      $ %7.2f      $ %7.2f\n", 
						invoice.getItem().getInvoiceCode(), s.getName() + "[Student]", 
						invoice.getItem().getSalesperson().getFullName(), invoice.getItem().getSubtotal(),
						invoice.getItem().getFees(), invoice.getItem().getTaxes(), invoice.getItem().getReimbursement(invoice.getItem().getCustomer().getCustomerType()), invoice.getItem().getGrandTotal());
			}	else{
				System.out.printf("Error: Customer Type not found\n");
			}
		}
		line(170);
		System.out.printf("%-92s $ %7.2f      $ %7.2f      $ %7.2f      $ %7.2f      $ %7.2f" , "TOTALS", 
				this.subtotal(invoiceList), this.fees(invoiceList), 
				this.taxes(invoiceList), this.discount(invoiceList), this.total(invoiceList) );
		newLine();
		newLine();
		newLine();
		newLine();
		newLine();
		
	}
	
	
	public void detailReport(MyList<Invoice> invoiceList){
		System.out.println("Individual Invoice Detail Reports");
		line(50);
		for(Node<Invoice> invoice : invoiceList){
			System.out.println("Invoice " + invoice.getItem().getInvoiceCode());
			line(24);
			System.out.println("Salesperson: " + invoice.getItem().getSalesperson().getFullName());
			System.out.println("Customer Info: \n\t" + invoice.getItem().getCustomer().getName() + 
					" ("+ invoice.getItem().getCustomer().getCustomerCode() + ")");
			if(invoice.getItem().getCustomer() instanceof General){
				System.out.println("\t[General]");
			} else if(invoice.getItem().getCustomer() instanceof Student){
				System.out.println("\t[Student]");
			} else {
				System.out.println("ERROR: customer type not found");
			}
			System.out.println("\t" + invoice.getItem().getCustomer().getContactPerson().getFullName());	
			System.out.println("\t" + invoice.getItem().getCustomer().getAddress().getStreet());
			System.out.println("\t" + invoice.getItem().getCustomer().getAddress().getCity() + " " +
					invoice.getItem().getCustomer().getAddress().getState() + " " +invoice.getItem().getCustomer().getAddress().getZip() + " " +
					invoice.getItem().getCustomer().getAddress().getCountry());
			thinLine(43);
			 //code, item, subtotal, etc
			
			//call itemDetail on the item MyList
			System.out.printf("Code       	Item");
			tab(11);
			System.out.printf("Subtotal");
			tab(1);
			System.out.printf("Tax");
			tab(1);
			System.out.printf("Total");
			newLine();
			invoice.getItem().itemDetail();
			tab(12);
			line(44);
			System.out.printf("SUBTOTALS        							      			     $ %7.2f       $ %7.2f  $ %7.2f", invoice.getItem().getSubtotal(), invoice.getItem().getTaxes(), invoice.getItem().getTotal());
			newLine();
			if(invoice.getItem().getCustomer().getCustomerType().equals("Student")){
				System.out.printf("DISCOUNT (8%% STUDENT & NO TAX)													$ %7.2f", invoice.getItem().getReimbursement(invoice.getItem().getCustomer().getCustomerType()));
				newLine();
				System.out.printf("ADDITIONAL FEE (Student)													$ %7.2f", invoice.getItem().getFees());
				newLine();
			}
			System.out.printf("TOTAL");
			tab(16);
			System.out.printf("$ %7.2f", invoice.getItem().getGrandTotal());
			newLine(3);
			System.out.println("Thank you for your purchase!");
			newLine(3);		
		}
		
		line(150);
	}
	
	
	
	
	
	
	public double subtotal(MyList<Invoice> invoiceList){
		double sum = 0;
		for(Node<Invoice> invoice : invoiceList){
			sum = sum + invoice.getItem().getSubtotal();
		}
		return sum;
	}
	
	public double fees(MyList<Invoice> invoiceList){
		double sum = 0;
		for(Node<Invoice> invoice : invoiceList){
			sum = sum + invoice.getItem().getFees();
		}
		return sum;
	}
	
	public double taxes(MyList<Invoice> invoiceList){
		double sum = 0;
		for(Node<Invoice> invoice : invoiceList){
			sum = sum + invoice.getItem().getTaxes();
		}
		return sum;
	}
	
	public double discount(MyList<Invoice> invoiceList){
		double sum = 0;
		for(Node<Invoice> invoice : invoiceList){
			sum = sum + invoice.getItem().getReimbursement(invoice.getItem().getCustomer().getCustomerType());
		}
		return sum;
	}
	
	public double reimbursement(MyList<Invoice> invoiceList) {
		double sum =0;
		for(Node<Invoice> invoice : invoiceList) {
			sum = sum + invoice.getItem().getDiscounts();
		}
		return sum;
	}
	
	public double total(MyList<Invoice> invoiceList){
		double sum = 0;
		for(Node<Invoice> invoice : invoiceList){
			sum = sum + invoice.getItem().getTotal();
		}
		return sum;
	}
	
	
	
	public void newLine(){
		System.out.printf("\n");
	}
	
	public void newLine(int n){
		System.out.printf("\n");
		if(n>0){
			newLine(n-1);
		}
	}
	
	public void line(int n){
		for (int i=0; i<n;i++){
			System.out.printf("=");
		}
		newLine();
		//long: 28
		//footer: 118
		//medium: 50
		//subtotal: 37
		//short: 24
	}
	
	public void thinLine(int n){
		for (int i=0; i<n;i++){
			System.out.printf("-");
		}
		newLine();
	}
	
	public void tab(int n){
		for(int i=0; i<n;i++){
			System.out.printf("\t");
		}
	}
	//43
	
}
