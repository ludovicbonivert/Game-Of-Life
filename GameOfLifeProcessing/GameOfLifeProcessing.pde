int width = 400, height = 400;
int cellWidth = 10;
int numberOfCells = (width/cellWidth) * (height/cellWidth);
int row = width/cellWidth;
int columns = height/cellWidth;


color deadColor = color(64, 64, 64);
color lifeColor = color(53, 232, 95);


//ArrayList<Cell> myCells = new ArrayList<Cell>();
// Two dimensional grid. One for the actual generation and the second
// for the next
Cell [][] myGrid = new Cell[row][columns];

void setup(){
  //size of document
  frameRate(3);
  size(width, height);
  background(#D9D9D9);
  //Making the grid layout
  for(int i = 0; i <= width; i += cellWidth){
    line(0,i,width,i);
    line(i, 0, i, height);
  }
  
  //Populate the whole grid with (dead) cells
  for(int i = 0; i < row; i++){
    for(int y = 0; y < columns; y++){
      myGrid[i][y] = new Cell(false);
      println("The variable i is " + i +" and y is" + y);
      if(myGrid[i][y].isAlive == false){
        fill(lifeColor);
      }else{
        fill(deadColor);
      }
    }
  }
  //Making the first generation
  //fill(#51F06E);
  for(int i = 0; i <= 9; i++){
        int randomX = floor(random(0, (width/10)));
        int randomY = floor(random(0, (height/10)));
        //Put this values into the array (and not for the 10 first like at the start)
        myGrid[randomX][randomY] = new Cell(true);
        // Make this numbers * 10 to fit in grid
        randomX *= 10;
        randomY *= 10;
        rect(randomX, randomY, 10, 10);
  }
}

void draw(){
  calculateNextGeneration();
  renderNewGeneration();
}

void calculateNextGeneration(){
  for(int i = 0; i < row; i++){
    for(int y = 0; y < columns; y++){
      if(myGrid[i][y].isAlive == true){
        println(myGrid[i][y].isAlive + " I'm alive ! " + i + " " + y);
        int x = checkNeighbours(i, y);
        //Check return value and apply the rules of GOL
        if(x == 2 || x == 3){
            myGrid[i][y].isAlive = true;
         }
         if(myGrid[i][y].isAlive == true){
           if(x < 2){
           myGrid[i][y].isAlive = false;
           }
         }
         if(myGrid[i][y].isAlive == true){
           if(x > 3){
           myGrid[i][y].isAlive = false;
           }
         }
        // if isAlive is false
      }else{
        //println("I'm dead");
        int x = checkNeighbours(i, y);
        if(x == 2 || x == 3){
            myGrid[i][y].isAlive = true;
            //println("I become true !");
            
         }
      }
    }
  }
}
int checkNeighbours(int x, int y){
  int neighbours = 0;
  // Made y+2 and x+2 ipv +1 because i have ArrayIndexOutofBound
  if((x-1) < 0 || (y-1) < 0 || (y+2) > row || (x+2) > row){
   //println("I have in one of my places no neighbour");
    //println(x +" " +  y);
    
  }else{
     if(myGrid[x-1][y].isAlive == true){
      neighbours++;
    }
    if(myGrid[x-1][y+1].isAlive == true){
      neighbours++;
    }
    if(myGrid[x][y-1].isAlive == true){
      neighbours++;
    }
    if(myGrid[x+1][y-1].isAlive == true){
      neighbours++;
    }
    if(myGrid[x+1][y].isAlive == true){
      neighbours++;
    }
    if(myGrid[x+1][y+1].isAlive == true){
      neighbours++;
    }
    if(myGrid[x+1][y].isAlive == true){
      neighbours++;
    }
    if(myGrid[x-1][y-1].isAlive == true){
      neighbours++;
    }
    
  }
  return neighbours;
}

void renderNewGeneration(){
  for(int i = 0; i < row; i++){
    for(int y = 0; y < columns; y++){
    if(myGrid[i][y].isAlive == true){
         fill(lifeColor);
      }else{
        fill(deadColor);
      }
      rect(i*cellWidth, y * cellWidth, cellWidth, cellWidth);
    }
  }
}
