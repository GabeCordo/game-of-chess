import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessNotification extends GameFrame {
    
    //Create an object for the GameFrame
    static GameFrame game = new GameFrame();
    
    //Create an object for the MainMenu
    static MenuMain menu = new MenuMain();
    
    //Java Swing Componenets
    static JFrame body;
    static JPanel header;
    static JPanel main;
    static JButton restart;
    static JButton close;

    
    //Source Code
    public static void initalizeFrame() {
        body = new JFrame();
        body.getContentPane().setLayout(new BorderLayout()); //Standard Layout
        body.setSize(new Dimension(250,200));
        body.setLocationRelativeTo(null); //Center the Frame
        body.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        body.setResizable(false);
        body.setTitle("NOTIFICATION"); //Frame Title
    } //initalize method

    public static void initalizePanel() {
        //header
        header = new JPanel();
        header.setLayout(new BorderLayout()); //Standard Layout
        header.setBackground(concrete);
        body.add(header, BorderLayout.PAGE_START);
        //main
        main = new JPanel();
        main.setLayout(new FlowLayout()); //Standard Layout
        main.setBackground(charcoal);
        body.add(main, BorderLayout.CENTER);
    } //initalizePanel method

    public static void initalizeContent(String name) {
        //header
        JLabel text = new JLabel(name + " won the game!  |  Would you like to restart?");
        text.setForeground(offWhite);
        header.add(text, BorderLayout.CENTER);
        //main
        restart = new JButton("Restart"); //Create a button to restart the game
        restart.setForeground(limeGreen);
        main.add(restart);
        close = new JButton("Close"); //Create a button to close the game
        close.setForeground(cherryRed);
        main.add(close);
    } //content method
    
    public static void initalizeHandle() {
      restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                body.dispose(); //close the notidication frame
                game.frame.dispose(); //close the game frame
                menu.run(); //restart the game
            }
        } );
      close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); //close the program
            }
        } );
    } //initalizeHandle method
    
     public static void run(String name) {
        initalizeFrame(); //setup notification frame
        initalizePanel(); //setup notification panels
        initalizeContent(name); //add the content to the notification panels
        initalizeHandle(); //establish an action listener for the buttons
        body.pack();
        body.setVisible(true);
    } //run method

} //NotificationUI class