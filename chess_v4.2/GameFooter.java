import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;

public class GameFooter extends GameFrame {

    //PlayerOneHistory Swing Components
    static JPanel history;
    static JLabel content;
    //PlayerOneProfile Swing Components
    static JPanel profile;
    static JLabel profileName, profilePicture;


    //Core Code
    private static void playerOneHistory() {
        //Generate the History Panel for the Header
        history = new JPanel();
        history.setBackground(offCharc);
        history.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 4));
        footer.add(history, BorderLayout.PAGE_END);
        //Generate the Content for the History Panel
        content = new JLabel("P1: ");
        content.setForeground(lghtBlue);
        content.setFont(new Font("Arial", Font.PLAIN, 14));
        history.add(content);
    } //playerOneHistory method

    private static void playerOneProfile(String name, String picture) throws IOException {
        //Generate the Profile Panel for the Header
        profile = new JPanel();
        profile.setBackground(charcoal);
        profile.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 6));
        footer.add(profile, BorderLayout.CENTER);
        //Generate the Content for the Profile Panel
        BufferedImage image = ImageIO.read(new File(picture));
        profilePicture = new JLabel(new ImageIcon(image));
        profilePicture.setPreferredSize(new Dimension(50,50));
        profile.add(profilePicture);
        profileName = new JLabel(name);
        profileName.setForeground(offWhite);
        profileName.setFont(new Font("Arial", Font.PLAIN, 18));
        profile.add(profileName);
    } //playerOneProfile method

    public static void p1UpdateHistory(String movement) {
      String placeholder = content.getText();
      String concatenation = placeholder + ", " + movement;
      content.setText(concatenation);
    }  //p1UpdateHistory method
    
    public static void pack(String name, String file) {
        playerOneHistory();
        try {
            playerOneProfile(name, file);
        } catch (Exception e) {
            System.out.println(e);
        }
    } //pack method

} //GameFooter class
