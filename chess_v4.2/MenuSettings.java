import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.*;  

class MenuSettings extends MenuFrame {
  
  //Swing Components Body
  static JPanel topFormat, topTop, topCenter, left, right;
  //Swing Components for plauerVersus
  static JPanel pvs1, pvs2;
  static JLabel text, pv1Name, pv1Pic, pv2Name, pv2Pic;
  //Swing Components for playerOneSettings
  static JPanel p1s, p1Top, p1Bottom;
  static JLabel p1Title, p1TitleName, p1TitlePic;
  static JTextField p1Name;
  static JComboBox p1Pictures;
  static JButton p1Save;
  //Swing Components for playerTwoSettings
  static JPanel p2s, p2Top, p2Bottom;
  static JLabel p2Title, p2TitleName, p2TitlePic;
  static JTextField p2Name;
  static JComboBox p2Pictures;
  static JButton p2Save;
  //Global Variables
  static String logos[] = {"Norm", "Toro", "Claws", "Ceyeb", "Night", "Plauge", "Pulse"};
  
  //Core Code
  public static void componentsBody() {
    topFormat = new JPanel();
    topFormat.setLayout(new BorderLayout());
    topFormat.setPreferredSize(new Dimension(500,100));
    topFormat.setBorder(BorderFactory.createLineBorder(concrete, 5));
    topFormat.setBackground(charcoal);
    body.add(topFormat, BorderLayout.PAGE_START);
    topTop = new JPanel();
    topTop.setPreferredSize(new Dimension(500,18));
    topTop.setBackground(charcoal);
    topFormat.add(topTop, BorderLayout.PAGE_START);
    topCenter = new JPanel();
    topCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
    topCenter.setBackground(charcoal);
    topFormat.add(topCenter, BorderLayout.CENTER);
    left = new JPanel();
    left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
    left.setBackground(charcoal);
    body.add(left, BorderLayout.CENTER);
    right = new JPanel();
    right.setLayout(new GridLayout(0, 1));
    right.setBackground(charcoal);
    body.add(right, BorderLayout.LINE_END);
  } //componentsBody method
  
  public static void playerVersus(String PlayerOneName, String PlayerOnePic, String PlayerTwoName, String PlayerTwoPic) throws IOException {
    //Generate the pvs1 panel for the top
    pvs1 = new JPanel();
    pvs1.setLayout(new BoxLayout(pvs1, BoxLayout.Y_AXIS));
    pvs1.setMaximumSize(new Dimension(100,100));
    pvs1.setBackground(charcoal);
    topCenter.add(pvs1);
    //Generate the content for the pvs1 panel
    BufferedImage image1 = ImageIO.read(new File(PlayerOnePic));
    pv1Pic = new JLabel(new ImageIcon(image1));
    pv1Pic.setHorizontalAlignment(JLabel.CENTER);
    pvs1.add(pv1Pic);
    pv1Name = new JLabel(PlayerOneName);
    pv1Name.setForeground(offWhite);
    pv1Name.setHorizontalAlignment(JLabel.CENTER);
    pvs1.add(pv1Name);
    //Generate the middle text
    text = new JLabel("vs. ");
    text.setFont(new Font("Arial", Font.PLAIN, 18));
    text.setForeground(offWhite);
    topCenter.add(text);
    //Generate the pvs2 panel for the top
    pvs2 = new JPanel();
    pvs2.setLayout(new BoxLayout(pvs2, BoxLayout.Y_AXIS));
    pvs2.setBackground(charcoal);
    topCenter.add(pvs2);
    //Generate the content for the pvs2 panel
    BufferedImage image2 = ImageIO.read(new File(PlayerTwoPic));
    pv2Pic = new JLabel(new ImageIcon(image2));
    pv2Pic.setHorizontalAlignment(JLabel.CENTER);
    pvs2.add(pv2Pic);
    pv2Name = new JLabel(PlayerTwoName);
    pv2Name.setForeground(offWhite);
    pv2Name.setHorizontalAlignment(JLabel.CENTER);
    pvs2.add(pv2Name);
  } //playerVersus method
  
