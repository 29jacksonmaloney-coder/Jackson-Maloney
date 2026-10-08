package shapes;



import processing.core.PApplet;



public class RandomShapes extends PApplet {

	public static void main(String[] args)

	{

		 PApplet.main("shapes.RandomShapes");

		 

	}

	public void settings() {

		size(1000,1000);
		
	}

	public void setup() {

		background(0,0,0);
		noLoop();
		
		}
		
	public void draw() {
		
		 for(int n=1; n<=random(1, 10); n++) {
			
			int x1 =(int)random(1, 220);
			int y1 =(int)random(1, 220);
			int x2 =(int)random(1, 220);
			int y2 =(int)random(1, 220);
			
			int blue=(int)(Math.random()*255);

			int green=(int)(Math.random()*255);

			int red=(int)(Math.random()*255);

			fill(red,green,blue);
			
			rect(x1, y1, x2, y2);
		 }
	}
}

	