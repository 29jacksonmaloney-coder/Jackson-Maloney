 package beatuptherat;

import processing.core.PApplet;

public class Main_controls extends PApplet  {
	


	  private final int UPDATE_DELAY = 20;

	    private int centerX, centerY, diameter;

	    private boolean rightArrowPressed, downArrowPressed, leftArrowPressed, upArrowPressed;
	    private int timeOfNextUpdate;

	
	public static void main(String[] args) {
		
		Healthtracker myHealthtracker = new Healthtracker();
	
		 PApplet.main("beatuptherat.Beatuptherat");
		
	} public void settings()
		    {
		        size(1000, 1000);
		    }

		    public void setup()
		    {
		    	 rightArrowPressed = false;
		         downArrowPressed = false;
		         leftArrowPressed = false;
		         upArrowPressed = false;

		         timeOfNextUpdate = millis() + UPDATE_DELAY;
		    }

		    public void draw()
		    {
		    	  background(0);
                      rect(24, 200, 30, 50);
		    }
		    

		    public void keyPressed()
		    {
		    	  if(millis() >= timeOfNextUpdate)
		          {
		              if(rightArrowPressed)
		                  centerX++;

		              if(downArrowPressed)
		                  centerY--;
		              
		              if(leftArrowPressed)
		                  centerX--;
		              
		              if(upArrowPressed)
		                  centerY++;

		              timeOfNextUpdate = millis() + UPDATE_DELAY; }
		    }
		     myHealthtracker.DisplayMessage();
		     {
		    	 
		     }
		    	
		    }


	


