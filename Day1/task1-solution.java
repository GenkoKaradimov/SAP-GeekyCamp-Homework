import java.util.Scanner;

public class Main {

	private static Scanner scanner;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split(" ");

		String S = input[0];
		String P = RemoveFirst(input[1]);
		
		System.out.println(isMatching(S, P));
	}
	
	private static boolean isMatching(String S, String P) {
		if(S.length() < P.length())
			return false;
		
		for(int i = 0; i <= S.length() - P.length(); i++) {
			if(areEquals(partString(S, i, i + P.length()), P)) {
				return true;
			}
		}
		
		return false;
	}
	
	private static String partString(String Str, int first, int last) {
		String x =  Str.substring(first, last);
		return x;
	}
	
	private static boolean areEquals(String S, String P) {
		for(int i = 0; i < S.length();i++) {
			if((S.charAt(i) != P.charAt(i))&&(P.charAt(i) != '?')&&(P.charAt(i) != '*'))
				return false;
		}
		return true;
	}
	
	private static String RemoveFirst(String P) {
		// if P start with '*' remove it 
		if(P.charAt(0) == '*') {
			return RemoveFirst(P.substring(1));
		}
		else return P;
	}
}
