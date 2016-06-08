package services;

public class CommandService {
	
	public void execute(String command){
		String[] createParkingCommand = command.split( " ");
		if(command == null || command.length() <= 0){
			return ;
		}
	}
}
