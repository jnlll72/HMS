/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jlegall.HMS_TEST.panelModif;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

/**
 *
 * @author Thomas Lemaître
 */
public class ComboBoxComposantModif extends JComboBox implements ItemListener {

   private PanelModifComposant panel;

   public ComboBoxComposantModif(PanelModifComposant p) {
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
      
      if(nomS != null){
         boolean yes = this.panel.setTextField((String)nomS);   
      }      
   }
}