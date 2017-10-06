
public class Product {
	private transient String productCode;
	private transient String productType;

	public Product(){}
	
	// Constructor
	public Product(String productCode, String productType) {
		this.productCode = productCode;
		this.productType = productType;
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
	// other methods
}