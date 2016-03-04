package fr.jlegall.HMS_TEST.panelModif;

import fr.jlegall.ProjetHMS.beans.Marque;
import fr.jlegall.ProjetHMS.daoMySql.MarqueDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ButtonMarqueModif extends JButton implements ActionListener {

   private PanelModifMarque panel;

   public ButtonMarqueModif(String str, PanelModifMarque panel) {
      this.setText(str);
      this.panel = panel;
      this.setPreferredSize(new Dimension(150, 25));
      this.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent ae) {
      if (!this.panel.getTextNom().equals("")) {
         Marque marqueTemp = new Marque(Integer.parseInt(this.panel.getIdT()), this.panel.getTextNom());
         MarqueDAO md = new MarqueDAO();
         md.update(marqueTemp);
         this.panel.getFen().refreshFrame();
      } else {
         this.panel.getTextNomField().setText("(CHAMPS VIDE)");
         this.panel.getTextNomField().setFont(this.panel.getTextNomField().getFont().deriveFont(Font.ITALIC));
         this.panel.getTextNomField().setForeground(Color.LIGHT_GRAY);
      }
   }
}
