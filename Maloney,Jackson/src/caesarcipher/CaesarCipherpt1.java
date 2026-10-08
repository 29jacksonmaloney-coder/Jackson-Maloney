package caesarcipher;

public class CaesarCipherpt1 {

	public static void main(String[] args) {
		
		int key = 24;
		char letter = 'J';
		 int unicode = letter;
		 int otherunicode = unicode+key;
		 char otherletter = (char) otherunicode;
		 System.out.println("Original Letter : " + letter);
		 System.out.println("Original Askey Number : " + unicode);
		System.out.println("Key : "+key);
        System.out.println("New Askey Number : " + otherunicode);
        System.out.println(" New Letter : " + otherletter);
	}

}