  public static void playerOneSettings(String name) {
    //Generate the p1s panel for the Body
    p1s = new JPanel();
    p1s.setLayout(new BoxLayout(p1s, BoxLayout.Y_AXIS));
    p1s.setPreferredSize(new Dimension(300,150));
    p1s.setBorder(BorderFactory.createLineBorder(concrete, 3));
    p1s.setBackground(charcoal);
    left.add(p1s);
    //Generate the p1Top panel for p1s
    p1Top = new JPanel();
    p1Top.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
    p1Top.setPreferredSize(new Dimension(300,30));
    p1Top.setBackground(charcoal);
    p1s.add(p1Top);
    //Generate the content for p1Top panel
    p1TitleName = new JLabel("Player  One's  Name: ");
    p1TitleName.setForeground(offWhite);
    p1Top.add(p1TitleName);
    p1Name = new JTextField(name);
    p1Name.setBackground(charcoal);
    p1Name.setPreferredSize(new Dimension(122,30));
    p1Name.setForeground(offWhite);
    p1Top.add(p1Name);
    //Generate the p1Bottom panel for p1s
    p1Bottom = new JPanel();
    p1Bottom.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
    p1Bottom.setPreferredSize(new Dimension(300,30));
    p1Bottom.setBackground(charcoal);
    p1s.add(p1Bottom);
    //Generate the content for p1Bottom panel
    p1TitlePic = new JLabel("Player One's Picture: ");
    p1TitlePic.setForeground(offWhite);
    p1Bottom.add(p1TitlePic);
    p1Pictures = new JComboBox(logos);
    p1Pictures.setPreferredSize(new Dimension(125,30));
    p1Bottom.add(p1Pictures);
    //Generate the save button for p1s
    p1Save = new JButton("Save Changes");
    p1Save.setForeground(lightBlu);
    p1s.add(p1Save);
    p1Save.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e) {
        playerOneName = p1Name.getText();
        pictureDirectory(p1Pictures.getSelectedItem().toString(), 0);
        checkName();
        refresh();
      }  
    });  
  } //playerOneSettings method
  
  public static void playerTwoSettings(String name) {
    //Generate the p1s panel for the Body
    p2s = new JPanel();
    p2s.setLayout(new BoxLayout(p2s, BoxLayout.Y_AXIS));
    p2s.setPreferredSize(new Dimension(300,150));
    p2s.setBorder(BorderFactory.createLineBorder(concrete, 3));
    p2s.setBackground(charcoal);
    right.add(p2s);
    //Generate the p2Top panel for p2s
    p2Top = new JPanel();
    p2Top.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
    p2Top.setPreferredSize(new Dimension(300,30));
    p2Top.setBackground(charcoal);
    p2s.add(p2Top);
    //Generate the content for p2Top panel
    p2TitleName = new JLabel("Player  Two's  Name: ");
    p2TitleName.setForeground(offWhite);
    p2Top.add(p2TitleName);
    p2Name = new JTextField(name);
    p2Name.setPreferredSize(new Dimension(122,30));
    p2Name.setBackground(charcoal);
    p2Name.setForeground(offWhite);
    p2Top.add(p2Name);
    //Generate the p2Bottom panel for p2s
    p2Bottom = new JPanel();
    p2Bottom.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
    p2Bottom.setPreferredSize(new Dimension(300,30));
    p2Bottom.setBackground(charcoal);
    p2s.add(p2Bottom);
    //Generate the content for p2Bottom panel
    p2TitlePic = new JLabel("Player One's Picture: ");
    p2TitlePic.setForeground(offWhite);
    p2Bottom.add(p2TitlePic);
    p2Pictures = new JComboBox(logos);
    p2Pictures.setPreferredSize(new Dimension(125,30));
    p2Bottom.add(p2Pictures);
    //Generate the save button for p2s
    p2Save = new JButton("Save Changes");
    p2Save.setForeground(lightBlu);
    p2s.add(p2Save);
    p2Save.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e) {
        playerTwoName = p2Name.getText();
        pictureDirectory(p2Pictures.getSelectedItem().toString(), 1);
        checkName();
        refresh();
      }  
    });  
  } //playerTwoSettings method
  
  public static void pictureDirectory(String x, int user) {
    String placeholder = "";
    switch (x) {
      case "Toro":
        placeholder = "images/Bull.png";
        break;
      case "Claws":
        placeholder = "images/Cat.png";
        break;
      case "Ceyeb":
        placeholder = "images/Cyborg.png";
        break;
      case "Night":
        placeholder = "images/Dark.png";
        break;
      case "Plauge":
        placeholder = "images/Doctor.png";
        break;
      case "Pulse":
        placeholder = "images/pulse.png";
        break;
      default:
        placeholder = "images/default.jpg";
    }
    if (user == 0)
      playerOneLogo = placeholder;
    if (user == 1)
      playerTwoLogo = placeholder;
  } //directory method
  
  public static void checkName() {
    if (playerOneName.length() > 10)
      playerOneName = pv1Name.getText();
    if (playerTwoName.length() > 10) 
      playerTwoName = pv2Name.getText();
  } //checkName method
  
  public static void refresh() {
    pv1Name.setText(playerOneName);
    pv1Pic.setIcon(new ImageIcon(playerOneLogo));
    pv2Name.setText(playerTwoName);
    pv2Pic.setIcon(new ImageIcon(playerTwoLogo));
    body.revalidate();
  } //refresh method
  
  public static void pack() {
    playerOneName = "Player One";
    playerOneLogo = "images/default.jpg";
    playerTwoName = "Player Two";
    playerTwoLogo = "images/default.jpg";
    componentsBody();
    try {
      playerVersus(playerOneName, playerOneLogo, playerTwoName, playerTwoLogo);
    } catch (Exception e) {
      System.out.println(e);
    }
    playerOneSettings(playerOneName);
    playerTwoSettings(playerTwoName);
  } //pack method
  
} //MenuSettings class