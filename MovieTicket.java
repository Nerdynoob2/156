
public class MovieTicket extends Product {
	private String productCode;
	private String productType;
	private String dateTime;
	private String movieName;
	private Address address;
	private String screenNumber;
	private String pricePerUnit;

	// Constructor
	public MovieTicket(String productCode, String productType, String dateTime, String movieName, Address address,
			String screenNumber, String pricePerUnit) {
		super(productCode, productType);
		this.productCode = productCode;
		this.productType = productType;
		this.dateTime = dateTime;
		this.movieName = movieName;
		this.address = address;
		this.screenNumber = screenNumber;
		this.pricePerUnit = pricePerUnit;
	}

	
	// setters
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

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
	public String getProductCode() {
		return this.productCode;
	}

	public String getProductType() {
		return this.productType;
	}

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
}
