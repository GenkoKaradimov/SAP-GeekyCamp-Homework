package startup;

import inmemory.file.system.FileSystem;
import io.console.ConsoleFramework;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileSystem imfs = new FileSystem();
		ConsoleFramework cf = new ConsoleFramework(imfs);
		
		while(cf.isActive()) {
			cf.userInput();
		}
	}

}
