package be.bonivert.ludovic;
import java.util.ArrayList;
import processing.core.*;

/** Game of Life main class **/
/** Timer from learningprocessing.com (Daniel Shiffman) **/
// Timer is useless at the moment, better without
public class Application extends PApplet{
	
	//Arraylist must be declared outside setup, else we cant access it
	ArrayList<Cell> myCells = new ArrayList<Cell>();
	// Prepare first state of Cells. Randomize is in setup
	int randomX, randomY;
	// Timer, refresh every 1000 (1 sec)
	int refresh = 0;
	int savedTime;
	int myCellsSize;
	
	public void setup() {
		savedTime = millis();
		int height = 400;
		int width = 400;
	    size(height, width);
	    background(255);
	    stroke(0);
	    
	    // Making y number of Cells (in this example 40*40 = 1600 Cells)
	    // 1 cell is 10x10
	    // 390 cells are dead
	    // 10 other are alive
	    int y = 0;
	    int numberOfCells = (height * width) / 100;
	    while(y < numberOfCells){
	    	myCells.add(new Cell(false));
	    	y++;
	    }
	    println(myCells.size());
	    myCellsSize = myCells.size();
	    //Making grid in setup, not in draw because it is continuously redrawed
	    for(int i = 0; i < width; i+=10){
			  line(0, i, width, i);
			  line(i, 0, i, height);
		}
	 // First green fill of living cells
	    fill(155, 253, 69);
	 // Making initial (random) state of Cells
	 // Search 10 times for a random number between 0 and width length
	 // The first 10 cells of myCells are made alive and populate the grid
	    for(int i = 0; i <= 10; i++){
	    	randomX = floor(random(0, (width/10)));
		    randomY = floor(random(0, (height/10)));
		    // Make this numbers * 10 to fit in grid
		    randomX *= 10;
		    randomY *= 10;
		    rect(randomX, randomY, 10, 10);
		    Cell cell = myCells.get(i);
		    cell.alive = true;
		    cell.positionX = randomX;
		    cell.positionY = randomY;
		    //Print the actual position of the first cells
		    println(cell);
	    }
	    
	    
	  }
	
	/** 
	 * Draw method : where the magic happens
	 * **/
	  public void draw() {
		  // Calculates how much time has passed
		  int passedTime = millis() - savedTime;
		  // Has 1 second passed ? 
		/*  if(passedTime > refresh){
			  for(int i = 0; i <= 10; i++){
			    	randomX = floor(random(0, (width/10)));
				    randomY = floor(random(0, (height/10)));
				    // Make this numbers * 10 to fit in grid
				    randomX *= 10;
				    randomY *= 10;
				    rect(randomX, randomY, 10, 10);
			    } 
			  savedTime = millis(); // Save the current time to restart the timer
		  }*/
		  
		  //The other 390 cells must adapt their 'life' in function of the first 10 cells
		  // Actually all the cells must now be updated
		  for(int i = 0; i < myCellsSize; i++){
			  println(myCells.get(i));
			  Cell cell = myCells.get(i);
			  //cell must check for neighbour
			  
		  }
		  // Making of the grid. One rect is 10x10
		  // If the cell is dead give it a red color
		  //fill(253, 69, 69);
		  //rect(80, 70, 10, 10);
		  // If the cell is alive giv it a green color
		  fill(155, 253, 69);
		  rect(randomX, randomY, 10, 10);
	  }
}
