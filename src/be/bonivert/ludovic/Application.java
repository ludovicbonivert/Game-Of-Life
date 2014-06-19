package be.bonivert.ludovic;
import java.util.ArrayList;
import processing.core.*;

/** Game of Life main class **/

public class Application extends PApplet{
	/** Basic setup :
	 * -Size of window
	 * -Background init
	 * -ArrayList init
	 * -stroke of lines
	 * **/
	public void setup() {
	    size(400,400);
	    background(255);
	    ArrayList<Cell> myCells = new ArrayList<Cell>();
	    stroke(0);
	  }
	/** 
	 * Draw method : where the magic happens
	 * **/
	  public void draw() {
		  // Making of the grid. One rect is 10x10
		  for(int i = 0; i < 400; i+=10){
			  line(0, i, 400, i);
			  line(i, 0, i, 400);
		  };
		  
		  // If the cell is dead give it a red color
		  fill(253, 69, 69);
		  rect(80, 70, 10, 10);
		  // If the cell is alive giv it a green color
		  fill(155, 253, 69);
		  rect(50, 60, 10, 10);
	  }
}
