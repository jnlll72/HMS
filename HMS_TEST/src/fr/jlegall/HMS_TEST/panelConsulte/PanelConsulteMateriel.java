package fr.jlegall.HMS_TEST.panelConsulte;

import fr.jlegall.ProjetHMS.beans.Materiel;
import fr.jlegall.ProjetHMS.daoMySql.HistoriqueDAO;
import fr.jlegall.ProjetHMS.daoMySql.MaterielDAO;
import fr.jlegall.ProjetHMS.daoMySql.TypeMDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.util.List;
import javax.swing.BorderFactory;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelConsulteMateriel extends JPanel {

   private List<Materiel> listeMateriel;
   private String choix="Tous";

   public PanelConsulteMateriel() {
      MaterielDAO materiel = new MaterielDAO();
      this.listeMateriel = materiel.findAll();
      construirePanel();
   }

   private void construirePanel() {
      this.setLayout(new BorderLayout());

      Color rouge = new Color(238, 49, 36);

      JPanel panelMain = new JPanel();
      panelMain.setLayout(new BorderLayout());

      FlowLayout flowNord = new FlowLayout();
      flowNord.setAlignment(FlowLayout.LEFT);
      flowNord.setHgap(0);
      flowNord.setVgap(0);

      JPanel panNomColonne = new JPanel();
      panNomColonne.setLayout(flowNord);

      JPanel numN = new JPanel();
      numN.setLayout(new BorderLayout());
      JLabel num = new JLabel("Numéro");
      num.setHorizontalAlignment((int) CENTER_ALIGNMENT);
      numN.add(num, BorderLayout.CENTER);

      JPanel nomN = new JPanel();
      nomN.setLayout(new BorderLayout());
      JLabel nom = new JLabel("Nom");
      nom.setHorizontalAlignment((int) CENTER_ALIGNMENT);
      nomN.add(nom, BorderLayout.CENTER);

      JPanel etatN = new JPanel();
      etatN.setLayout(new BorderLayout());
      JLabel etat = new JLabel("Etat");
      etat.setHorizontalAlignment((int) CENTER_ALIGNMENT);
      etatN.add(etat, BorderLayout.CENTER);

      JPanel marqueN = new JPanel();
      marqueN.setLayout(new BorderLayout());
      JLabel marque = new JLabel("Marque");
      marque.setHorizontalAlignment((int) CENTER_ALIGNMENT);
      marqueN.add(marque, BorderLayout.CENTER);

      JPanel typeN = new JPanel();
      typeN.setLayout(new BorderLayout());
      JLabel type = new JLabel("Type");
      type.setHorizontalAlignment((int) CENTER_ALIGNMENT);
      typeN.add(type, BorderLayout.CENTER);

      JPanel salleN = new JPanel();
      salleN.setLayout(new BorderLayout());
      JLabel salle = new JLabel("Salle");
      salle.setHorizontalAlignment((int) CENTER_ALIGNMENT);
      salleN.add(salle, BorderLayout.CENTER);

      JPanel coin = new JPanel();

      numN.setPreferredSize(new Dimension(89, 15));
      nomN.setPreferredSize(new Dimension(92, 15));
      etatN.setPreferredSize(new Dimension(88, 15));
      marqueN.setPreferredSize(new Dimension(88, 15));
      typeN.setPreferredSize(new Dimension(88, 15));
      salleN.setPreferredSize(new Dimension(88, 15));

      coin.setPreferredSize(new Dimension(16, 15));

      numN.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

      nomN.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
      etatN.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
      marqueN.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
      typeN.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
      salleN.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));

      coin.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
      
      panNomColonne.add(numN);
      panNomColonne.add(nomN);
      panNomColonne.add(etatN);
      panNomColonne.add(marqueN);
      panNomColonne.add(typeN);
      panNomColonne.add(salleN);
      panNomColonne.add(coin);
      
      panelMain.add(panNomColonne, BorderLayout.NORTH);

      JPanel panCenter = new JPanel();
      panCenter.setPreferredSize(new Dimension(555, 340));
      //GridLayout gridCenter = new GridLayout(this.listeSalle.size(), 2);
      FlowLayout gridCenter = new FlowLayout();
      gridCenter.setAlignOnBaseline(false);
      gridCenter.setAlignment(FlowLayout.LEFT);

      gridCenter.setHgap(0);
      gridCenter.setVgap(0);
      panCenter.setLayout(gridCenter);

      for (Materiel m : this.listeMateriel) {

         JPanel pan = new JPanel();
         JPanel panId = new JPanel();
         JPanel panNom = new JPanel();
         JPanel panEtat = new JPanel();
         JPanel panMarque = new JPanel();
         JPanel panType = new JPanel();
         JPanel panSalle = new JPanel();

         pan.setPreferredSize(new Dimension(550, 30));

         FlowLayout flow = new FlowLayout();
         flow.setAlignment(FlowLayout.LEFT);
         flow.setHgap(0);
         flow.setVgap(0);
         pan.setLayout(flow);

         //panId.setBorder(BorderFactory.createLineBorder(Color.black));
         panId.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
         panNom.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
         panEtat.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
         panMarque.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
         panType.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
         panSalle.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));

         panId.setPreferredSize(new Dimension(88, 30));
         panId.setAlignmentX(CENTER_ALIGNMENT);
         panId.setAlignmentY(CENTER_ALIGNMENT);

         panNom.setPreferredSize(new Dimension(92, 30));
         panEtat.setPreferredSize(new Dimension(88, 30));
         panMarque.setPreferredSize(new Dimension(88, 30));
         panType.setPreferredSize(new Dimension(88, 30));
         panSalle.setPreferredSize(new Dimension(88, 30));

         ButtonConsulte btnid = new ButtonConsulte(m.getNumSerieMateriel());

         btnid.setAlignmentY(TOP_ALIGNMENT);
         //JLabel idMateriel = new JLabel(Integer.toString(m.getIdMateriel()));

         JLabel nomMateriel = new JLabel(m.getNomMateriel());
         JLabel etatMateriel = new JLabel();
         JLabel marqueMateriel = new JLabel(m.getMarque().getNomMarque());
         JLabel typeMateriel = new JLabel(m.getType().getNomTypeM());
         JLabel salleMateriel = new JLabel(m.getSalle().getNomSalle());

         if (m.isEtat() == true) {
            etatMateriel.setText("EN LIGNE");
            etatMateriel.setForeground(Color.GREEN);
         } else {
            etatMateriel.setText("HORS LIGNE");
            etatMateriel.setForeground(Color.RED);
         }

         //idMateriel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
         //btnid.setPreferredSize(new Dimension(60, 20));
         nomMateriel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
         etatMateriel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
         marqueMateriel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
         typeMateriel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
         salleMateriel.setHorizontalAlignment((int) CENTER_ALIGNMENT);

         panId.setLayout(new BorderLayout());
         panId.add(btnid, BorderLayout.CENTER);
         panNom.add(nomMateriel);
         panEtat.add(etatMateriel);
         panMarque.add(marqueMateriel);
         panType.add(typeMateriel);
         panSalle.add(salleMateriel);

         pan.add(panId);
         pan.add(panNom);
         pan.add(panEtat);
         pan.add(panMarque);
         pan.add(panType);
         pan.add(panSalle);

         panCenter.add(pan);
      }

      panCenter.setPreferredSize(new Dimension(547, 30 * this.listeMateriel.size()));
      JScrollPane scroll = new JScrollPane(panCenter, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

      if (this.listeMateriel.size() > 9) {

         scroll.setEnabled(true);
      } else {
         scroll.setEnabled(false);
      }

      panelMain.add(scroll, BorderLayout.WEST);

      JPanel panelNord = new JPanel();
      panelNord.setBackground(rouge);
      panelNord.setPreferredSize(new Dimension(this.getWidth(), 30));
      
      panelNord.add(new JLabel("Tri par type : "));
      
      panelNord.add(new ComboBoxModifMateriel(this));

      JPanel panelSud = new JPanel();
      panelSud.setPreferredSize(new Dimension(this.getWidth(), 30));
      panelSud.setBackground(rouge);

      JPanel panelEst = new JPanel();
      panelEst.setPreferredSize(new Dimension(30, this.getHeight()));
      panelEst.setBackground(rouge);

      JPanel panelOuest = new JPanel();
      panelOuest.setPreferredSize(new Dimension(30, this.getHeight()));
      panelOuest.setBackground(rouge);

      this.add(panelNord, BorderLayout.NORTH);
      this.add(panelEst, BorderLayout.EAST);
      this.add(panelSud, BorderLayout.SOUTH);
      this.add(panelOuest, BorderLayout.WEST);
      this.add(panelMain, BorderLayout.CENTER);
      
      this.revalidate();
      this.repaint();
   }
   
      public void setPanel(String str) {
      //this.f.refreshFrame();
      MaterielDAO m = new MaterielDAO();
      TypeMDAO ty = new TypeMDAO();
      this.removeAll();
      HistoriqueDAO h = new HistoriqueDAO();
      if (str.equals("Tous")) {
         this.listeMateriel = m.findAll();
         this.setChoix("Tous");
      } else {
         this.listeMateriel = m.findByType(str);
         this.setChoix(ty.findByName(str).getNomTypeM());
      }
      
      this.construirePanel();
   }
   
   public String getChoix(){
      return this.choix;
   }

   public void setChoix(String choix) {
      this.choix = choix;
   }

}
