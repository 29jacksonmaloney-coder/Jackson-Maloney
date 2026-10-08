package stegonography;

import processing.core.PApplet;
import processing.core.PImage;

public class Stegonography extends PApplet {

	private PImage picture;
	
	public static void main(String[] args) {
		
		PApplet.main("stegonography.Stegonography");
		
	}
	
	 public void settings()
	    {
	        size(480, 640);
	    }

	    public void setup()
	    {
	        noLoop();
	        picture = loadImage("media/grinch.png");
	    }

	    public void draw()
	    {
	        image(picture, 0, 0);
	    }

	    public void mousePressed()
	    {
	        manipulateGetSet();
	        redraw();
	    }

	   
	    public void manipulateGetSet()
	    {
	    	
	    	
	    	   for(int x = 0; x < picture.width; x++)
	           {
	               for(int y = 0; y < picture.height; y++)
	               {
	                   int pixel = picture.get(x, y);

	                   float red_num = (red(pixel));
	     
	                  if (red_num % 2 == 0) {
	                	  
	                int  newcolor = color(0, 0, 0);
	                	picture.set(x, y, newcolor);
	                  }  
	                  else {
	                	  int  newcolor = color(255, 255, 255);
	                	    picture.set(x, y, newcolor);
	                  }     
	                  
	                  
	            }
	        }
	    }

}
