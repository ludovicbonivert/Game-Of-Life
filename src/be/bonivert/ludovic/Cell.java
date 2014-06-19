package be.bonivert.ludovic;

/** Cell class **/
public class Cell {
	// A Cell have two possibilities; it is dead or alive.
	private static final int isAlive = 1;
	private static final int isDead = 0;
	public static int positionX;
	public static int positionY;
	
	//Alive can be true or false (alive or dead)
	public Boolean alive;
	
	//Constructor of Cell. The parameter given is true or false (alive or dead)
	public Cell(Boolean alive){
		this.alive = alive;
	}
	
	public Cell(Boolean alive, int positonX, int positionY){
		this.alive = alive;
		this.positionX = positionX;
		this.positionY = positionY;
	}
	//the toString method returns the position of the cell back
	public String toString(){
		return "My position X is " + positionX + " and my position Y is " + positionY + " My status is " +alive;
	}
	
}
