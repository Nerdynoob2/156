import java.sql.*;
import java.util.ArrayList;

public class InvoiceReport {

	public static void main(String[] args) throws SQLException {
		API api = new API();
		Connection conn = API.getConnection();
		MyList<Invoice> invoiceList = api.getInvoice(conn);
		
		Report r = new Report();
		r.summaryReport(invoiceList);
		r.detailReport(invoiceList);		
	}

}
