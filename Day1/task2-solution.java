import java.util.Random;
import java.util.Scanner;

public class Main {

	private static Scanner scanner;

	public static void main(String[] args) {

		char[] initNum = initNum();
		boolean isAssumptionRight = false;

		while (!isAssumptionRight) {
			scanner = new Scanner(System.in);

			char[] userInput = input(scanner.nextLine());
			String gameAnswer = gameAnswer(userInput, initNum);

			System.out.println(gameAnswer);
			if (gameAnswer.charAt(15) == '4')
				isAssumptionRight = true;
		}
	}

	private static char[] initNum() {
		// generate random number for PC participant
		char[] values = {'0', '1', '2', '3', '4', '5',
				'6', '7', '8', '9'};
		char[] answer = new char[4];
		
		int countReady = 0;
		
		while(countReady != 4) {
			int tempChar = rndChar();
			if(values[tempChar] != 'x') {
				answer[countReady] = values[tempChar];
				values[tempChar] = 'x';
				countReady++;
			}
		}
		
		return answer;
	}

	private static char rndChar() {
		// get random char from 0 to 9
		Random rnd = new Random();
		return (char)rnd.nextInt(10);
	}
	
	private static char[] input(String string) {
		// get first 4 symbols from string
		char[] result = new char[4];
		for (int i = 0; i < 4; i++)
			result[i] = string.charAt(i);
		return result;
	}

	private static String gameAnswer(char[] userInput, char[] initNum) {
		// check for bulls and cows and return printable answer
		int bulls = 0;
		int cows = 0;

		// check for bulls
		for (int i = 0; i < 4; i++) {
			if (userInput[i] == initNum[i])
				bulls++;
		}

		// check for cows
		for (int i = 0; i < 4; i++) {
			for(int k = 0; k < 4; k++) {
				if((userInput[i] == initNum[k]) && (i != k))
					cows++;
			}
		}

		// generate answer
		String anwser = new String(userInput);
		anwser = anwser + " --> bulls:" + bulls + " cows:" + cows;
		return anwser;
	}
}
