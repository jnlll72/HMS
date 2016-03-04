package fr.jlegall.HMS_TEST;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.border.MatteBorder;

public class MenuItem extends JMenuItem implements ActionListener{
   
   private String str;
   private static int cpt=0;
   
   private FenetrePrincipale fenetre;
   
   public MenuItem(String str,FenetrePrincipale fenetre) {
      this.fenetre = fenetre;
      this.setText(str);
      this.setActionCommand(Integer.toString(cpt));
      cpt++;
      
      this.addActionListener(MenuItem.this);
   }
   
   @Override
   public void actionPerformed(ActionEvent ae){
      this.fenetre.modifierPane(Integer.parseInt(ae.getActionCommand()));
   }

}
