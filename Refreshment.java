
public class Refreshment extends Service{

	private String name;
	private double cost;

	// Constructor
	public Refreshment(String productCode, String productType, String name, double cost) {
		super(productCode, productType);
		this.name = name;
		this.cost = cost;
	}

	
	// setters
	public void setName(String name) {
		this.name = name;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	
	// getters
	public String getName() {
		return this.name;
	}

	public double getCost() {
		return this.cost;
	}


	@Override
	public double getSubtotal(String currentDate) {
		return this.cost;
	}


	@Override
	public double getTax(String currentDate) {
		return this.cost * .04;
	}


	@Override
	public double getTotal(String currentDate) {
		return this.getSubtotal(currentDate) + this.getTax(currentDate);
	}
	
	
	
	@Override
	public Refreshment returnItself() {
		return this;
	}
	
	
	
}
