
package fr.jlegall.HMS_TEST.panelModif;

import fr.jlegall.ProjetHMS.beans.Composant;
import fr.jlegall.ProjetHMS.daoMySql.ComposantDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ButtonComposantModif extends JButton implements ActionListener {

   private PanelModifComposant panel;

   public ButtonComposantModif(String str, PanelModifComposant panel) {
      this.setText(str);
      this.panel = panel;
      this.setPreferredSize(new Dimension(150, 25));
      this.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent ae) {
      if (!this.panel.getTextNom().equals("")) {
         Composant composantTemp = new Composant(Integer.parseInt(this.panel.getIdT()), this.panel.getTextNom());
         ComposantDAO sd = new ComposantDAO();
         sd.update(composantTemp);
         this.panel.getFen().refreshFrame();
      }else{
         this.panel.getTextNomField().setText("(CHAMPS VIDE)");
         this.panel.getTextNomField().setFont(this.panel.getTextNomField().getFont().deriveFont(Font.ITALIC) );
         this.panel.getTextNomField().setForeground(Color.LIGHT_GRAY);
      }
   }
}
