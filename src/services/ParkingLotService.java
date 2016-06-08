package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import app.ParkingLot;
import app.Vehicle;

public class ParkingLotService {
	
	CommandService commandService = new CommandService();
	
	public static void main(String[] args) {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     try {
	    	 String line = null;
	    	 while(line == null || !line.equalsIgnoreCase("exit"))
			= br.readLine();
			String[] createParkingCommand = line.split( " ");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
