
import java.util.ArrayList;
import java.util.Scanner;




/**
 * This is the Chessboard App. It initializing a functional Chessboard where the user
 * can enter the location of a chess piece and move it where they want to put it.
 * It has a display board that shows the user the what is happening on the board 
 * and where all the pieces are. It also has a reference board to show the user
 * where are the possible locations to move are. Then there's a board that is not
 * shown that contains all the pieces of the chesspiece class. That board determines
 * which pieces are white and which pieces are black, as well as what the piece is
 * @author Ryan Walker
 * Date last modified: 6/10/18
 * Project: Final Project
 * Class: CIS 304.04
 */
public class ChessBoard {
    
    public static String[][] board = new String[17][8];
    public static ChessPieces[][] backBoard = new ChessPieces[8][8];
    public static ArrayList<ChessPieces> whitePieces = new ArrayList<ChessPieces>();
    public static ArrayList<ChessPieces> blackPieces = new ArrayList<ChessPieces>();
    /**
     * Method that adds pieces to the background board.
     * @param x x coordinate
     * @param y coordinate
     * @param p object of ChessPieces
     */
    public static void addBackPiece(int x, int y, ChessPieces p){
        backBoard[x][y] = p;
    }
    /**
     * add pieces to the board that the user sees
     * @param x coordinate
     * @param y coordinate
     * @param r string name of the piece
     */
    public static void addPiece(int x, int y, String r){
        board[x][y] = r;
    }
    /**
     * Method that displays the game board and the 
     * reference board that the user sees 
     */
    public static void showBoard(){
        System.out.println();
        System.out.println("\t   GameBoard\t\t\t\t Reference Board");
        
        for (int row =0;row<8; row++){
            System.out.println();
            System.out.println("---------------------------------       "
            + "---------------------------------");
            //nested for loop that shows the board and the reference
            //board side by side
            for (int col=0; col<17; col++){
                if (col == 9){
                    System.out.print("    ");
                }
                System.out.print("|");
                
                if (board[col][row] == null)
                    System.out.print("   ");
                else
                    System.out.print(board[col][row]);
            }
            System.out.print("|");
        }
        System.out.println("");
        System.out.println("---------------------------------       "
        + "---------------------------------");  
    }
    /**
     * Method that sets the white pieces
     * of the display board that the user sees.
     * Uses nested for loop to fill in the array.
     */
    public static void setWhiteSide()
    {
        for (int i=0;i<8;i++){
            for (int j=6;j<7;j++){
                addPiece(i, j, " wP");
            }//end inner for loop
        }//end outer for loop
        String[] wPieces = {"wR","wN","wB","wQ","wK","wB" ,"wN","wR"};
        int k=0;
            for (int i=0;i<8;i++){
                for (int j=7;j<8;j++){ 
                    addPiece(i, j, " " +wPieces[k]);
                }//end inner for loop
                k++;
            }//end outer for loop    
    }//end setWhiteSide
    
