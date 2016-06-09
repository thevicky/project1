package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParkingLot {
	private Integer maxSpace;
	private HashMap<Integer,Vehicle> vehicles = new HashMap<Integer, Vehicle>();
	private Set<Integer> emptySpaces = new HashSet<Integer>();
	
	private static ParkingLot parkingLot = null;
	
	public ParkingLot(Integer space) {
		this.maxSpace = space;
		for (int i = 1; i <= maxSpace; i++) {
			emptySpaces.add(i);
		}
	}

	public int getEmptySpaces() {
		return emptySpaces.size() + 1;
	}

	public Vehicle getVehicleFromSpace(Integer id) {
		return vehicles.get(id);
	}
	
	public List<Vehicle> getVehicleByColor(String color) {
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		if(color == null || color.length() <=0){
			return vehicleList;
		}
		for (Vehicle vehicle : vehicles.values()) {
			if(vehicle.getVehicleColor() != null && vehicle.getVehicleColor().equals(color)){
				vehicleList.add(vehicle);
			}
		}
		return vehicleList;
	}
	
	public List<Vehicle> getVehicleByVehicleNo(String vehicleNo) {
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		if(vehicleNo == null || vehicleNo.length() <=0){
			return vehicleList;
		}
		for (Vehicle vehicle : vehicles.values()) {
			if(vehicle.getVehicleNo() != null && vehicle.getVehicleNo().equals(vehicleNo)){
				vehicleList.add(vehicle);
			}
		}
		return vehicleList;
	}
	
	public Integer addVehicleToParking(Vehicle vehicle){
		if(emptySpaces.isEmpty()){
			return -1;
		}else{
			Integer newLotId = emptySpaces.iterator().next();
			System.out.println(">>>" + newLotId);
			vehicle.setParkingSpaceId(newLotId);
			vehicles.put(newLotId, vehicle);
			emptySpaces.remove(newLotId);
			return newLotId;
		}
	}
	
	public boolean removeVehicleFromParking(Integer id){
		if(id > maxSpace || id <= 0){
			return false;
		}else{
			vehicles.remove(id);
			emptySpaces.add(id);
			return true;
		}
	}
	
	public static ParkingLot getInstance(Integer space){
		if(parkingLot == null){
			parkingLot = new ParkingLot(space);
		}
		return parkingLot;
	}
	
	public List<Vehicle> getAllVehicles() {
		List<Vehicle> v = new ArrayList<Vehicle>();
		for (Vehicle vehicle : vehicles.values()) {
			v.add(vehicle);
		}
		return v;
	}
}
