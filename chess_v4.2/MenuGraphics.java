import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.*;  

class MenuGraphics extends MenuFrame {
  
  //Create an object for GameMain
  static GameMain game = new GameMain();
  //Banner Swing Componenets
  static JPanel componentOne;
  static JLabel title, text;
  //Footer Swing Componenets
  static JPanel componentTwo;
  static JButton play, close;
  
  //Core Code
  public static void banner() {
    //Generate the componentOne panel for the header
    componentOne = new JPanel();
    componentOne.setLayout(new BoxLayout(componentOne, BoxLayout.Y_AXIS));
    componentOne.setPreferredSize(new Dimension(300,100));
    componentOne.setBackground(concrete);
    header.add(componentOne, BorderLayout.PAGE_END);
    //Generate the components for the componentOne panel
    title = new JLabel("     A Game of CHESS");
    title.setFont(new Font("AppleGothic", Font.PLAIN, 50));
    title.setForeground(offWhite);
    componentOne.add(title);
  } //banner method
  
  public static void footer() {
    //Generate the componentTwo panel for the footer
    componentTwo = new JPanel();
    componentTwo.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 40));
    componentTwo.setBackground(concrete);
    footer.add(componentTwo);
    //Generate the components for the componentTwo panel
    play = new JButton("Play");
    play.setPreferredSize(new Dimension(100,50));
    play.setForeground(limeGreen);
    componentTwo.add(play);
    play.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e) {
        game.run(playerOneName, playerOneLogo, playerTwoName, playerTwoLogo);
        frame.dispose();
      }  
    });  
    close = new JButton("Close");
    close.setPreferredSize(new Dimension(100,50));
    close.setForeground(cherryRed);
    componentTwo.add(close);
    close.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }  
    });  
  } //footer method
  
  public static void pack() {
    banner();
    footer();
  } //pack method
  
} //MenuGraphics class