
public class ParkingPass extends Service{
	
	private String parkingFee;

	// Constructor
	public ParkingPass(String productCode, String productType, String parkingFee) {
		super(productCode, productType);
		this.parkingFee = parkingFee;
	}

	
	// setters
	public void setParkingFee(String parkingFee) {
		this.parkingFee = parkingFee;
	}

	
	// getters
	
	public String getParkingFee() {
		return this.parkingFee;
	}
	
	
	//fixed cost
	
	
}
