package services;

import java.util.List;

import app.ParkingLot;
import app.Vehicle;
import enums.Commands;
import enums.ErrorCode;

public class CommandService {
	
	private static ParkingLot parkingLot = null;
	
	public ErrorCode execute(String commandString){
		List<Vehicle> vehicles = null;
		if(commandString == null || commandString.length() <= 0){
			return ErrorCode.INVALID_INPUT;
		}
		String[] commandArray = commandString.split( " ");
		Commands command = Commands.getCommand(commandArray[0]);
		if(command == null || command.getArguments() != commandArray.length){
			return ErrorCode.INVALID_INPUT;
		}
		if(!Commands.CREATE_PARKING_LOT.equals(command) && parkingLot == null){
			return ErrorCode.PARKING_NOT_INITIALIZED;
		}
		switch (command) {
		case CREATE_PARKING_LOT:
			Integer space = Integer.parseInt(commandArray[1]);
			parkingLot = ParkingLot.getInstance(space);
			System.out.println("Created a parking lot with " + space +" slots");
			break;

		case PARK:
			Vehicle vehicle = new Vehicle(commandArray[1],commandArray[2]);
			Integer p = parkingLot.addVehicleToParking(vehicle);
			if(p != -1){
				System.out.println("Allocated slot number: " + p );
			}else{
				return ErrorCode.PARKING_FULL;
			}
			break;

		case LEAVE:
			Integer id = Integer.parseInt(commandArray[1]);
			if(parkingLot.removeVehicleFromParking(id)){
				System.out.println("Slot number " + id + " is free ");
			}else{
				return ErrorCode.DATA_NOT_FOUND;
			}
			break;
			
		case REGISTRATION_NUMBERS_QUERY_BY_COLOUR:
			vehicles = parkingLot.getVehicleByColor(commandArray[1]);
			if(vehicles == null || vehicles.size() == 0){
				return ErrorCode.DATA_NOT_FOUND;
			}
			showRegistrationNumbers(vehicles);
			break;
			
		case SLOT_NUMBERS_QUERY_BY_COLOUR:
			vehicles = parkingLot.getVehicleByColor(commandArray[1]);
			if(vehicles == null || vehicles.size() == 0){
				return ErrorCode.DATA_NOT_FOUND;
			}
			showSlotNumbers(vehicles);
			break;

		case SLOT_NUMBERS_QUERY_BY_REGISTRATION_NUMBERS:
			vehicles = parkingLot.getVehicleByVehicleNo(commandArray[1]);
			if(vehicles == null || vehicles.size() == 0){
				return ErrorCode.DATA_NOT_FOUND;
			}
			showSlotNumbers(vehicles);
			break;
			
		case STATUS:
			vehicles = parkingLot.getAllVehicles();
			if(vehicles == null || vehicles.size() == 0){
				return ErrorCode.DATA_NOT_FOUND;
			}
			showResult(vehicles);
			break;
		default:
			break;
		}
		return ErrorCode.SUCCESS;
	}
	
	private void showResult(List<Vehicle> vehicles){
		System.out.println("---------------------------------------------------------------------------------------");
		for (Vehicle vehicle : vehicles) {			
			System.out.println(vehicle);		
		}
		System.out.println("---------------------------------------------------------------------------------------");
	}
	
	private void showSlotNumbers(List<Vehicle> vehicles){
		for (Vehicle vehicle : vehicles) {
			System.out.print(vehicle.getParkingSpaceId() + ", " );
		}
		System.out.println();
	}
	
	private void showRegistrationNumbers(List<Vehicle> vehicles){
		for (Vehicle vehicle : vehicles) {
			System.out.print(vehicle.getVehicleNo() + ", " );
		}
		System.out.println();
	}
}
