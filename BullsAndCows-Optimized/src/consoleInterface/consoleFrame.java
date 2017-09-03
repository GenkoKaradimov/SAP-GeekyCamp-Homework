package consoleInterface;

import java.util.Scanner;

import data.GameType;

public class consoleFrame {

	private static Scanner scanner;
	
	public static GameType askUserForGame() {
		System.out.println("Please, choose you game type of bulls and cows");
		System.out.println("1 -> Play with numbers");
		System.out.println("2 -> Play with word");
		
		scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		
		if(userInput.charAt(0) == '1')
			return GameType.numbers;
		
		if(userInput.charAt(0) == '2')
			return GameType.words;
		
		return GameType.numbers; // default
	}
	
	public static int askUserForNumbersCount() {
		scanner = new Scanner(System.in);
		int count = 0;
		
		System.out.print("Choose numbers(1 to 10) of secret num/word:");
		do {
			String userInput = scanner.nextLine();
			count = Integer.parseInt(userInput);
		}while(count < 1 || count >10);
		
		return count;
	}
	
	public static char[] userSolve() {
		scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		
		return userInput.toCharArray();
	}
	
	public static void print(String x) {
		System.out.println(x);
	}
}
