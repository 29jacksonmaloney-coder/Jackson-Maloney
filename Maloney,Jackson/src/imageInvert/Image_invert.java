package imageInvert;

import processing.core.PApplet;
import processing.core.PImage;

public class Image_invert extends PApplet {

	  private static final int MAX_COLOR = 255;

		private final String IMAGE_PATH = "media/pngimg.com - mars_planet_PNG38.png";

	    private PImage picture;

	public static void main(String[] args) {
	
		 PApplet.main("imageInvert.Image_invert");
    }

    public void settings()
    {
        size(600, 640);
    }

    public void setup()
    {
        noLoop();
        picture = loadImage(IMAGE_PATH);
    }

    public void draw()
    {
        image(picture, 0, 0);
    }

    public void mousePressed()
    {
        invertImage();
        redraw();
        
    }

    public void keyPressed()
    {
        picture.save("media/inverted.png");
        
    }
    public int invertPixel(int originalPixel)
    {
    	 invertImage();
        return color(blue(originalPixel), red(originalPixel), green(originalPixel));
     
    }

    public void invertImage()
    {
        for(int x = 0; x < picture.width; x++)
        {
            for(int y = 0; y < picture.height; y++)
            {
            	int pixel = picture.get(x, y);
          	 float newRed = MAX_COLOR - red(pixel);
          	float newGreen = MAX_COLOR - green(pixel);
          	float newBlue = MAX_COLOR - blue(pixel);
          	 int newColor = red(newRed);  green(newGreen);  blue(newBlue);
          	 picture.set(x, y, color(picture.get(x, y)));
            }
        }
    }
            
                                                                   
        }
    	                                                        

	

	                                                           