package fr.jlegall.HMS_TEST.panelConsulte;

import fr.jlegall.HMS_TEST.FenetrePrincipale;
import fr.jlegall.ProjetHMS.beans.Materiel;
import fr.jlegall.ProjetHMS.daoMySql.HistoriqueDAO;
import fr.jlegall.ProjetHMS.daoMySql.MaterielDAO;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class ComboBoxModifHisto extends JComboBox implements ItemListener {

   private PanelConsulteHistorique p;
   private FenetrePrincipale f;

   public ComboBoxModifHisto(PanelConsulteHistorique p, FenetrePrincipale f) {
      this.p = p;
      this.f = f;
      HistoriqueDAO h = new HistoriqueDAO();
      List<Materiel> liste = new ArrayList<>();
      liste = h.findAllMateriel();
      this.addItem("Tous");
      for (Materiel m : liste) {
         this.addItem((String) m.getNomMateriel());
      }

      this.setSelectedItem(this.p.getChoix());
      this.addItemListener(this);

   }

   @Override
   public void itemStateChanged(ItemEvent ie) {

      MaterielDAO m = new MaterielDAO();

      String nomS = null;
      int id = 0;

      if (!ie.getItem().toString().equals(nomS) && ie.getStateChange() == ItemEvent.SELECTED) {
         nomS = ie.getItem().toString();

         if (nomS.equals("Tous")) {
            this.p.setPanel(nomS);
         } else {
            String numS = m.findNumSerie(nomS);
            this.p.setPanel(numS);
         }

      }

   }

}
