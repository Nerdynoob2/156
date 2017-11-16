import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class InvoiceBean {

	
	public InvoiceProc getInvoiceProc(String invoiceCode)
	{
		String query = "Get invoice";
		Connection conn = API.getConnection();
		
		try
		{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, invoiceCode);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			conn.close();
			return this.getInvoiceProc(rs.getInt("InvoiceID"));
		}
		catch (SQLException e)
		{
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public InvoiceProc getInvoiceProc(int InvoiceID){
		

		InvoiceProc a = new InvoiceProc();
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			System.out.println("InstantiationException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(API.url, API.username, API.password);
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		

		String query = "Stuff";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, InvoiceID);
			rs = ps.executeQuery();
			while(rs.next()) {
				//a.getMembers().add( new Member(rs.getString("InvoiceCode"), rs.getString("CustomerID"), rs.getString("SalePerson") ) );
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return a;
	}
}
	
