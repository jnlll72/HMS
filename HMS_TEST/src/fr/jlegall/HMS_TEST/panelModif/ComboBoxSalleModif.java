package fr.jlegall.HMS_TEST.panelModif;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

public class ComboBoxSalleModif extends JComboBox implements ItemListener {

   private PanelModifSalle panel;

   public ComboBoxSalleModif(PanelModifSalle p) {
      this.panel = p;
      this.addItemListener(this);
   }

   @Override
   public void itemStateChanged(ItemEvent ie) {
           
      String nomS=null;
      int id=0;
      
      if(!ie.getItem().toString().equals(nomS) && ie.getStateChange() == ItemEvent.SELECTED){
         nomS = ie.getItem().toString();
      }      
      if(nomS != null){
         boolean yes = this.panel.setTextField((String)nomS);   
      }      
   }
}
