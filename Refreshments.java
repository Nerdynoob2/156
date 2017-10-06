
public class Refreshments extends Product {
	private String productCode;
	private String productType;	
	private String name;
	private String cost;

	// Constructor
	public Refreshments(String productCode, String productType, String name, String cost) {
		super(productCode, productType);
		this.productCode = productCode;
		this.productType = productType;
		this.name = name;
		this.cost = cost;
	}

	
	// setters
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	
	// getters
	public String getProductCode() {
		return this.productCode;
	}

	public String getProductType() {
		return this.productType;
	}
	
	public String getName() {
		return this.name;
	}

	public String getCost() {
		return this.cost;
	}
}
