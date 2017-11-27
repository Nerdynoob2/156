	
import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class API {

		public static final String url = "jdbc:mysql://cse.unl.edu/ndoher";
		public static final String username = "ndoher";
		public static final String password = "Echo007!";
		
		static public Connection getConnection(){
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
			
			return conn;
		}
	
		public MyList<Invoice> getInvoice(Connection conn) throws SQLException{
			Statement stmt = null;
	        PreparedStatement ps = null;
	        MyList<Invoice> invoiceList = new MyList<Invoice>();
	        ArrayList<ArrayList<Product>> arrayOfArrays = new ArrayList<ArrayList<Product>>();
			int invoiceCount = 0;
	        try{	

		        //add list of products
		        
		        String sql4 = "SELECT InvoiceCode from Invoice";
		        PreparedStatement ps4 = conn.prepareStatement(sql4);
		        ResultSet rs4 = ps4.executeQuery();
		        while(rs4.next()) {
		        	ArrayList<Product> e = new ArrayList<Product>();
		        	arrayOfArrays.add(e);
		        }
		        
		        //season passes
		        String sql5 = "SELECT DISTINCT * FROM Invoice i, ProductOrder po, SeasonPass sp \r\n" + 
		        		"	WHERE po.ProductType = \"SeasonPass\" AND i.InvoiceID = po.InvoiceID AND sp.SeasonPassID = po.ProductID\r\n" + 
		        		"	GROUP BY po.ProductOrderID";
		        PreparedStatement ps5 = conn.prepareStatement(sql5);
		        ResultSet rs5 = ps5.executeQuery();
		        while(rs5.next()) {
		        	SeasonPass sp = new SeasonPass(rs5.getString("SeasonPassCode"),
		        			"Season Pass",
		        			rs5.getString("SeasonPassName"),
		        			rs5.getString("StartDate"),
		        			rs5.getString("EndDate"),
		        			rs5.getDouble("SeasonPassCost")
		        			);

		        	sp.setUnits(rs5.getInt("Quantity"));
		        	int invoiceID = rs5.getInt("InvoiceID");
		        	arrayOfArrays.get(invoiceID-1).add(sp);
		        }
	        	
		        //parking passes
		        String sql6 = "SELECT * FROM Invoice i, ProductOrder po, ParkingPass pp \r\n" + 
		        		"	WHERE po.ProductType = \"ParkingPass\" AND i.InvoiceID = po.InvoiceID AND pp.ParkingPassID = po.ProductID\r\n" + 
		        		"	GROUP BY po.ProductOrderID";
		        PreparedStatement ps6 = conn.prepareStatement(sql6);
		        ResultSet rs6 = ps6.executeQuery();
		        while(rs6.next()) {
		        	ParkingPass pp = new ParkingPass(rs6.getString("ParkingPassCode"),
		        			"Parking Pass",
		        			rs6.getDouble("ParkingPassCost"));
		        	pp.setUnits(rs6.getInt("Quantity"));
		        	int invoiceID = rs6.getInt("InvoiceID");
		        	arrayOfArrays.get(invoiceID-1).add(pp);
		        }
		      //refreshment
		        String sql7 = "SELECT DISTINCT * FROM Invoice i, ProductOrder po, Refreshment r\r\n" + 
		        		"	WHERE po.ProductType = \"Refreshment\" AND i.InvoiceID = po.InvoiceID AND r.RefreshmentID = po.ProductID\r\n" + 
		        		"	GROUP BY po.ProductOrderID";
		        PreparedStatement ps7 = conn.prepareStatement(sql7);
		        ResultSet rs7 = ps7.executeQuery();
		        while(rs7.next()) {
		        	Refreshment r = new Refreshment(rs7.getString("RefreshmentCode"),
		        			"Refreshment",
		        			rs7.getString("RefreshmentName"),
		        			rs7.getDouble("RefreshmentCost"));
		        	r.setUnits(rs7.getInt("Quantity"));
		        	int invoiceID = rs7.getInt("InvoiceID");
		        	arrayOfArrays.get(invoiceID-1).add(r);
		        }
		      //movie ticket
		        String sql8 = "SELECT DISTINCT * FROM Invoice i, ProductOrder po, MovieTicket mt JOIN Address a on mt.AddressID = a.AddressID\r\n" + 
		        		"	JOIN CityZip cz on a.CityZipID = cz.CityZipID\r\n" + 
		        		"	JOIN CountryState cs on a.CountryStateID = cs.CountryStateID\r\n" + 
		        		"	WHERE po.ProductType = \"MovieTicket\" AND i.InvoiceID = po.InvoiceID AND mt.MovieTicketID = po.ProductID\r\n" + 
		        		"	GROUP BY po.ProductOrderID";
		        PreparedStatement ps8 = conn.prepareStatement(sql8);
		        ResultSet rs8 = ps8.executeQuery();

				Format formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		        
		        while(rs8.next()) {

					String date = formatter.format(rs8.getDate("DayAndTime"));
					Address a= new Address(rs8.getString("Street"), 
							rs8.getString("CityName"), rs8.getString("StateName"), 
							rs8.getString("ZipCode"), rs8.getString("CountryName"));
		        	MovieTicket mt = new MovieTicket(rs8.getString("MovieCode"),
		        			"MovieTicket",
		        			date,
		        			rs8.getString("MovieTitle"),
		        			a, rs8.getString("Screen"),
		        			rs8.getDouble("MovieTicketCost"));
		        	mt.setUnits(rs8.getInt("Quantity"));
		        	int invoiceID = rs8.getInt("InvoiceID");
		        	arrayOfArrays.get(invoiceID-1).add(mt);
		        }
	        	
	        	
	        	
	        	
				stmt = conn.createStatement();
				String sql;
				sql = "SELECT p.PersonID, InvoiceID, InvoiceCode, p.PersonCode, p.FirstName, p.LastName, p2.FirstName as \"7\", p2.LastName as \"8\", p2.PersonCode as \"9\",\r\n" + 
						"		cz.Street as \"1\", cz.CityName as \"2\", cs.StateName as \"3\", cz.ZipCode as \"4\", \r\n" + 
						"		cs.CountryName as \"5\", p2.PersonID as \"6\", DateOfPurchase, CustomerCode, CustomerType, \r\n" + 
						"		CompanyName, cz2.Street, cz2.CityName, cs2.StateName, cz2.ZipCode, cs2.CountryName\r\n" + 
						"	FROM Invoice i inner join Customers c on i.CustomerID = c.CustomerID\r\n" + 
						"	INNER JOIN CustomerPersons cp ON c.CustomerID = cp.CustomerID\r\n" + 
						"	INNER JOIN Persons p on cp.PersonID = p.PersonID\r\n" + 
						"	INNER JOIN Address a on p.AddressID = a.AddressID\r\n" + 
						"	INNER JOIN CityZip cz on a.CityZipID = cz.CityZipID\r\n" + 
						"	INNER JOIN CountryState cs on a.CountryStateID = cs.CountryStateID\r\n" + 
						"	JOIN Address a2 on c.AddressID = a2.AddressID\r\n" + 
						"	JOIN CityZip cz2 on a2.CityZipID = cz2.CityZipID\r\n" + 
						"	JOIN CountryState cs2 on a2.CountryStateID = cs2.CountryStateID\r\n" + 
						"	JOIN Persons p2 on i.SalePerson = p2.PersonID\r\n" + 
						"	ORDER BY InvoiceCode";
				ps = conn.prepareStatement(sql);
				//ps.set //to address any "?"'s
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					int personID = rs.getInt("PersonID");
					PreparedStatement ps2 = null;
					ArrayList<String> emails = new ArrayList<String>();
					ArrayList<String> emailsForSalesperson = new ArrayList<String>();
						String sql2;
						sql2 = "SELECT Email FROM Email WHERE Email.PersonID = ?";
						ps2 = conn.prepareStatement(sql2);
						ps2.setInt(1, personID);
						ResultSet rs2 = ps2.executeQuery();
						while(rs2.next()) {
							String email = rs2.getString("Email");
							emails.add(email);
						}
					
					//now we have an array of emails for this invoice's customer's contactperson
						String customerCode = rs.getString("CustomerCode");
						String customerType = rs.getString("CustomerType");
						String name = rs.getString("CompanyName");
						Customer customer = null;
						Address address = new Address(rs.getString("Street"), rs.getString("CityName"), rs.getString("StateName"), rs.getString("ZipCode"), rs.getString("CountryName"));
				        Person contactPerson = new Person(rs.getString("PersonCode"),
				        		rs.getString("FirstName"),
				        		rs.getString("LastName"),
				        		new Address(rs.getString("1"), 
				        				rs.getString("2"), 
				        				rs.getString("3"), 
				        				rs.getString("4"), 
				        				rs.getString("5")));
				        contactPerson.setEmail(emails);
				        String type = rs.getString("CustomerType");
				        if(type.equals("General")) {
					        customer = new General(customerCode,
					        		customerType,
					        		contactPerson, name,
					        		address);
				        }else {
				        	 customer = new Student(customerCode,
						        		customerType,
						        		contactPerson, name,
						        		address);
				        }
				        PreparedStatement ps3 = null;
				      		String sql3;
							sql3 = "SELECT Email FROM Email WHERE Email.PersonID = ?";
							ps3 = conn.prepareStatement(sql3);
							int salespersonID = rs.getInt("6");
							ps3.setInt(1, salespersonID);
							ResultSet rs3 = ps3.executeQuery();
							while(rs3.next()) {
								String email = rs3.getString("Email");
								emailsForSalesperson.add(email);
							}
						
				        Person salesPerson = new Person(rs.getString("9"),
								rs.getString("7"), rs.getString("8"),
								new Address(rs.getString("Street"),
										rs.getString("CityName"),
										rs.getString("StateName"),
										rs.getString("ZipCode"),
										rs.getString("CountryName")));
						salesPerson.setEmail(emailsForSalesperson);
						String date = formatter.format(rs.getDate("DateOfPurchase"));
				        
				        Invoice invoice = new Invoice(rs.getString("InvoiceCode"),
				        		customer, salesPerson, date);
				        
				        
				        
				        
				        
				        
				        //add product list to invoice
				        invoice.setProductList(arrayOfArrays.get(invoiceCount));
				        
				        //add invoice to invoice list
				        invoiceCount++;
				        invoiceList.add(invoice);			        
				  
				}
			}
			//handle exceptions
			catch(SQLException se){
	            //Handle errors for JDBC
	            se.printStackTrace();
	         }catch(Exception e){
	           //Handle errors for Class.forName
	           e.printStackTrace();
	         }finally{
	           //finally block used to close resources
	           try{
	              if(stmt != null)
	                 stmt.close();
	           }catch(SQLException se2){
	           }// nothing we can do
	           try{
	              if(conn != null)
	                 conn.close();
	           }catch(SQLException se){
	               se.printStackTrace();
	           }//end finally try
	        }
			
			return invoiceList;
		}
	
}
