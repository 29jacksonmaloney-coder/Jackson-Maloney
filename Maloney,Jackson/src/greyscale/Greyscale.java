package greyscale;

import processing.core.PApplet;
import processing.core.PImage;

public class Greyscale extends PApplet {
	
	private PImage picture;
	
	public static void main(String[] args) {
		
		 PApplet.main("greyscale.Greyscale");
    }

    public void settings()
    {
        size(600, 640);
    }

    public void setup()
    {
        noLoop();
        picture = loadImage("media/pngimg.com - mars_planet_PNG38.png");
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

                   float average = (red(pixel) + green(pixel) + blue(pixel));
         int newcolor = color (average / 3);
          int color = color (red(newcolor) , green(newcolor) , blue(newcolor));
                   picture.set(x, y, color );
      
            }
        }
    }
}
    
 