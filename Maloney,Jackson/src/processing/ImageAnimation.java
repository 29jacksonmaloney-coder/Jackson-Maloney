package processing;

import processing.core.PApplet;

public class ImageAnimation extends PApplet {

	
	
	public static void main(String[] args) {
		
		 PApplet.main("processing.ImageAnimation");
		
	}
	
	 public void settings()
	    {
	        size(1000, 1000);
	    }

	    public void setup()
	    {
	      
	    }

	    public void draw()
	    {
	    	
	    	background(66,224,255);
	    	fill(100, 122, 122);
	    	triangle(980, 515, 750, 575, 750, 450);
	    	fill(100, 122, 122);
	    	rect(200, 450, 550, 125);
	    	fill(100, 122, 122);                 //Top Wing
	    	triangle(400, 400, 400, 90, 650, 400);
	    	fill(100, 122, 122);
	    	rect(400, 400, 300, 50);
	    	fill(100, 122, 122);
	    	triangle(700, 400, 700, 450, 750, 450); // End Top wing
	    	fill(100, 122, 122);                       //Bottom wing
	    	triangle(400, 625, 400, 925, 650, 625);
	    	fill(100, 122, 122);
	    	rect(400, 575, 300, 50);
	    	fill(100, 122, 122);
	    	triangle(700, 575, 700, 625, 750, 575);  // End Bottom wing
	    	triangle(215, 575, 215, 625, 265, 575); // Bottom tail wing
	    	rect(200, 575, 15, 50);
	    	triangle(215, 450, 215, 400, 265, 450); // Top tail wing
	    	rect(200, 400, 15, 50);
	    	circle(200, 480, 50);
	    	circle(200, 540, 50);
	    	circle(200, 480, 45);
	    	circle(200, 540, 45);
	    	
	    	
}
}



