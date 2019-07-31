import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;

class GameMain {
  
  static GameFrame pane = new GameFrame();
  static GameHeader header = new GameHeader();
  static GameBody body = new GameBody();
  static GameFooter footer = new GameFooter();
  static GamePieces pieces = new GamePieces();
  
  public static void run(String p1Name, String p1File, String p2Name, String p2File) {
    
    // Sets UI to cross platform style to allow for coloured buttons on a Mac
    try {
      UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
    } catch (Exception e) {
      e.printStackTrace();
    }
        pane.pack();
        header.pack(p2Name, p2File);
        body.pack();
        footer.pack(p1Name, p1File);
        pane.frame.pack();
        pane.frame.setVisible(true);
        pieces.refresh();
    } //main method
  
} //GameMain class