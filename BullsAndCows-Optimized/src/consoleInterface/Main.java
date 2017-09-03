package consoleInterface;

import data.GameType;
import game.BullAndCows;
import iGame.IBullAndCows;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GameType gt = consoleFrame.askUserForGame();
		int count = consoleFrame.askUserForNumbersCount();
		
		IBullAndCows game = new BullAndCows(count, gt);
		
		while(game.isActive()) {
			char[] ui = consoleFrame.userSolve();
			consoleFrame.print(game.trySolve(ui));
		}
	}
}
