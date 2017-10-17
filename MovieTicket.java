import java.util.Calendar;
import java.util.GregorianCalendar;

public class MovieTicket extends Ticket {

	private String dateTime;
	private String movieName;
	private Address address;
	private String screenNumber;
	private double pricePerUnit;

	// Constructor
	public MovieTicket(String productCode, String productType, String dateTime, String movieName, Address address,
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

	
	public int discount(String currentDate) {

		
		String data[] = currentDate.split("-");
		
		int year = Integer.parseInt(data[0]);
		int month = Integer.parseInt(data[1]);
		int date = Integer.parseInt(data[2]);
		
		Calendar startDate = new GregorianCalendar(year, month, date, 00, 00, 00);
		
		int dayOfWeek = startDate.get(Calendar.DAY_OF_WEEK);
		
		if (dayOfWeek == 3 || dayOfWeek == 5){
			return 1;
		}
		else {
			return 0;
		}

	}
	
	
	@Override
	public double getSubtotal(String currentDate) {
		if (this.discount(currentDate)==1) {
			return this.pricePerUnit * .93;
		}
		else {
			return this.pricePerUnit;			
		}
	}
	
	public Boolean discountCheck(String currentDate){
		if(this.discount(currentDate)==1){
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
