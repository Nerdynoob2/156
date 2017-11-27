import java.time.LocalDate;

public class MovieTicket extends Ticket {

	private String dateTime;
	private String movieName;
	private Address address;
	private String screenNumber;
	private double pricePerUnit;

	// Constructor
	public MovieTicket(String productCode, String productType, 
			String dateTime, String movieName, Address address,
			String screenNumber, double pricePerUnit) {
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

	public void setPricePerUnit(double pricePerUnit) {
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

	public double getPricePerUnit() {
		return this.pricePerUnit;
	}

	
	public int discount() {

		
		String temp[] = this.getDateTime().split(" ");
		//"delete" the time, split into necessary data
		String data[] = temp[0].split("-");
		int year = Integer.parseInt(data[0]);
		int month = Integer.parseInt(data[1]);
		int date = Integer.parseInt(data[2]);
		
		LocalDate movieDate = LocalDate.of(year, month, date);
		
		
		if (movieDate.getDayOfWeek().name() == "TUESDAY" || movieDate.getDayOfWeek().name() == "THURSDAY"){
			return 1;
		}
		else {
			return 0;
		}

	}
	
	
	@Override
	public double getSubtotal(String currentDate) {
		if (this.discountCheck()) {
			return this.pricePerUnit * .93 * this.getUnits();			
		}
		else if(!this.discountCheck()){
			return this.pricePerUnit * this.getUnits();			
		} else return 50000000;
	}
	
	public Boolean discountCheck(){
		if(this.discount()==1){
			return true;
		}
		return false;
	}


	@Override
	public double getTax(String currentDate) {
		return this.getSubtotal(currentDate) * .06;
	}


	@Override
	public double getTotal(String currentDate) {
		return this.getSubtotal(currentDate) + this.getTax(currentDate);
	}
	
	public MovieTicket returnItself() {
		return this;
	}
	
	
}
