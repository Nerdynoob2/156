
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
	
	
	//fixed cost
	
	
}
