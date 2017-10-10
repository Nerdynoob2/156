
public class Refreshment extends Service{

	private String name;
	private String cost;

	// Constructor
	public Refreshment(String productCode, String productType, String name, String cost) {
		super(productCode, productType);
		this.name = name;
		this.cost = cost;
	}

	
	// setters
	public void setName(String name) {
		this.name = name;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	
	// getters
	public String getName() {
		return this.name;
	}

	public String getCost() {
		return this.cost;
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
	
	
	//cost. duh
	
	
	
	
}
