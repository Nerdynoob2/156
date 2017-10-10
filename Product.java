
public abstract class Product {
	private String productCode;
	private String productType;
	private int units;

	public Product(){}
	
	// Constructor
	public Product(String productCode, String productType) {
		this.productCode = productCode;
		this.productType = productType;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	// getters and setters
	public void setProductCode(String productCode){
		this.productCode = productCode;
	}
	public String getProductCode(){
		return this.productCode;
	}
	
	public void setProductType(String productType){
		this.productType = productType;
	}
	public String getProductType(){
		return this.productType;
	}
	// abstract methods

	// TODO calculate and return subtotal (takes current date as argument)
	public abstract double getSubtotal(String currentDate);
	// TODO calculate and return tax rate
	public abstract double getTaxRate();
	//TODO calculate and return total (subtotal plus tax)
	public abstract double getTotal(String currentDate);
}