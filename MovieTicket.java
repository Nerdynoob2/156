
public class MovieTicket extends Ticket {

	private String dateTime;
	private String movieName;
	private Address address;
	private String screenNumber;
	private String pricePerUnit;

	// Constructor
	public MovieTicket(String productCode, String productType, String dateTime, String movieName, Address address,
			String screenNumber, String pricePerUnit) {
		super(productCode, productType);
		this.dateTime = dateTime;
		this.movieName = movieName;
		this.address = address;
		this.screenNumber = screenNumber;
		this.pricePerUnit = pricePerUnit;
	}

	
	// setters
	
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setScreenNumber(String screenNumber) {
		this.screenNumber = screenNumber;
	}

	public void setPricePerUnit(String pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	
	// getters
	public String getDateTime() {
		return this.dateTime;
	}

	public String getMovieName() {
		return this.movieName;
	}

	public Address getAddress() {
		return this.address;
	}

	public String getScreenNumber() {
		return this.screenNumber;
	}

	public String getPricePerUnit() {
		return this.pricePerUnit;
	}


	@Override
	public double getSubtotal(String currentDate) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public double getTaxRate() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public double getTotal(String currentDate) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//TODO discount on certain days
	//priceperunit*units
}
