
public class SeasonPass extends Product {

		// TODO Auto-generated constructor stub
	
	private String productCode;
	private String productType;
	private String name;
	private String startDate;
	private String endDate;
	private String cost;

	// Constructor
	public SeasonPass(String productCode, String productType, String name, String startDate, String endDate, String cost){
		super(productCode, productType);
		this.productCode = productCode;
		this.productType = productType;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
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
	public String getProductCode() {
		return this.productCode;
	}

	public String getProductType() {
		return this.productType;
	}

	public String getName() {
		return this.name;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public String setEndDate() {
		return this.endDate;
	}

	public String getCost() {
		return this.cost;
	}

	// other methods

}