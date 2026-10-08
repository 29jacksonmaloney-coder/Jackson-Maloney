package booleans;

public class Q5_booleans {

	public static void main(String[] args) {
		
		int num = (int) (Math.random() * 10);
		System.out.println(num);
		
		if(num <= 5)
		{
		    System.out.println("a");
		    System.out.println("b");
		}
		else if (num <= 8)
		    System.out.println("c");
		else
		    System.out.println("d");

	}

}
