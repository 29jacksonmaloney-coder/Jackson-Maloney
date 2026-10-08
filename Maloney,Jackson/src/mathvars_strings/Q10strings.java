package mathvars_strings;

import java.util.Scanner;

public class Q10strings {

	public static <string> void main(String[] args) {
	
	Scanner fromKeyboard = new Scanner(System.in);
	System.out.println("What is your first interger? :");
	int code1 = fromKeyboard.nextInt();
	char letter1 = (char)code1;
	System.out.println(letter1);
	
	System.out.println("What is your next interger? :");
	int code2 = fromKeyboard.nextInt();
	char letter2 = (char)code2;
	System.out.println(letter2);
	fromKeyboard.close();
	String letter = letter1 + "" + letter2;
	
	System.out.println("Initials: "+letter);
	}

}
