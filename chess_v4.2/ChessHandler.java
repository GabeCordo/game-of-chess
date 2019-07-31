class ChessHandler {

  //Create an object for GameBody
  GameBody game = new GameBody();
  //Create an object for GameFooter
  GameFooter footer = new GameFooter();
  //Create an object for GameHeader
  GameHeader header = new GameHeader();
  //Create an object for ChessNotification
  ChessNotification notification = new ChessNotification();
  //Create an object for the MenuFrame
  MenuFrame name = new MenuFrame();
    
  //Public Variables
  public static int elementOneOriginal = 0;
  public static int elementTwoOriginal = 0;
  public static int elementOneFinal = 0;
  public static int elementTwoFinal = 0;
  public static int playerTurn = 0; //0 - Player One's Turn : 1 - Player Two's Turn
  public static int playerWon = 0; //0 - Player One's Turn : 1 - Player Two's Turn
  
  
  //Core Code 
  public void assignInput(int x, int y, int player) {
    if (player == 1) {
      elementOneFinal = (int) (((double) y / 500) * 8);
      elementTwoFinal = (int) (((double) x / 500) * 8);
      System.out.println("Final: (" + elementOneFinal + ", " + elementTwoFinal + ")"); //debug
    } else {
      elementOneOriginal = (int) (((double) y / 500) * 8);
      elementTwoOriginal = (int) (((double) x / 500) * 8);
      System.out.println("Original: (" + elementOneOriginal + ", " + elementTwoOriginal + ")"); //debug
    }
  } //inputCheck method

  public boolean isPlayersTurn(String piece) { //checks whether it is the players turn
    int playerPiece = piece.indexOf("o");
    System.out.println(playerPiece); //debug
    boolean check = true;
    if ((playerTurn % 2) == 0 && playerPiece == 0) {
      check = true;
    } else if ((playerTurn % 2) != 0 && playerPiece < 0) {
      check = true;
    } else {
      check = false;
    }
    return check;
  } //isPlayersTurn method
  
  public boolean isValidMove(String piece) { //checks whether the player is making a correct move or is in check
    boolean check = true;
    if (elementOneOriginal == elementOneFinal && elementTwoOriginal == elementTwoFinal) //piece has not moved
      check = false;
    return check;
  } //isValidMove method
  
  public boolean isWinner(String piece) { //checks whether the player has won the game
    boolean check = false;
    return check;
  } //isWinner method
  
  public void swapPieces() {
    String prev, fin;
    prev = game.data[elementOneOriginal][elementTwoOriginal];
    fin = game.data[elementOneFinal][elementTwoFinal];
    if (fin.equals("x") == true) { //if one piece does not kill another - do a generic swap
      game.data[elementOneOriginal][elementTwoOriginal] = fin;
      game.data[elementOneFinal][elementTwoFinal] = prev;
    } else { //if one piece kills another - swap the old position to new and remove the dead piece
      game.data[elementOneOriginal][elementTwoOriginal] = "x";
      game.data[elementOneFinal][elementTwoFinal] = prev;
    }
  } //swapPieces method
  
  public void updateHistory(String piece) {
    String movement = game.data[elementOneOriginal][elementTwoOriginal];
    int playerPiece = piece.indexOf("o");
    if ((playerTurn % 2) == 0 && playerPiece == 0) { //if it is player one's turn
      footer.p1UpdateHistory(movement);
    } else if ((playerTurn % 2) != 0 && playerPiece < 0) { //if it is player two's turn
      header.p2UpdateHistory(movement);
    }
  } //updateHistory method
  
  public void safteyCheck() { //isTurn, isValidMove, isWinner
    String piece = game.data[elementOneOriginal][elementTwoOriginal];
    boolean correctPiece = isPlayersTurn(piece);
    boolean correctMove = isValidMove(piece);
    boolean hasWon = isWinner(piece);
    System.out.println("Correct Piece: " + correctPiece); //debug
    System.out.println("Correct Move: " + correctMove); //debug
    System.out.println("Has Won: " + hasWon); //debug
    if (correctPiece == true) {
      if (correctMove == true) {
        if (hasWon == false) {
          playerTurn++;
          swapPieces();
          updateHistory(piece);
        } else {
          if (playerWon == 0)
            notification.run(name.playerOneName);
          else
            notification.run(name.playerTwoName);
        }
      }
    }
  } //safteyCheck
  
} //ChessHandler class