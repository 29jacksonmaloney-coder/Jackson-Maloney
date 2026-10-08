package maloney_clickyshapes_project;

import processing.core.PApplet;

public class Clickyshapes1 extends PApplet {
	int colorvariable = color(random(1, 256), random(1, 256), random(1, 256));
	int rectvariable = color(random(1, 256), random(1, 256), random(1, 256));
	int trianglevariable = color(random(1, 256), random(1, 256), random(1, 256));
    int backroundvariable = color(random(1, 256), random(1, 256), random(1, 256));
    
	
	public static void main(String[] args) {
		
		PApplet.main("maloney_clickyshapes_project.Clickyshapes1");
	}

	public void settings() 
	{

		size(350, 350);
	}

	public void setup() 
	{
		
	}

	public void draw()
	{
		background(backroundvariable);
		fill(colorvariable);
		rect(100, 250, 60, 70);
		fill(rectvariable);
		rect(20, 40, 50, 75);
		fill(trianglevariable);
		triangle(120, 150, 232, 20, 344, 200);
	}
	
	public void mousePressed()
    {
		if(get(mouseX, mouseY) == colorvariable)
			colorvariable = color(random(1, 256), random(1, 256), random(1, 256));
		     rectvariable = color(random(1, 256), random(1, 256), random(1, 256));
		 trianglevariable = color(random(1, 256), random(1, 256), random(1, 256));
	    backroundvariable = color(random(1, 256), random(1, 256), random(1, 256));
    }
}