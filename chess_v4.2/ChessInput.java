import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ChessInput extends MouseAdapter {
  
  //Create an Object for the Handler
  ChessHandler h = new ChessHandler();
  static GamePieces p = new GamePieces();
  
  //Public Variables
  protected static int xCord = 0;
  protected static int yCord = 0;
  
  
  //Source Code
  @Override
  public void mousePressed(MouseEvent e) {
    xCord = e.getX();
    yCord = e.getY();
    h.assignInput(xCord, yCord, 0); //Calculate the array elements from the x,y coordinates
  } //mousePressed method
  
  @Override
  public void mouseReleased(MouseEvent e) {
    xCord = e.getX();
    yCord = e.getY();
    h.assignInput(xCord, yCord, 1); //Calculate the array elements from the x,y coordinates
    h.safteyCheck();
    p.refresh();
  } //mouseReleased method
  
} //ChessInput class