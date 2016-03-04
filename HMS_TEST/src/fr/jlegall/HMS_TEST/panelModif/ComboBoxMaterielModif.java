package fr.jlegall.HMS_TEST.panelModif;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

public class ComboBoxMaterielModif extends JComboBox implements ItemListener {

   private PanelModifMateriel panel;

   public ComboBoxMaterielModif(PanelModifMateriel p) {
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
         String nomMarque = this.panel.trouveMateriel(nomS).getMarque().getNomMarque();
         String nomSalle = this.panel.trouveMateriel(nomS).getSalle().getNomSalle();
         boolean etat = this.panel.trouveMateriel(nomS).isEtat();
         String nomType = this.panel.trouveMateriel(nomS).getType().getNomTypeM();
         
         String idE;
         
         if(etat){
            idE="EN LIGNE";
         }else{
            idE="HORS LIGNE";
         }

         this.panel.getChoixMarque().setSelectedItem(nomMarque);
         this.panel.getChoixSalle().setSelectedItem(nomSalle);
         this.panel.getChoixEtat().setSelectedItem(idE);
         this.panel.getChoixType().setSelectedItem(nomType);

      }     
   }
}
