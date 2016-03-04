package fr.jlegall.HMS_TEST.panelModif;

import fr.jlegall.ProjetHMS.beans.Marque;
import fr.jlegall.ProjetHMS.beans.Materiel;
import fr.jlegall.ProjetHMS.beans.Salle;
import fr.jlegall.ProjetHMS.beans.TypeM;
import fr.jlegall.ProjetHMS.daoMySql.MaterielDAO;
import fr.jlegall.ProjetHMS.daoMySql.SalleDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ButtonMaterielModif extends JButton implements ActionListener {

   private PanelModifMateriel panel;

   public ButtonMaterielModif(String str, PanelModifMateriel panel) {
      this.setText(str);
      this.panel = panel;
      this.setPreferredSize(new Dimension(150, 25));
      this.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent ae) {

      if (!this.panel.getTextNom().equals("")) {
         String numMateriel = this.panel.getIdT();
         String nomMateriel = this.panel.getTextNom();
         String etatMateriel = (String)this.panel.getChoixEtat().getSelectedItem();
         Marque marque = this.panel.trouveMarque((String)this.panel.getChoixMarque().getSelectedItem());
         TypeM type = this.panel.trouveType((String)this.panel.getChoixType().getSelectedItem());
         Salle salle = this.panel.trouveSalle((String)this.panel.getChoixSalle().getSelectedItem());
         
         
         //System.out.println(etatMateriel);
         
         boolean idEtat=false;
         if(etatMateriel.equals("EN LIGNE")){
            idEtat=true;
         }
         
//         int idMat = Integer.parseInt(idMateriel);

         Materiel matTemp = new Materiel(numMateriel,nomMateriel,idEtat,marque,type,salle);
         MaterielDAO md = new MaterielDAO();
         matTemp = md.update(matTemp);
 
         this.panel.getFen().refreshFrame();
         
      }else{
         this.panel.getTextNomField().setText("(CHAMPS VIDE)");
         this.panel.getTextNomField().setFont(this.panel.getTextNomField().getFont().deriveFont(Font.ITALIC) );
         this.panel.getTextNomField().setForeground(Color.LIGHT_GRAY);
      }
   }
}
