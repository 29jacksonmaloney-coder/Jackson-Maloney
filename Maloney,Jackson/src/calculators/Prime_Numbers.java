package calculators;



public class Prime_Numbers {

	public static void main(String[] args) {
		
 Prime_Numbers em = new Prime_Numbers();
 em.notMain(); 
		      
		     }
			  public void notMain()
			    {
			       isPrime(15);
			      
			    }

				public boolean isPrime(int num)
				{
					int num_a = 3;
					int num_b = 2 ;
					 num = num_a + num_b ;
					 boolean prime_num = false;
					 
					
				    if(num != 2 && num % 2 == 0)
				    {
				    	prime_num = false ;
				    	 System.out.println("Prime Number = " + prime_num);
				        return false;
				    }

				    for(int possibleFactor = 3; possibleFactor < num; possibleFactor += 2)
				    {
				        if(num % possibleFactor == 0)
				        {
				        	prime_num = false ;
				        	 System.out.println("Prime Number = " + prime_num);
				            return false;
				           
				            
				        }
				       
				    }
				    prime_num = true ;
				    System.out.println("Prime Number = " + prime_num);
				    return true;
				
				   
				   
				}
		    }
      



