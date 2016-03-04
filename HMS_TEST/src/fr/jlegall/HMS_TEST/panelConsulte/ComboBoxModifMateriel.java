package fr.jlegall.HMS_TEST.panelConsulte;

import fr.jlegall.HMS_TEST.FenetrePrincipale;
import fr.jlegall.ProjetHMS.beans.Materiel;
import fr.jlegall.ProjetHMS.beans.TypeM;
import fr.jlegall.ProjetHMS.daoMySql.HistoriqueDAO;
import fr.jlegall.ProjetHMS.daoMySql.MaterielDAO;
import fr.jlegall.ProjetHMS.daoMySql.TypeMDAO;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class ComboBoxModifMateriel extends JComboBox implements ItemListener {

   private PanelConsulteMateriel p;
   private FenetrePrincipale f;

   public ComboBoxModifMateriel(PanelConsulteMateriel p) {
      this.p = p;

      MaterielDAO mat = new MaterielDAO();
      TypeMDAO typ = new TypeMDAO();
      List<TypeM> liste = new ArrayList<>();

      liste = mat.findAllType();

      this.addItem("Tous");
      for (TypeM t : liste) {
         this.addItem((String) t.getNomTypeM());
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

         this.p.setPanel(nomS);

      }

   }

}
