package services;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import enums.ErrorCode;

public class ParkingLotService {
	
	private static CommandService commandService = new CommandService();
	
	public static void main(String[] args) {
		 if(args.length > 1){
			 String fileName = args[1];
		 }
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     String line = null;
		 while(line == null || !line.equalsIgnoreCase("exit")){
			 try {
				 line = br.readLine();
				 ErrorCode error = commandService.execute(line);
				 if(!error.equals(ErrorCode.SUCCESS)){
					 System.out.println(error.getmessage());
				 }
			} catch (Exception e) {
				System.out.println("Invalid command!!!");
				e.printStackTrace();
			}
			 
		 }
	}
}
