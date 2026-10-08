
package test;


public class Javatest {

  public static void main(String[] args) {

	String firstinitial = "J";
	String secondinitial = "M";
	
	int unicode = firstinitial.charAt(0);
	int secondunicode = secondinitial.charAt(0);
	
	int otherunicode = unicode;
			int secondotherunicode = secondunicode;
			
			char otherletter = (char) otherunicode;
			char secondotherletter = (char) secondotherunicode;
			
			System.out.println("First Initial : " + firstinitial);
			System.out.println("Last Initial : " + secondinitial);
			System.out.println("ASCII of First Initial : " + otherletter);
			System.out.println("ASCII of Last Initial : " + secondotherletter);
	    }
}

	    


	
	    
	    
