/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jlegall.HMS_TEST.panelAjout;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

/**
 *
 * @author Thomas Lemaître
 */
public class ComboBoxType extends JComboBox implements ItemListener {

   private PanelAjoutMateriel panel;

   public ComboBoxType(PanelAjoutMateriel p) {
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
