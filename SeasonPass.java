import java.time.LocalDate;
import java.time.Period;

public class SeasonPass extends Ticket{

		// TODO Auto-generated constructor stub
	
	
	private String name;
	private String startDate;
	private String endDate;
	private double cost;
	
	
	// Constructor
	public SeasonPass(String productCode, String productType, String name, String startDate, String endDate, double cost){
		super(productCode, productType);
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.cost = cost;
}

	// setters
	public void setName(String name) {
		this.name = name;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	
	// getters
	public String getName() {
		return this.name;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public double getCost() {
		return this.cost;
	}
	//fixed cost based on season
	//if before, fixed price
	// TODO if between certain dates, discount based on days remaining until end (in subtotal)
	//if after, error
	//$8 processing fee per unit
	public double prorate(String now) {
		String data[] = now.split("-");
		int year = Integer.parseInt(data[0]);
		int month = Integer.parseInt(data[1]);
		int date = Integer.parseInt(data[2]);
		
		String dataStart[] = this.getStartDate().split("-");
		int yearStart = Integer.parseInt(dataStart[0]);
		int monthStart = Integer.parseInt(dataStart[1]);
		int dateStart = Integer.parseInt(dataStart[2]);
		
		String dataEnd[] = this.getEndDate().split("-");
		int yearEnd = Integer.parseInt(dataEnd[0]);
		int monthEnd = Integer.parseInt(dataEnd[1]);
		int dateEnd = Integer.parseInt(dataEnd[2]);
		
		LocalDate currentDate = LocalDate.of(year, month, date);
		LocalDate startDate = LocalDate.of(yearStart, monthStart, dateStart);
		LocalDate endDate = LocalDate.of(yearEnd, monthEnd, dateEnd);
		
		if(currentDate.isBefore(startDate)) {
			return cost;
		}
		else if(currentDate.isAfter(endDate)) {
			return 999999;
		}
		else {
			Period season = Period.between(startDate, endDate);
			double seasonLength = season.getDays();
			Period timeLeft = Period.between(currentDate, endDate);
			double timeLeftLength = timeLeft.getDays();
			return cost * (timeLeftLength / seasonLength);
		}
	}
	
	
	@Override
	public double getSubtotal(String currentDate) {
		return this.prorate(currentDate);
	}

	@Override
	public double getTax(String currentDate) {
		return this.cost * .06;
	}

	@Override
	public double getTotal(String currentDate) {
		return this.getSubtotal(currentDate) + this.getTax(currentDate);
	}
	@Override
	public SeasonPass returnItself() {
		return this;
	}
}