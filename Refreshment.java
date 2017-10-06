
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
	
	
	//cost. duh
	
	
	
	
}
