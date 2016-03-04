package fr.jlegall.HMS_TEST.panelModif;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

public class ComboBoxMarque extends JComboBox implements ItemListener {

   private PanelModifMateriel panel;

   public ComboBoxMarque(PanelModifMateriel p) {
      this.panel = p;
      this.addItemListener(this);
   }

   @Override
   public void itemStateChanged(ItemEvent ie) {
      //System.out.println(ie.getItem().toString());
      
      String nomS=null;
      int id=0;
      
      if(!ie.getItem().toString().equals(nomS) && ie.getStateChange() == ItemEvent.SELECTED){
         nomS = ie.getItem().toString();
      }

   }

}
