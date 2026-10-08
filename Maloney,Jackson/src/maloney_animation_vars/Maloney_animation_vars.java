package maloney_animation_vars;

import processing.core.PApplet;

public class Maloney_animation_vars extends PApplet {

	 private int ballX;
	 private int bally;
	 private int rectX;
	 private int recty;
	 private int speedX;
	 private int speedY;
	
	public static void main(String[] args) {
		
		PApplet.main("maloney_animation_vars.Maloney_animation_vars");
	}
	  public void settings()
	    {
	        size(800,800);
	    }

	    public void setup()
	    {
	    	ballX = 88;
	    	bally = 88;
	    	rectX = ballX + 20;
	    	recty = bally - 20;
	    	speedX = 5;
	    	speedY = 10;
	    }

	    public void draw()
	    {
	        background(20, 125, 124);

	        ballX += speedX;
            bally += speedY;
            rectX += speedX ;
            recty += speedY ;

	        fill(98, 0, 134);
	        ellipse(ballX, bally, 100, 100);
	        rect(rectX, recty, 100, 100);
	        if (ballX > 750) 
	        	{
	        	speedX = -speedX; 
	        	}
	        if (ballX < 50) 
        	{
        	speedX = -speedX; 
        	}
	        if (bally > 750) 
        	{
        	speedY = -speedY; 
        	}
	        if (bally < 50) 
	        {
	        speedY = -speedY; }
	        {
//          Checking squares location
	        	 if (rectX > 750) 
		        	{
		        	speedX = -speedX; 
		        	}
	        if (rectX < 50) 
    	    {
        	speedX = -speedX; 
    	    }
             if (recty > 750) 
    	    {
         	speedY = -speedY; 
          	}
         if (recty < 50) 
            {
            speedY = -speedY;}
	        }

	        }
	        public void mousePressed()
	    {
	    	ballX = mouseX;
	    }
}









  
    