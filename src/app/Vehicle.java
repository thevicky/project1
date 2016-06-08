package app;

public class Vehicle {
	private String vehicleNo;
	private String vehicleColor;
	
	public Vehicle(String vehicleNo, String vehicleColor) {
		this.vehicleColor = vehicleColor;
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}
	
}
