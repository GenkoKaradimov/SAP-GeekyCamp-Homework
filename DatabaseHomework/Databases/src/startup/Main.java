package startup;

import java.sql.SQLException;

import database.control.Context;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Context context = new Context();
		
		context.student.all();
	}

}
