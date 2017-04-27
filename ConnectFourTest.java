/**
 * Whitebox testing for ConnectFour
 * @author Group 06, Noah Benveniste, Jose Quinones, Sean Devers
 */
public class ConnectFourTest {
   public static void main(String[] args) {
      testUpdateBoard();
      testValidMove();
      testCheckPlayerWin();
      testCheckMaxConnects();
   }
   
   public static GameBoard setUp(int size) {
      GameBoard board = new GameBoard(size);
      return board;
   }
   
   public static void testUpdateBoard() {
      System.out.println("Test updateBoard()");
      GameBoard board = setUp(4);
      board.updateBoard(0, 'x');
      board.displayBoard();
      System.out.println();
   }
   
   public static void testValidMove() {
      System.out.println("Test validMove()");
      GameBoard board = setUp(4);
      board.updateBoard(0, 'x');
      board.updateBoard(0, 'x');
      board.updateBoard(0, 'x');
      board.updateBoard(0, 'x');
      
      board.displayBoard();
      
      System.out.println("Test 1");
      System.out.println("Expected: false");
      System.out.println("Actual: " + board.validMove(0));
      System.out.println("Test 2");
      System.out.println("Expected: true");
      System.out.println("Actual: " + board.validMove(1));
      System.out.println();
   }
   
   public static void testCheckPlayerWin() {
      System.out.println("Test checkPlayerWin()");
      System.out.println("Horizontal win");
      GameBoard board = setUp(6);
      board.updateBoard(0, 'x');
      board.updateBoard(1, 'x');
      board.updateBoard(2, 'x');
      board.displayBoard();
      System.out.println("Expected: 1");
      System.out.println("Actual: " + board.checkPlayerWin('x'));
      System.out.println();
      
      System.out.println("Vertical win");
      board = setUp(6);
      board.updateBoard(0, 'x');
      board.updateBoard(0, 'x');
      board.updateBoard(0, 'x');
      board.displayBoard();
      System.out.println("Expected: 1");
      System.out.println("Actual: " + board.checkPlayerWin('x'));
      System.out.println();
      
      System.out.println("Left diagonal win");
      board = setUp(6);
      board.updateBoard(0, 'o');
      board.updateBoard(0, 'o');
      board.updateBoard(0, 'x');
      board.updateBoard(1, 'o');
      board.updateBoard(1, 'x');
      board.updateBoard(2, 'x');
      board.displayBoard();
      System.out.println("Expected: 1");
      System.out.println("Actual: " + board.checkPlayerWin('x'));
      System.out.println();
      
      System.out.println("Right diagonal win");
      board = setUp(6);
      board.updateBoard(0, 'x');
      board.updateBoard(1, 'o');
      board.updateBoard(1, 'x');
      board.updateBoard(2, 'o');
      board.updateBoard(2, '0');
      board.updateBoard(2, 'x');
      board.displayBoard();
      System.out.println("Expected: 1");
      System.out.println("Actual: " + board.checkPlayerWin('x'));
      System.out.println();
      
      System.out.println("No win");
      board = setUp(4);
      System.out.println("Expected: -1");
      System.out.println("Actual: " + board.checkPlayerWin('x'));
      System.out.println();
      
      System.out.println("Tie");
      board = setUp(4);
      
      board.updateBoard(0,'x');
      board.updateBoard(1,'o');
      board.updateBoard(2,'x');
      board.updateBoard(3,'o');
      
      board.updateBoard(0,'q');
      board.updateBoard(1,'q');
      board.updateBoard(2,'q');
      board.updateBoard(3,'q');
      
      
      board.updateBoard(0,'x');
      board.updateBoard(1,'o');
      board.updateBoard(2,'x');
      board.updateBoard(3,'o');
      
      
      board.updateBoard(0,'q');
      board.updateBoard(1,'q');
      board.updateBoard(2,'q');
      board.updateBoard(3,'q');
      
      board.displayBoard();
      
      System.out.println("Expected: 0");
      System.out.println("Actual: " + board.checkPlayerWin('x'));
      
   }
   
   public static void testCheckMaxConnects() {
      System.out.println("Testing checkMaxConnects()");
      System.out.println();
      GameBoard board = setUp(8);
      board.updateBoard(0, 'x');
      board.updateBoard(1, 'o');
      board.updateBoard(2, 'o');
      board.updateBoard(3, 'o');
      board.updateBoard(5, 'o');
       
      board.updateBoard(1, 'x');
      board.updateBoard(2, 'x');
      board.updateBoard(3, 'o');
      
      board.updateBoard(2, 'x');
      board.updateBoard(3, 'x');
      
      board.updateBoard(3, 'x');
      
      board.displayBoard();
      System.out.println();
      
      System.out.println("Max connects for o");
      System.out.println("Expected: 3");
      System.out.println("Actual: " + board.checkMaxConnects('o'));
      System.out.println();
      System.out.println("Max connects for x");
      System.out.println("Expected: 4");
      System.out.println("Actual: " + board.checkMaxConnects('x'));
   }
}