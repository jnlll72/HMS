package fr.jlegall.HMS_TEST.panelModif;

import fr.jlegall.ProjetHMS.beans.Salle;
import fr.jlegall.ProjetHMS.daoMySql.SalleDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ButtonSalleModif extends JButton implements ActionListener {

   private PanelModifSalle panel;

   public ButtonSalleModif(String str, PanelModifSalle panel) {
      this.setText(str);
      this.panel = panel;
      this.setPreferredSize(new Dimension(150, 25));
      this.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent ae) {
      if (!this.panel.getTextNom().equals("")) {
         Salle salleTemp = new Salle(Integer.parseInt(this.panel.getIdT()), this.panel.getTextNom());
         SalleDAO sd = new SalleDAO();
         sd.update(salleTemp);
         this.panel.getFen().refreshFrame();
      }else{
         this.panel.getTextNomField().setText("(CHAMPS VIDE)");
         this.panel.getTextNomField().setFont(this.panel.getTextNomField().getFont().deriveFont(Font.ITALIC) );
         this.panel.getTextNomField().setForeground(Color.LIGHT_GRAY);
      }
   }
}
