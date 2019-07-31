import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;

class GamePieces extends GameBody {
  
  private String identifyPiece(String input) {
    String directory = "images/";
    if (input.indexOf("t") < 0)
      directory = directory + "golden/";    //a piece from player one
    else
      directory = directory + "green/";     //a piece from player two
    if (input.indexOf("R") > 0)
      directory = directory + "rook.png"; //is a rook
    else if (input.indexOf("H") > 0)
      directory = directory + "knight.png"; //is a knight
    else if (input.indexOf("B") > 0)
      directory = directory + "bishop.png"; //is a bishop
    else if (input.indexOf("Q") > 0)
      directory = directory + "queen.png"; //is a queen
    else if (input.indexOf("K") > 0)
      directory = directory + "king.png"; //is a king
    else if (input.indexOf("P") > 0)
      directory = directory + "pawn.png"; //is a pawn uwu
    return directory;
  } //identifyPiece method
  
  private void initialize() throws IOException {
    String directory; //create a placeholder variable
    for (int x = 0; x < 8; x++) {
      for (int y = 0; y < 8; y++) {
        if (data[x][y].indexOf("x") == 0) {
          JLabel icon = new JLabel(" ");
          pieces.add(icon); //place the whitespace onto the gridLayout
        } else {
          directory = identifyPiece(data[x][y]); //pass the array element through the function
          BufferedImage img = ImageIO.read(new File(directory));
          JLabel icon = new JLabel(new ImageIcon(img));
          pieces.add(icon); //place the picture of the piece onto the gridLayout
        }
      }
    }
  } //initalize method
  
  public void refresh() {
    pieces.removeAll(); //Refresh the pieces on the clients frame
    try {
      initialize();
    } catch (Exception e) {
      System.out.println(e);
    }
    frame.revalidate(); //Refresh the Frame
  } //refresh board
  
} //GamePieces class