package startup;

import java.sql.SQLException;

import console.IO.ConsoleHelp;
import console.IO.UserInput;
import database.control.Context;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Context context = new Context();
		UserInput userInput = new UserInput(context);
		
		ConsoleHelp.printStart();
		
		while(userInput.isActive()) {
			userInput.waitInput();
		}
		
	}

}