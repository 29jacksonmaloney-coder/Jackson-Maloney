package calculators;

public class Nj_tax_calculator {

	public static void main(String[] args) {
// Store the bill subtotal in a variable called "subtotal". 
//Calculate the tax as follows: tax = subtotal * .06625
//Add the tax to the subtotal to get the total final bill. 

		double subtotal = 155 ;
		double tax = subtotal*.06625;
		double newsubtotal = tax + subtotal;
		System.out.println("Subtotal: " + subtotal);
		System.out.println("Tax: " + tax);
		System.out.println("Total: " + newsubtotal);
		
	}

}
