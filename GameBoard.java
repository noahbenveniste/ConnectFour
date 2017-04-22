/**
 * This class models a ConnectFour gameboard of variable size. 
 */
public class GameBoard{

  private int numberToConnect; //The number of pieces that need to be connected to win the game
  
  private char[][] grid; //the grid representation of the gameboard
  
  private int gridSize; //the size of the grid representing the gameboard
  
  
  public GameBoard(int gridSize){
     if(gridSize % 2 != 0){
        throw new IllegalArgumentException("gridSize must be an even integer");
     }
     this.gridSize = gridSize;
     this.numberToConnect = gridSize / 2;
  }
  
  /**
   * Displays the gameboard as ASCII text on the screen
   */
  public void displayBoard(){ 
     
  }
  
  /**
   * Acts as a setter for the board, adding a piece of type pieceType when given the
   * column to put it in
   * @param column The column in which to place the piece
   * @param pieceType The character being used as the players piece
   */
  public void updateBoard(int column, char pieceType){
  
  }
  
  /**
   * Returns the size of the grid
   * @return gridSize
   */
  public int getGridSize(){
     return gridSize;
  }
  
  /**
   * Returns the number of connected pieces to win the game
   * @return the number of connected pieces to win the game
   */
  public int getBoardNumberToConnect(){
     return numberToConnect;
  }
  
  /**
   * Checks if the player with the character pieceType has won the game
   * @return 1 if the specified player has won, 0 if there is a tie, and -1 if the game is not 
   * yet over
   */
  public int checkPlayerWin(char pieceType){
     return -1; 
  }
  
  /**
   * Checks if there is a tie, i.e. the board is completely full
   * @return True if there is a tie, False if there is not a tie
   */
  public boolean checkTie(){
     return false;
  }
  
  /**
   * Returns the max number of a certain piece type connected in a row horizontally, vertically,
   * or diagonally.
   * @param pieceType The character being used as the players piece
   * @return The max number of connections of the pieceType found in a row
   */
  public int checkMaxConnects(char pieceType){
      return 0;
  }
  
  

}