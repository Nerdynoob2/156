
public class ParkingPass extends Product {
	private String productCode;
	private String productType;	
	private String parkingFee;

	// Constructor
	public ParkingPass(String productCode, String productType, String parkingFee) {
		super(productCode, productType);
		this.productCode = productCode;
		this.productType = productType;
		this.parkingFee = parkingFee;
	}

	
	// setters
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public void setParkingFee(String parkingFee) {
		this.parkingFee = parkingFee;
	}

	
	// getters
	public String getProductCode() {
		return this.productCode;
	}

	public String getProductType() {
		return this.productType;
	}
	
	public String getParkingFee() {
		return this.parkingFee;
	}
}