    /**
     * Method that sets the black side of the display
     * board that the user see. Uses nested for loop to 
     * fill in the array in the specific spots
     */
    public static void setBlackSide(){
  
        for (int i=0;i<8;i++){
            for (int j=1;j<2;j++){
                addPiece(i, j, " bP" );
            }
        }
        String[] bPieces = {"bR","bN","bB","bQ","bK","bB" ,"bN","bR"};
        
        int k=0;
            for (int i=0;i<8;i++){
                for (int j=0;j<1;j++){
                    addPiece(i, j, " " +bPieces[k]);
                }
                k++;
            }
    }
    /**
     * This method removes pieces on the display board that the
     * user sees
     * @param x coordinate
     * @param y coordinate
     */ 
    public static void removePiece(int x, int y){
        board[x][y] = null;
    }
   /**
    * This method moves pieces from one spot to another on the board that
    * the user sees
    * @param fromX coordinate
    * @param fromY coordinate
    * @param toX coordinate
    * @param toY coordinate
    * @param p String name of the chess piece
    */ 
   public static void movePiece(int fromX, int fromY, int toX, int toY, String p){
        addPiece(toX,toY,p);
        removePiece(fromX, fromY);
        //showBoard();
    }
   /**
    * This method fills in the reference board that is displays
    * next to the game board in the specific places that it
    * needs to be in.
    */
   public static void fillReference(){
        String[] letter = {"A", "B", "C", "D","E","F","G","H"};
        int ref = 1;
        int let = -1;
        
        for (int i=9;i<17;i++){
            for (int j=0;j<8;j++){
                 board[i][j]= " " + letter[j] + Integer.toString(ref);
            }
            ref++;
        }   
    }
   /**
    * Method that displays the start message for the game.
    * 
    */
   public static void displayStartMessage(){
        System.out.println("Welcome to the Chess Board Game");
        System.out.println("Would you like to begin?");
        System.out.println("Enter \"Y\" to start or \"N\" to exit. ");
        
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        boolean valid = false;
        while (!valid){
            if (input.equalsIgnoreCase("y")){
                playGame();
                valid = true;
            }else if(input.equalsIgnoreCase("n")){
                System.out.println("Thanks for playing!");
                System.exit(0);
                valid = true;
            }else
                System.out.println("Invalid Input. Try Again.");
                input = kb.nextLine();
        }
    }
   /**
    * Method that takes the input string from the user
    * and returns a numerical value. This is for when the user is looking
    * at the reference board and enters in the letter.
    * @param input String, letting of the coordinates the user wants to move
    * @return numerical value of the letter
    */
   public static int changeToInt(String input){
       switch(input.toUpperCase()){
           case "A":
               return 0;
           case "B":
               return 1;
           case "C":
               return 2;
           case "D":
               return 3;
           case "E":
               return 4;
           case "F":
               return 5;
           case "G":
               return 6;
           case "H":
               return 7;   
           }
       return 99;
   }
   /**
    * Method that moves that pieces of the background board
    * @param fromX coordinates
    * @param fromY coordinates
    * @param toX coordinates
    * @param toY coordinates
    */
   public static void moveBackpiece(int fromX,int fromY, int toX, int toY){
       
       backBoard[toX][toY] = backBoard[fromX][fromY];
      backBoard[fromX][fromY] = null;
       
   }
   /**
    * This is a method that takes in the coordinates that the user
    * enters and figure out where that is and moves the piece accordingly
    * @param from String input from the user where the piece is
    * @param to String input of the piece wants to move
    * @param piece String name of the piece
    */
   public static void whereToMove(String from ,String to, String piece){
       //Take the string input and 
       //covert it to numbers
       char a = to.charAt(0);
       char b = to.charAt(1);
       
       char c = from.charAt(0);
       char d = from.charAt(1);
       
       int toX = changeToInt(Character.toString(a));
       int toY = Character.getNumericValue(b)-1;
       
       int fromY = changeToInt(Character.toString(c));
       int fromX = Character.getNumericValue(d)-1;
      
       
       
      //checks to see if there is an opponent
      //where the user wants to move
      boolean oValid =false;
       oValid = isThereAnOpponent(toY,toX);
       
      //if there is an opponent it calls the method and takes it
      if (oValid == true){
          takeOpponent(fromX,fromY,toY,toX, piece);
          
       }
       else{
          //moves the piece where it needs to go and makes
          //sure that it is not off the board
          try{
                movePiece(fromX,fromY,toY,toX, piece);
                moveBackpiece(fromX, fromY, toY, toX);
            }catch(ArrayIndexOutOfBoundsException excpetion){
                System.out.println("Whoops! Invalid input.");
                
           }
       }
   }
  /**
   * Method that checks to see if there is a chess piece 
   * in the spot that the user wants to move it
   * @param x coordinate
   * @param y coordinate
   * @return true if there is something there, false if there is not
   */
   public static boolean isThereAnOpponent(int x, int y){
       if(backBoard[x][y]!= null){
           return true;
       }      
           return false;
   }
   /**
    * Method that when called carries out the action of taking the opponent piece
    * Check to make sure that it is not your own team first and if it's not
    * it takes the piece
    * @param fromX coordinate
    * @param fromY coordinate
    * @param toX coordinate
    * @param toY coordinate
    * @param p String name of the chess piece
    */
   public static void takeOpponent(int fromX, int fromY, int toX, int toY, String p){
       //Checks to see if that the spot is not empty and that the piece there
       //if not on the same team as the moving piece
       if(backBoard[toX][toY]!= null && (!(backBoard[fromX][fromY].getTeam()).equals(backBoard[toX][toY].getTeam()))){
          
           backBoard[toX][toY].isDefeated();
           moveBackpiece(fromX, fromY, toX, toY);
           movePiece(fromX, fromY, toX, toY,  p);
           showBoard();
           System.out.println("You have taken the " + backBoard[toX][toY].getTeam() + " " + backBoard[toX][toY].getName());
           playTurn();
       }
       else{
           System.out.println("Can't take your own team!");
       }
   } 
   /**
    * Method that prints the name and team of the piece that the user
    * wants to move
    * @param fromX coordinate
    * @param fromY coordinate
    */
   public static  void findName(int fromX, int fromY){
   
       System.out.println("\nWhere do you want to move your " + backBoard[fromX][fromY].getTeam() + " " +backBoard[fromX][fromY].getName()+ "?");
     
   }
   
