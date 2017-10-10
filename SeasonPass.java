
public class SeasonPass extends Ticket{

		// TODO Auto-generated constructor stub
	

	private String name;
	private String startDate;
	private String endDate;
	private String cost;

	// Constructor
	public SeasonPass(String productCode, String productType, String name, String startDate, String endDate, String cost){
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

	public void setCost(String cost) {
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

	public String getCost() {
		return this.cost;
	}
	//fixed cost based on season
	//if before, fixed price
	// TODO if between certain dates, discount based on days remaining until end (in subtotal)
	//if after, error
	//$8 processing fee per unit

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
}