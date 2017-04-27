import java.util.*;

/**
 * This class handles the main logic for the Connect Four game
 * @author Team 6, Jose Quinones, Noah Benveniste and Sean Devers
 */
public class ConnectFour{

   /** Minimum board width/height */
   static final int MIN_BOARD_SIZE = 8;
   

   /** Maximum board width/height */
   static final int MAX_BOARD_SIZE = 20;
   
   static Player player1;
   static Player player2;
   static GameBoard board;
   
   public static void main(String[] args){
   
      Scanner console = new Scanner(System.in);
      System.out.println("Welcome to Connect Four! Please enter a board size below.");
      System.out.println("The board size must be a positive, even integer between " + 
                         MIN_BOARD_SIZE + " and " + MAX_BOARD_SIZE + " inclusive.");
      System.out.println("The board will be square, with dimensions (board size) x (board size).");
      System.out.println("Each player will take turns placing pieces in columns until one");
      System.out.println("player connects their pieces horizontally, vertically or diagonally.");
      System.out.println("The number of pieces to connect is half the board size.");
      System.out.println();
      
      int boardSize = getBoardSize(console);
      
      player1 = new Player(1,'x');
      player2 = new Player(2,'o');
      
   
      boolean playAgain = true;
      while(playAgain == true){ //While the players want to continue playing
      
      board = new GameBoard(boardSize);
      player1.resetMoveCount();
      player2.resetMoveCount();
         
         board.displayBoard();
         
         boolean noWinner = true;
         while(noWinner){
           
            playerMove(player1, console);
            
            board.displayBoard();
            player1.printStatistics();
            
            if(board.checkPlayerWin(player1.getPieceType()) == 1       //if player 1 won
               || board.checkPlayerWin(player1.getPieceType()) == 0){  //or if there was a tie
               noWinner = false;                                       //then there was a winner(or tie)
            }
            
            
            if(noWinner){                                              //if player 1 did not win previously
               playerMove(player2, console); 
               board.displayBoard();
               player2.printStatistics();
               if(board.checkPlayerWin(player2.getPieceType()) == 1     //if player 2 won
               || board.checkPlayerWin(player2.getPieceType()) == 0){   //or if there was a tie
                  noWinner = false;                                     //then there was a winner(or tie)
               }
            }
            

                     } 
         
         if(board.checkPlayerWin(player1.getPieceType()) == 1 ){
            player1.addWin();
            System.out.println("Player 1 Wins!");
         }
         
         if(board.checkPlayerWin(player2.getPieceType()) == 1 ){
            player2.addWin();
            System.out.println("Player 2 Wins!");
         }
         
         if(board.checkPlayerWin(player1.getPieceType()) == 0){
            System.out.println("It's a Tie!");
         }
         
         System.out.println();
         System.out.println("Player 1 has won: " + player1.getWins());
         System.out.println("Player 2 has won: " + player2.getWins());
         
         System.out.println("Do you want to play again?");
         String choice = console.next();
         
         while(Character.toLowerCase(choice.charAt(0)) != 'y' && Character.toLowerCase(choice.charAt(0)) != 'n'){
            System.out.print("Invalid Input, Try Again: ");
            choice = console.next();
         }
         
         if(Character.toLowerCase(choice.charAt(0)) == 'n'){
            playAgain = false;
         }
         
      } 
   }
   
   /**
    * Manages a players move
    * @param the player whose move is being made
    */   
   public static void playerMove(Player player, Scanner console){
      System.out.print("Player " + player.getPlayerNum() + "'s turn. Enter a column 1 - " + board.getGridSize() + ": ");
      
      while(!console.hasNextInt()){
         console.next();
         System.out.print("Invalid Input, Try Again: ");
      }
      int input = console.nextInt();
      
      while(!board.validMove(input - 1)){
         System.out.print("Invalid move, try again\n" + "Enter a column 1 - " + board.getGridSize() + ": " );
         input = console.nextInt();
      }
      
      board.updateBoard(input - 1, player.getPieceType());
      
      player.addMoveCount();
      player.setMaxConnects(board);
      
   }
   
   /**
    * Method that prompts user to enter a board size.
    * If user enters anything other than a positive, even integer,
    * they are reprompted to enter a size.
    * @param console A scanner for capturing user input
    * @return boardSize The length and width of the game board
    */
   public static int getBoardSize(Scanner console) {
      boolean sizeIsValid = false;
      int boardSize = 0;
      while(!sizeIsValid){
         System.out.print("Input size of board: ");
         while(!console.hasNextInt()) {
            console.next();
            System.out.println("Invalid input. Board size must be a positive, " +
                               "even integer between " + MIN_BOARD_SIZE + " and " +
                               MAX_BOARD_SIZE + " (inclusive).");
            System.out.println();
            System.out.print("Input size of board: ");
         }
         boardSize = console.nextInt();
         if (boardSize < MIN_BOARD_SIZE || boardSize > MAX_BOARD_SIZE || boardSize%2 != 0) {
            System.out.println("Invalid input. Board size must be a positive, " +
                               "even integer between " + MIN_BOARD_SIZE + " and " +
                               MAX_BOARD_SIZE + " (inclusive).");
            System.out.println();
         } else {
            sizeIsValid = true;
         }
      }
      
      System.out.println("Your board will be " + boardSize + " x " + boardSize + " spaces.");
      System.out.println();
      System.out.println();
      
      return boardSize;
   }
}