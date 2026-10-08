package procedures;

public class Procedures_Test {

	public static void main(String[] args) {
		 // Replace EasyProcedures with the class name (both sides).
        Procedures_Test em = new Procedures_Test();
        em.notMain();
    }

    public void notMain()
    {
        // Call your procedures here.
      
        System.out.println(countPrimes(10, 7));
        
    }

    // Write your procedures here.
    // You can delete the sample procedures below (but
    // leave the closing bracket for the class).

    public boolean isPrime(int num)
    {
        if(num != 2 && num % 2 == 0)
        {
        	
            return false;
        }

        for(int possibleFactor = 3; possibleFactor < num; possibleFactor += 2)
        {
            if(num % possibleFactor == 0)
            {
              return false;
            }
        }
        
        return true;
    }
    public int countPrimes(int num1, int num2) {
    	
    	int count = 0 ;
    	
    	if (isPrime(num1)) {
            count++;
        }
        
        if (isPrime(num2)) {
            count++;
        }
        
        return count;
  
}
}
