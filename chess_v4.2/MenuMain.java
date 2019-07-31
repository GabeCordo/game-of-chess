class MenuMain {
  
  static MenuFrame pane = new MenuFrame();
  static MenuGraphics design = new MenuGraphics();
  static MenuSettings options = new MenuSettings();
  
  public static void run() {
        pane.pack();
        design.pack();
        options.pack();
        pane.frame.pack();
        pane.frame.setVisible(true);
    } //main method
  
} //MenuMain class