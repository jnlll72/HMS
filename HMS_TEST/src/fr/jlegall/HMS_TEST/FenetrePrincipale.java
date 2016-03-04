package fr.jlegall.HMS_TEST;

import fr.jlegall.HMS_TEST.panelAjout.*;
import fr.jlegall.HMS_TEST.panelConsulte.*;
import fr.jlegall.HMS_TEST.panelSuppr.*;
import fr.jlegall.HMS_TEST.panelModif.*;
import fr.jlegall.ProjetHMS.beans.Historique;
import java.util.*;
import javax.swing.*;

public class FenetrePrincipale extends JFrame {

   private List<JPanel> listePanel;
   private PanelOrigine pano;
   private int idHisto;
   
   public FenetrePrincipale() {
      this.setTitle("HMS");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(615, 400);
      this.setResizable(false);
      this.setLocationRelativeTo(null);

      listePanel = new ArrayList<>();

      MenuBar menu = new MenuBar(this);
      this.setJMenuBar(menu);
      pano = new PanelOrigine();
      this.setContentPane(pano);

      ajoutPanel();

      this.setVisible(true);
   }

   private void ajoutPanel() {
      PanelAjoutMateriel pan0 = new PanelAjoutMateriel(this);
      PanelAjoutSalle pan1 = new PanelAjoutSalle(this);
      PanelAjoutMarque pan2 = new PanelAjoutMarque(this);
      PanelAjoutComposant pan3 = new PanelAjoutComposant(this);
      PanelAjoutTypeM pan4 = new PanelAjoutTypeM(this);

      listePanel.add(pan0);
      listePanel.add(pan1);
      listePanel.add(pan2);
      listePanel.add(pan3);
      listePanel.add(pan4);

      PanelModifMateriel pan5 = new PanelModifMateriel(this);
      PanelModifSalle pan6 = new PanelModifSalle(this);
      PanelModifMarque pan7 = new PanelModifMarque(this);
      PanelModifComposant pan8 = new PanelModifComposant(this);
      PanelModifTypeM pan9 = new PanelModifTypeM(this);

      listePanel.add(pan5);
      listePanel.add(pan6);
      listePanel.add(pan7);
      listePanel.add(pan8);
      listePanel.add(pan9);

      PanelSupprMateriel pan10 = new PanelSupprMateriel(this);
      PanelSupprSalle pan11 = new PanelSupprSalle(this);
      PanelSupprMarque pan12 = new PanelSupprMarque(this);
      PanelSupprComposant pan13 = new PanelSupprComposant(this);
      PanelSupprTypeM pan14 = new PanelSupprTypeM(this);

      listePanel.add(pan10);
      listePanel.add(pan11);
      listePanel.add(pan12);
      listePanel.add(pan13);
      listePanel.add(pan14);

      PanelConsulteMateriel pan15 = new PanelConsulteMateriel();
      PanelConsulteSalle pan16 = new PanelConsulteSalle();
      PanelConsulteMarque pan17 = new PanelConsulteMarque();
      PanelConsulteComposant pan18 = new PanelConsulteComposant();
      PanelConsulteTypeM pan19 = new PanelConsulteTypeM();
      PanelConsulteHistorique pan20 = new PanelConsulteHistorique(this);

      listePanel.add(pan15);
      listePanel.add(pan16);
      listePanel.add(pan17);
      listePanel.add(pan18);
      listePanel.add(pan19);
      listePanel.add(pan20);
   }

   public void modifierPane(int num) {
      this.setContentPane(this.listePanel.get(num));
      this.validate();
   }

   public void refreshFrame(){
       this.setContentPane(pano);
       this.listePanel.clear();
       this.ajoutPanel();
       this.validate();
   }
   
   public void refreshHisto(String str){
      this.listePanel.remove(20);
      PanelConsulteHistorique pan20 = new PanelConsulteHistorique(this,str);
      this.listePanel.add(20, pan20);
      this.modifierPane(20);
   }
   
}
