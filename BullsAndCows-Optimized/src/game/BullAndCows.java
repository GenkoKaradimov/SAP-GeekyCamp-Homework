package game;

import data.GameType;
import data.Initial;
import iGame.IBullAndCows;

public class BullAndCows implements IBullAndCows {
	private char[] secret;
	private int secretNumberCount;
	private int turns;
	private boolean isActive;
	private GameType gameType;
	
	public BullAndCows(int symbols, GameType gameType) {
		this.turns = 0;
		this.isActive = true;
		this.gameType = gameType;
		if(gameType == GameType.numbers)
			this.secret = Initial.initNumbers(symbols);
		if(gameType == GameType.words)
			this.secret = Initial.initWord(symbols);
		this.secretNumberCount = secret.length;
	}	
	
	public String trySolve(char[] userInput) {
		// validate
		if(!isInputValid(userInput)) {
			return "Input not valid!!!";
		}
		
		// you are noob
		if(this.turns >= 100) {
			return "You are noob!!!";
		}
		
		char[] initNum = this.secret;
		
		// check for bulls and cows and return printable answer
				int bulls = 0;
				int cows = 0;

				// check for bulls and cows
				for (int i = 0; i < this.secretNumberCount; i++) {
					for(int k = 0; k < this.secretNumberCount; k++) {
						if(userInput[i] == initNum[k]) {
							if(i == k) {
								bulls++;
							}else {
								cows++;
							}
						}
					}
				}

				if(bulls == this.secretNumberCount) {
					this.isActive = false;
				}
				
				// generate answer
				StringBuilder anwser = new StringBuilder();
				anwser.append(userInput);
				anwser.append(" --> bulls:");
				anwser.append(bulls);
				anwser.append(" cows:");
				anwser.append(cows);				

				return anwser.toString();
	}
	
	public boolean isActive() {
		return this.isActive;
	}
	
	private boolean isInputValid(char[] input) {
		if(this.secretNumberCount != input.length) {
			return false;
		}
		
		if(this.gameType == GameType.numbers) {
			for(int i = 0; i < this.secretNumberCount; i++) {
				if(!Character.isDigit(input[i])) {
					return false;
				}
			}
		}
		
		if(this.gameType == GameType.words) {
			for(int i = 0; i < this.secretNumberCount; i++) {
				if(!Character.isAlphabetic(input[i])) {
					return false;
				}
			}
		}
		
		return true;
	}
}
