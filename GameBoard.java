import java.util.*;

/**
 * This class models a ConnectFour gameboard of variable size. 
 * @author Team 6, Jose Quinones, Noah Benveniste and Sean Devers
 */
public class GameBoard{

   /**
    * The number of pieces that need to be connected to win the game
    */
   private int numberToConnect;
   
   /**
    * The grid representation of the gameboard
    */
   private char[][] grid;
  
   /**
    * The Size of the grid representing the gameboard
    */
   private int gridSize; 
  
   /**
    * Constructor for Gameboard. Only allows an even gridSize so that the number of pieces
    * connected to win can always be a whole number. Initializes gridSize, numberToConnect,
    * grid, and fills grid with spaces.
    * @param gridSize the size that we want the game board to be. Must be even.
    */
   public GameBoard(int gridSize){
      if(gridSize % 2 != 0){
         throw new IllegalArgumentException("gridSize must be an even integer");
      }
      this.gridSize = gridSize;
      this.numberToConnect = gridSize / 2;
     
      grid = new char[gridSize][gridSize];
     
      for(int i = 0; i < gridSize; i++){
         Arrays.fill(grid[i], ' ');
      }
   }
  
   /**
    * Displays the gameboard as ASCII text on the screen
    */
   public void displayBoard(){
  
      for(int x = 0; x < gridSize * 2 + 1; x++){   //Fenceposts a row of dashes to make
         System.out.print("-");                    //the top of the board
      }
      System.out.println();
 
      for(int i = 0; i < gridSize; i++){           //Displays a fenceposted | and then the contents
         System.out.print("|");                    //of one of the cells of the grid array and
         for(int j = 0; j < gridSize; j++){        //then another |, and repeats for the rest of
            System.out.print(grid[i][j] + "|");    //the line
         }
         System.out.println();
         for(int k = 0; k < gridSize * 2 + 1; k++){    //Adds another row of dashes in between
            System.out.print("-");                     //the lines of data
         }
         System.out.println();
      }                                            //Repeats until the board is fully diplayed
      System.out.println();
   }
  
   /**
    * Acts as a setter for the board, adding a piece of type pieceType when given the
    * column to put it in
    * @param column The column in which to place the piece
    * @param pieceType The character being used as the players piece
    */
   public void updateBoard(int column, char pieceType){
     
      for(int i = gridSize - 1; i >= 0; i--){
         if(grid[i][column] == ' '){
            grid[i][column] = pieceType; break;
         }
      }
     
   }
  
   /**
    * Checks if a chosen column is a valid move or not
    * @param column The column chosen as the player's move
    * @return true if the move is valid, false otherwise
    */
   public boolean validMove(int column){
      if(column < 0 || column > gridSize - 1){
         return false;
      }
     
      for(int i = 0; i < gridSize; i++){
         if(grid[i][column] == ' '){
            return true;
         }
      }
     
      return false;
     
   }
  
   /**
    * Returns the size of the grid
    * @return gridSize
    */
   public int getGridSize() {
      return gridSize;
   }
  
   /**
    * Returns the number of connected pieces to win the game
    * @return the number of connected pieces to win the game
    */
   public int getBoardNumberToConnect() {
      return numberToConnect;
   }
  
   /**
    * Checks if the player with the character pieceType has won the game
    * @param pieceType The character being used as the player's piece
    * @return 1 if the specified player has won, 0 if there is a tie, and -1 if the game is not 
    * yet over
    */
   public int checkPlayerWin(char pieceType) {
      
      //Check row win
      for(int row = 0; row < gridSize; row++) {
         int connects = 0;
         for(int column = 0; column < gridSize; column++) {
            if(grid[row][column] == pieceType) {
               connects++;
            } else {
               connects = 0;
            }  
            
            if (connects == numberToConnect) {
               return 1;
            }  
         }
      }
     
      //Check column win
      for(int column = 0; column < gridSize; column++) {
         int connects = 0;
         for(int row = 0; row < gridSize; row++) {
            if(grid[row][column] == pieceType) {
               connects++;
            } else {
               connects = 0;
            }  
            
            if (connects == numberToConnect) {
               return 1;
            }  
         }
      }
      
      //Check for diagonal wins one way
      for(int i = 0; i < gridSize; i++) {
         int connects = 0;
         int row1 = i; 
         int column1 = 0;
         while(row1 >= 0) {
            if(grid[row1][column1] == pieceType) {
               connects++;
            } else {
               connects = 0;
            }  
            if (connects == numberToConnect) {
               return 1;
            }  
            
            row1--;
            column1++;
            
         
         }
      }
         
      //Check for diagonal wins the other way
      for(int i = 0; i < gridSize; i++) {
         int connects = 0;
         int row1 = 0; 
         int column1 = i;
         while(column1 >= 0) {
            if(grid[row1][column1] == pieceType) {
               connects++;
            } else {
               connects = 0;
            }  
            if (connects == numberToConnect) {
               return 1;
            }  
            
            row1++;
            column1--;
            
               
         }
      }
      
      if(this.checkTie()) {
         return 0;
      }
      return -1;
      
   }
   
   /**
    * Checks if there is a tie, i.e. the board is completely full
    * @return True if there is a tie, False if there is not a tie
    */
   public boolean checkTie() {
      for(int i = 0; i < gridSize; i++) {
         for(int j = 0; j < gridSize; j++) {
            if(grid[i][j] == ' ') {
               return false;
            }
         }
      }
      return true;
   }
  
   /**
    * Returns the max number of a certain piece type connected in a row horizontally, vertically,
    * or diagonally.
    * @param pieceType The character being used as the players piece
    * @return The max number of connections of the pieceType found in a row
    */
   public int checkMaxConnects(char pieceType) {
      int maxConnects = 0;
      
      //Count row pieces
      for(int row = 0; row < gridSize; row++) {
         int connects = 0;
         for(int column = 0; column < gridSize; column++) {
            if(grid[row][column] == pieceType) {
               connects++;
            } else {
               connects = 0;
            }  
              
            maxConnects = Math.max(maxConnects, connects);  
         }
      }
      
      //Count column pieces
      for(int column = 0; column < gridSize; column++) {
         int connects = 0;
         for(int row = 0; row < gridSize; row++) {
            if(grid[row][column] == pieceType) {
               connects++;
            } else {
               connects = 0;
            }  
         
            maxConnects = Math.max(maxConnects, connects);   
         }
      }
      
      //Check for diagonal wins one way
      for(int i = 0; i < gridSize; i++) {
         int connects = 0;
         int row1 = i; 
         int column1 = 0;
         while(row1 >= 0) {
            if(grid[row1][column1] == pieceType) {
               connects++;
            } else {
               connects = 0;
            }  
            
            maxConnects = Math.max(maxConnects, connects);
            
            row1--;
            column1++;
            
         
         }
      }
         
      //Check fo diagonal wins the other way
      for(int i = 0; i < gridSize; i++) {
         int connects = 0;
         int row1 = 0; 
         int column1 = i;
         while(column1 >= 0) {
            if(grid[row1][column1] == pieceType) {
               connects++;
            } else {
               connects = 0;
            }  
               
            maxConnects = Math.max(maxConnects, connects);           
            
            row1++;
            column1--;
            
         }
      } 
 
      return maxConnects;
      
   }
}