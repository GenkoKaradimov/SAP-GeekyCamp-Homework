package data;

import java.util.Random;

public class Initial {
	public static char[] initNumbers(int count) {
		// generate random number for PC participant
				char[] values = {'0', '1', '2', '3', '4', '5',
						'6', '7', '8', '9'};
				char[] answer = new char[count];
				
				int countReady = 0;
				
				while(countReady != count) {
					int tempChar = rndNum(10);
					if(values[tempChar] != 'x') {
						answer[countReady] = values[tempChar];
						values[tempChar] = 'x';
						countReady++;
					}
				}
				
				return answer;
	}
	
	public static char[] initWord(int count) {
		// generate random number for PC participant
		char[] values = {'q', 'w', 'e', 'r', 't',
				'y', 'u', 'i', 'o', 'p',
				'a', 's', 'd', 'f', 'g',
				'h', 'j', 'k', 'l', 'z',
				'x', 'c', 'v', 'b', 'n', 'm'};
		char[] answer = new char[count];
		
		int countReady = 0;
		
		while(countReady != count) {
			int tempChar = rndNum(26);
			if(values[tempChar] != '0') {
				answer[countReady] = values[tempChar];
				values[tempChar] = '0';				
				countReady++;
			}
		}
		
		return answer;
	}
	
	private static int rndNum(int max) {
		// get random char from 0 to max
		Random rnd = new Random();
		return rnd.nextInt(max);
	}
}
