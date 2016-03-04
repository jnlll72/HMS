package fr.jlegall.HMS_TEST;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JMenu;

public class Menu extends JMenu{

   public Menu(String str,Color c){
      this.setText(str);
      this.setOpaque(true);
      this.setBackground(c);
      this.setForeground(Color.BLACK);
      this.setMargin(new Insets(0, 0, 0, 0));
      this.setFont(new Font("Source Code Pro Black", Font.BOLD, 14));
   }
   
}
