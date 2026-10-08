package caesarcipher;

public class Caesarcipherpt2 {

	public static void main(String[] args) {
		System.out.println("isLetter expected: true");
        System.out.println("isLetter('a'): " + isLetter('a'));
        System.out.println("isLetter('z'): " + isLetter('z'));
        System.out.println("isLetter('r'): " + isLetter('r'));
        System.out.println("isLetter('A'): " + isLetter('A'));
        System.out.println("isLetter('R'): " + isLetter('R'));

        System.out.println("\nisLetter expected: false");
        System.out.println("isLetter(' '): " + isLetter(' '));
        System.out.println("isLetter('?'): " + isLetter('?'));
        System.out.println("isLetter(';'): " + isLetter(';'));
        System.out.println("isLetter('['): " + isLetter('['));

        System.out.println("\nencryptPhrase(\"Lets go stars!\", 8)");
        System.out.println("expected: Tmba ow abiza!");
        System.out.println("actual  : " + encryptPhrase("Lets go stars!", 8));

        System.out.println("\nencryptPhrase(\"Rangers stink!\", 10)");
        System.out.println("expected: Bkxqobc cdsxu!");
        System.out.println("actual  : " + encryptPhrase("Rangers stink!", 10));

        System.out.println("\nencryptPhrase(\"USA Is Going All The Way!!!\", 19)");
        System.out.println("expected: NLT Bl Zhbgz Tee Max Ptr!!!");
        System.out.println("actual  : " + encryptPhrase("USA Is Going All The Way!!!", 19));

        System.out.println("\nencryptPhrase(\"The Ocean is a surfers safe haven.\", 11)");
        System.out.println("expected: Esp Znply td l dfcqpcd dlqp slgpy.");
        System.out.println("actual  : " + encryptPhrase("The Ocean is a surfers safe haven.", 11));
    }

    public static char encryptLetter(char letter, int key)
    {
        final int LETTERS_IN_ALPHABET = 'z' - 'a' + 1;

        char resultLetter = (char) (letter + (key % LETTERS_IN_ALPHABET));

        char lowerLimit = 'A', upperLimit = 'Z';

        if(letter >= 'a' && letter <= 'z')
        {
            lowerLimit = 'a';
            upperLimit = 'z';
        }

        if(resultLetter < lowerLimit)
            resultLetter = (char) (resultLetter + LETTERS_IN_ALPHABET);
        else if(resultLetter > upperLimit)
            resultLetter = (char) (resultLetter - LETTERS_IN_ALPHABET);

        return resultLetter;
    }

    public static boolean isLetter(char letter)
    {
        // The Character class in the Java library
        // also has methods that do this.

        return (letter >= 'a' && letter <= 'z') ||
                (letter >= 'A' && letter <= 'Z');
    }

    public static String encryptPhrase(String phrase, int key)
    {
        String encryptedMessage = "";

        for(int i = 0; i < phrase.length(); i++)
        {
            if(isLetter(phrase.charAt(i)))
                encryptedMessage += encryptLetter(phrase.charAt(i), key);
            else
                encryptedMessage += phrase.charAt(i);
        }

        return encryptedMessage;
    
	}

}
