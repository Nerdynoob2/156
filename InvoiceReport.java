import java.util.ArrayList;

public class InvoiceReport {

	public static void main(String[] args) {
		FileReader fr = new FileReader();
		
		fr.readPerson();
		fr.readCustomers();
		fr.readProducts();
		ArrayList<Invoice> invoiceList = fr.readInvoice();
		
		Report r = new Report();
		r.summaryReport(invoiceList);
		r.detailReport(invoiceList);		

	}

}
