package beatuptherat;

public class Healthtracker {
	

	public static void main(String[] args) {
	
		int player_health = 100 ; 
		int marchand_health = 100;
		int player_energy = 10 ;
	    int marchand_energy = 20 ;
		
	  boolean	 rightArrowPressed = false;  // right hook
	  if (rightArrowPressed == true) {
		  
		  marchand_health -- ;
		  player_health ++;
		  marchand_energy --;
		  player_energy ++;
	  }
	  else {
		  marchand_energy ++;
	  }
	  
  boolean	  downArrowPressed = false; // Liver shot
  if (downArrowPressed == true) {
	  
	  marchand_health = marchand_health - 5 ;
	  player_health = player_health +5 ;
	  marchand_energy = (int) (marchand_energy - 2.5) ;
	  player_energy ++;
	  }
  else {
	  marchand_energy ++;
  }
        boolean  leftArrowPressed = false; // Left hook
        if(leftArrowPressed == true) {
        	
        	marchand_health -- ;
        	player_health ++ ;
        	  marchand_energy --;
    		  player_energy ++;
        	
        }
        else {
        	 marchand_energy ++;
        }
           boolean  upArrowPressed = false; // Knockout punch
           if(upArrowPressed == true) {
        	   
        	   marchand_health = marchand_health - 10 ;
        	   player_health = player_health + 10 ;
        	   marchand_energy = marchand_energy - 4 ;
        	   player_energy = player_energy + 2 ;
           }
           else {
        	   marchand_energy ++;
            }
           if (player_health == 0) {
           }
	
		
		
		
		
		
				

	}

	
}
