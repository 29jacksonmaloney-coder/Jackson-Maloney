package procedures;

public class Counting_procedures {

	public static void main(String[] args) {
		
		 // Replace EasyProcedures with the class name (both sides).
        Counting_procedures em = new Counting_procedures();
        em.notMain();
    }

    public void notMain()
    {
        // Call your procedures here.
        isPrime(54);
       
    }
     

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
   
    	
    	
    }
    

