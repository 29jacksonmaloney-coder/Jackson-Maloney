package maloney_animation_vars;

import processing.core.PApplet;

public class animatedCharacter extends PApplet {

	private int puck1x;
	private int puck1y;
	private int puck2x;
	private int puck2y;
	private int puck3x;
	private int puck3y;
	private int speed1x;
	private int speed1y;
	private int speed2x;
	private int speed2y;
	private int speed3x;
	private int speed3y;
	
	public static void main(String[] args) {
	
		PApplet.main("maloney_animation_vars.animatedCharacter");

	}
	 public void settings()
	    {
	        size(1000, 1000);
	    }

	    public void setup()
	    {
	      puck1x = 500;
	      puck1y = 500;
	      puck2x = 700;
	      puck2y = 300;
	      puck3x = 200;
	      puck3y = 700;
	      speed1x = 25;
	      speed1y = 10;
	      speed2x = 20;
	      speed2y = 40;
	      speed3x = 45;
	      speed3y = 20;
	      
	    }

	    public void draw()
	    {
	    	
	    	background(164, 245, 240);
	    	
	    	puck1x += speed1x;
	    	puck1y += speed1y;
	    	puck2x += speed2x;
	    	puck2y += speed2y;
	    	puck3x += speed3x;
	    	puck3y += speed3y;
	    	
	    	 fill(222, 60, 60);
	    	 rect(500, 0, 25, 1000);
	    	 fill(255, 255, 255);
	    	 ellipse(513, 475, 300, 300);
	    	 fill(222, 60, 60);
	    	 rect(500, 300, 25, 350);
	    	ellipse(150, 200, 50, 50);
	    	ellipse(150, 800, 50, 50);
	    	ellipse(850, 800, 50, 50);
	    	ellipse(850, 200, 50, 50);
	    	fill(0, 0, 240);
	    	ellipse(512, 470, 50, 50);
	    	fill(0, 0, 0);
	    	 ellipse(puck1x, puck1y, 15, 15);
	    	 ellipse(puck2x, puck2y, 15, 15);
	    	 ellipse(puck3x, puck3y, 15, 15);
	    	
	    	 
	    	 if (puck1x > 950) {
	    		 
	    		 speed1x = -speed1x;
	    		 
	    	 }
	    	 else if (puck1x < 50) {
	    		 
	    		 speed1x = -speed1x ;
	    		 
	    	 }
	    	 
             if (puck1y > 950) {
	    		 
	    		 speed1y = -speed1y;
	    		 
	    	 }
	    	 else if (puck1y < 50) {
	    		 
	    		 speed1y = -speed1y ;
	    		 
	    	 }
             
             if (puck2x > 950) {
	    		 
	    		 speed2x = -speed2x;
	    		 
	    	 }
	    	 else if (puck2x < 50) {
	    		 
	    		 speed2x = -speed2x ;
	    		 
	    	 }
	    	 
            if (puck2y > 950) {
	    		 
	    		 speed2y = -speed2y;
	    		 
	    	 }
	    	 else if (puck2y < 50) {
	    		 
	    		 speed2y = -speed2y ;
	    		 
	    	 }
	    	 
            if (puck3x > 950) {
	    		 
	    		 speed3x = -speed3x;
	    		 
	    	 }
	    	 else if (puck3x < 50) {
	    		 
	    		 speed3x = -speed3x ;
	    		 
	    	 }
            
            if (puck3y > 950) {
	    		 
	    		 speed3y = -speed3y;
	    		 
	    	 }
	    	 else if (puck3y < 50) {
	    		 
	    		 speed3y = -speed3y ;
	    		 
	    	 }
	    	
}

}
