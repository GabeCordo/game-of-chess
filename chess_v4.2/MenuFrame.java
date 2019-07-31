import javax.swing.*;
import java.awt.*;

class MenuFrame {
  
    //Swing Components
    public static JFrame frame;
    protected static JPanel header, body, footer;

    //Global Swing Component Colours
    protected static Color charcoal = new Color(31, 31, 31);
    protected static Color concrete = new Color(34, 34, 34);
    protected static Color offWhite = new Color(224,224,224);
    protected static Color spceGray = new Color(198,198,198);
    protected static Color offCharc = new Color(29, 29, 29);
    protected static Color lightBlu = new Color(64, 115, 215);
    protected static Color limeGreen = new Color(59,132,48);
    protected static Color cherryRed = new Color(182,54,54);
    
    //Player Global Variables
    static String playerOneName, playerOneLogo, playerTwoName, playerTwoLogo;

    //Core Code
    private static void initializeFrame(int screenWidth, int screenHeight) {
        //Create JFrame
        frame = new JFrame();
        //Set the dimensions of the JFrame
        frame.setSize(new Dimension(screenWidth, screenHeight));
        //Center the JFrame
        frame.setLocationRelativeTo(null); //Center the Frame
        //Set the JFrame's close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set whether the JFrame can be resized
        frame.setResizable(true);
        //Set the title of the JFrame
        frame.setTitle("A Game of Chess"); //Frame Title
        //Set the JFrame Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("images/logo2.jpg");
        frame.setIconImage(icon);
    } //initializeFrame method

    private static void initializeLayout() {
        //Set the JFrame to BorderLayout
        frame.getContentPane().setLayout(new BorderLayout());
        //Set the Header of the JFrame
        header = new JPanel();
        header.setLayout(new BorderLayout());
        header.setBackground(concrete);
        header.setPreferredSize(new Dimension(500,200));
        frame.add(header, BorderLayout.PAGE_START);
        //Set the Body of the JFrame
        body = new JPanel();
        body.setLayout(new BorderLayout());
        body.setBackground(charcoal);
        frame.add(body, BorderLayout.CENTER);
        //Set the Footer of the JFrame
        footer = new JPanel();
        footer.setLayout(new BorderLayout());
        footer.setBackground(concrete);
        footer.setPreferredSize(new Dimension(500,150));
        frame.add(footer, BorderLayout.PAGE_END);
    } //initializeLayout

    public static void pack() {
        initializeFrame(500,700);
        initializeLayout();
    } //pack method
    
} //MenuFrame class