   public static String getStringPiece(int fromX, int fromY){
       return board[fromX][fromY];
   }
   /**
    * Method that starts the turn for each person and prompts them to enter
    * the coordinates based off the reference board of what piece the user wants
    * to move and where they want to move it
    */
   public static void playTurn(){
       Scanner kb = new Scanner(System.in);
         System.out.println();
         System.out.println("Enter the location of the piece that you want to move.\n(Hint, use reference board.)");
         String from = kb.nextLine();
         char c = from.charAt(0);
         char d = from.charAt(1);
         int fromY = changeToInt(Character.toString(c));
         int fromX = Character.getNumericValue(d)-1;
         String piece = getStringPiece(fromX, fromY);

        try{
            //prints the name of the piece that you want to move 
            //to make sure it is the right piece that you want to move
            findName(fromX, fromY);
            
        }catch(NullPointerException nu){  //incase you enter a location that has no piece in it
            System.out.println("\nYou don't have a piece there.\n");
            playTurn();
         }
       String to = kb.nextLine();
       char a = to.charAt(0);
       char b = to.charAt(1);

       int toY = changeToInt(Character.toString(a));
       int toX = Character.getNumericValue(b)-1;
 
         whereToMove(from, to, piece);
         showBoard();
     
         playTurn();
 
   }
   /**
    * Method that sets both the display board and the background board
    * fills in all the pieces for board as well reference board
    */
   public static void playGame()
    {
        setWhiteSide();
        setBlackSide();
        fillReference();
        setBackGroundPieces();
        setBackGroundBoard();
        showBoard();
        
        
        System.out.println("The pieces have been set. \nWhite Player goes first.");
         
         
         while(blackPieces.get(15) != null || whitePieces.get(15) != null){
        
         playTurn();
         
        
         }
         
         

    }
   /**
    * Method that creates and object for each of the pieces from the ChessPiece
    * class and stores them in an ArrayList
    */
   public static void setBackGroundPieces(){
       String [] names = {"Pawn", "Rook", "Knight", "Bishop", "King", "Queen"};
       
       for(int i=0;i<8;i++){
           ChessPieces bPawn = new ChessPieces(names[0], "Black");
           ChessPieces wPawn = new ChessPieces(names[0], "White");
           whitePieces.add(wPawn);
           blackPieces.add(bPawn);
       }
       for(int i=0;i<2;i++){
           ChessPieces bRook = new ChessPieces(names[1], "Black");
           ChessPieces wRook = new ChessPieces(names[1], "White");
           whitePieces.add(wRook);
           blackPieces.add(bRook);
       }
       for(int i=0;i<2;i++){
           ChessPieces bKnight = new ChessPieces(names[2], "Black");
           ChessPieces wKnight = new ChessPieces(names[2], "White");
           whitePieces.add(wKnight);
           blackPieces.add(bKnight);
       }
       for(int i=0;i<2;i++){
           ChessPieces bBishop = new ChessPieces(names[3], "Black");
           ChessPieces wBishop = new ChessPieces(names[3], "White");
           whitePieces.add(wBishop);
           blackPieces.add(bBishop);
       }
      ChessPieces bKing = new ChessPieces(names[4], "Black");
      ChessPieces wKing = new ChessPieces(names[4], "White");
      ChessPieces bQueen = new ChessPieces(names[5], "Black");
      ChessPieces wQueen = new ChessPieces(names[5], "White");
      
      whitePieces.add(wQueen);
      whitePieces.add(wKing);
      blackPieces.add(bQueen);
      blackPieces.add(bKing);
      
   
   } 
   /**
    * Method that takes the ArrayList of piece objects
    * and places them on the background board in the 
    * specific spot that they need to be in
    */
   public static void setBackGroundBoard(){

        int c = 0;
        for (int i=0;i<8;i++){
            for (int j=1;j<2;j++){
                addBackPiece(i, j, blackPieces.get(c) );
            }
            c++;
        }
        int p=0;
        for (int i=0;i<8;i++){
            for (int j=6;j<7;j++){
                addBackPiece(i, j, whitePieces.get(p));
            }//end inner for loop
            p++;
        }//end outer for loop
        
        addBackPiece(0, 7, whitePieces.get(8));//rook
        addBackPiece(7, 7, whitePieces.get(9));//rook
        addBackPiece(1, 7, whitePieces.get(10));//knight
        addBackPiece(6, 7, whitePieces.get(11));//Knight
        addBackPiece(2, 7, whitePieces.get(12));//Bishop
        addBackPiece(5, 7, whitePieces.get(13));//Bishop
        addBackPiece(3, 7, whitePieces.get(14));//Queen
        addBackPiece(4, 7, whitePieces.get(15));//king 
        
        addBackPiece(0, 0, blackPieces.get(8));//rook
        addBackPiece(7, 0, blackPieces.get(9));//rook
        addBackPiece(1, 0, blackPieces.get(10));//knight
        addBackPiece(6, 0, blackPieces.get(11));//Knight
        addBackPiece(2, 0, blackPieces.get(12));//Bishop
        addBackPiece(5, 0, blackPieces.get(13));//Bishop
        addBackPiece(3, 0, blackPieces.get(14));//Queen
        addBackPiece(4, 0, blackPieces.get(15));//king 
        
        
      
  
   }
   
   
   /**
    * Main method
    * @param args 
    */
   
   public static void main(String[] args)
    {
        

        displayStartMessage();
      
       
        
    }
    
}
