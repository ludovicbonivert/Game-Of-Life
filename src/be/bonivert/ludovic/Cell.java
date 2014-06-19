package be.bonivert.ludovic;

/** Cell class **/
public class Cell {
	// A Cell have two possibilities; it is dead or alive.
	private static final int isAlive = 1;
	private static final int isDead = 0;
	
	//Alive can be true or false (alive or dead)
	public Boolean alive;
	
	//Constructor of Cell. The parameter given is true or false (alive or dead)
	public Cell(Boolean alive){
		this.alive = alive;
	}
	
}
