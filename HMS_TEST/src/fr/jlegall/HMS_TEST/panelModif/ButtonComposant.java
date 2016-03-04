
package fr.jlegall.HMS_TEST.panelModif;

import fr.jlegall.ProjetHMS.beans.Composant;
import fr.jlegall.ProjetHMS.beans.TypeM;
import fr.jlegall.ProjetHMS.daoMySql.ComposantDAO;
import fr.jlegall.ProjetHMS.daoMySql.TypeMDAO;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ButtonComposant extends JButton implements ActionListener{
   private PanelModifComposant panel;
   
   public ButtonComposant(String str, PanelModifComposant panel){
      this.setText(str);
      this.panel = panel;
      this.setPreferredSize(new Dimension(150, 25));
      this.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent ae) {
      Composant composantTemp = new Composant(Integer.parseInt(this.panel.getIdT()),this.panel.getTextNom());
      ComposantDAO sd = new ComposantDAO();
      
      sd.update(composantTemp);
      this.panel.getFen().refreshFrame();
   }
}