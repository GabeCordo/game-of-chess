import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;

public class GameBody extends GameFrame {

  
  //create the object for ChessInput
  static ChessInput i = new ChessInput();
  
  //chessBoard Swing Components
  static JPanel board, pieces;
  
  //chessboard
  static String data[][] = {
    {"tR","tH","tB","tQ","tK","tB", "tH", "tR"},
    {"tP","tP","tP","tP","tP","tP", "tP", "tP"},
    {"x","x","x","x","x","x", "x", "x"},
    {"x","x","x","x","x","x", "x", "x"},
    {"x","x","x","x","x","x", "x", "x"},
    {"x","x","x","x","x","x", "x", "x"},
    {"oP","oP","oP","oP","oP","oP", "oP", "oP"},
    {"oR","oH","oB","oQ","oK","oB", "oH", "oR"}
  };
  
  
  //Core Code
  private static void chessBoard() throws IOException {
    //Generate the board panel for the DEFAULT_LAYER
    board = new JPanel();
    board.setLayout(new BorderLayout());
    board.setLocation(0, 0);
    board.setSize(body.getPreferredSize());
    board.setBackground(charcoal);
    body.add(board, JLayeredPane.DEFAULT_LAYER);
    //Generate the content for the board panel
    BufferedImage image = ImageIO.read(new File("images/board/brd.png"));
    JLabel center = new JLabel(new ImageIcon(image));
    //center.setPreferredSize(new Dimension(800,800));
    center.setBackground(concrete);
    board.add(center, BorderLayout.CENTER);
    //Generate the listener for the board panel
    board.addMouseListener(i);
  } //bodyCenter method
  
  private static void chessPieces() throws IOException {
    //Generate the pieces panel for the DRAG_LAYER
    pieces = new JPanel();
    pieces.setLayout(new GridLayout(0, 8));
    pieces.setLocation(22, 22);
    pieces.setSize(460,460);
    pieces.setOpaque(false);
    body.add(pieces, JLayeredPane.DRAG_LAYER);
  } //chessPieces method
  
  public static void pack() {
    try {
      chessBoard();
      chessPieces();
    } catch (Exception e) {
      System.out.println(e);
    }
  } //pack method
  
} //GameBody class
