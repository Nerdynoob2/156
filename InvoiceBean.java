import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class InvoiceBean {

	
	public Invoice getAllInvoice(String invoiceCode)
	{
		String query = "Get invoice";
		Connection conn = API.getConnection();
		
		try
		{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, albumTitle);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			conn.close();
			return this.getInvoice(rs.getInt("AlbumID"));
		}
		catch (SQLException e)
		{
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public Invoice getAllInvoice(int albumID){
		

		Invoice a = new Invoice();
		
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
		

		String query = "SELECT AlbumTitle, AlbumYear, BandID, AlbumNumber FROM Albums where AlbumID = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, albumID);
			rs = ps.executeQuery();
			if(rs.next()) {
				a.setAlbumId(albumID);
				a.setTitle(rs.getString("AlbumTitle"));
				a.setYear(rs.getInt("AlbumYear"));
				a.setAlbumNumber(rs.getInt("AlbumNumber"));
				BandBean bb = new BandBean();
				Band b = bb.getBand(rs.getInt("BandID"));
				a.setBand(b);
			}
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
}
