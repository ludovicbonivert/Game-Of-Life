package be.bonivert.ludovic;

public enum Life {
	
	DEAD ("I'm DEAD"),
	ALIVE ("I'm Alive");
	
	private String name = "";
	
	Life(String name){
		this.name = name;
	}
	public String toString(){
		return name;
	}
}

