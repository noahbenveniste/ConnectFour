/**
 * This class models a Player of ConnectFour
 */
public class Player{
    
    
    private char pieceType; // The character that will be used as the players piece
    
    private int moveCount; // The number of moves that the player has made
    
    private int maxConnects; // The highest number of connects that the player currently has
    
    private int numberOfWins; // Number of wins this player has during this run of the program
     
    /**
     * Constructer for player class
     * @param num I don't understand what this is for currently
     * @param pieceType The character to be used as the players piece
     */
    public Player (int num, char pieceType) {
       this.pieceType = pieceType;
    }
    
    /**
     * Getter method for numberOfWins
     * @return The number of wins
     */
    public int getWins() {
       return numberOfWins;
    } 
    
    /**
     * Getter method for pieceType
     * @return The character used as the players piece
     */
    public char getPieceType() {
       return pieceType;
    }
    
    /**
     * Getter method for moveCount
     * @return The number of moves that the player has made
     */
    public int getMoveCount() {
       return moveCount;
    }
    
    /**
     * Getter method for maxConnects
     * @return The highest number of connects that the player currently has
     */
    public int getMaxConnects() {
       return maxConnects;
    }
    
    /**
     * Adds one win to the total number of wins that a player has
     */
    public void addWin() {
       numberOfWins ++;
    }
    
    /**
     * Adds one to the total number of moves that a player has made
     */
    public void addMoveCount() {
       moveCount ++;
    }
    
    /** 
     * Resets the total move count to zero. Mainly used when starting a new game
     */
    public void resetMoveCount(){
       moveCount = 0;
    }
    
    /**
     * Sets the max number of connects
     */
    public void setMaxConnects(){
       
    }
    
}