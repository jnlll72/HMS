package fr.jlegall.HMS_TEST.panelModif;

import fr.jlegall.ProjetHMS.beans.Marque;
import fr.jlegall.ProjetHMS.daoMySql.MarqueDAO;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ButtonMarque extends JButton implements ActionListener{
   private PanelModifMarque panel;
   public ButtonMarque(String str,PanelModifMarque panel){
      this.setText(str);
      this.panel = panel;
      this.setPreferredSize(new Dimension(150, 25));
      this.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent ae) {
      Marque marqueTemp = new Marque(Integer.parseInt(this.panel.getIdT()),this.panel.getTextNom());
      MarqueDAO md = new MarqueDAO();
      
      md.update(marqueTemp);
      this.panel.getFen().refreshFrame();
   }
}
