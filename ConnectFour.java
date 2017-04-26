import java.util.*;

//TO DO
//-Handle main game logic
//-Add connected pieces and total pieces to the display
//-Testing
//-Update UML Diagram
//-Update Journal
//-PowerPoint
//-Submit Everything

public class ConnectFour{

   static Player player1;
   static Player player2;
   static GameBoard board;
   
   public static void main(String[] args){
   
      player1 = new Player(1,'x');
      player2 = new Player(2,'o');
      board = new GameBoard(10);
      
      Scanner console = new Scanner(System.in);
   
      boolean playagain = true;
      while(playagain == true){ //While the players want to continue playing
      
         board.displayBoard();
         
         boolean noWinner = true;
         while(noWinner){
           
            playerMove(player1, console);
            
            board.displayBoard();
            
            if(board.checkPlayerWin(player1.getPieceType()) == 1       //if player 1 won
               || board.checkPlayerWin(player1.getPieceType()) == 0){  //or if there was a tie
               noWinner = false;                                       //then there was a winner(or tie)
            }
            
            
            if(noWinner){
            playerMove(player2, console); 
            }
            
            board.displayBoard();

            if(board.checkPlayerWin(player2.getPieceType()) == 1       //if player 2 won
               || board.checkPlayerWin(player2.getPieceType()) == 0){  //or if there was a tie
               noWinner = false;                                       //then there was a winner(or tie)
            }

            
         }
         
         
      }
      
      
      
   }
   
   /**
    * Manages a players move
    * @param the player whose move is being made
    */   
   public static void playerMove(Player player, Scanner console){
      System.out.print("Player " + player.getPlayerNum() + "'s turn. Enter a column 1 - " + board.getGridSize() + ": ");
      
      int input = console.nextInt();
      while(!board.validMove(input - 1)){
         System.out.print("Invalid move, try again\n" + "Enter a column 1 - " + board.getGridSize() + ": " );
         input = console.nextInt();
      }
      
      board.updateBoard(input - 1, player.getPieceType());
      
   }

}