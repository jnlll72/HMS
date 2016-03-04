package fr.jlegall.HMS_TEST.panelConsulte;

import fr.jlegall.HMS_TEST.FenetrePrincipale;
import fr.jlegall.ProjetHMS.beans.Historique;
import fr.jlegall.ProjetHMS.daoMySql.HistoriqueDAO;
import fr.jlegall.ProjetHMS.daoMySql.MaterielDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelConsulteHistorique extends JPanel {

   List<Historique> listeHistorique;
   private FenetrePrincipale f;
   private JPanel panelPrincipale;
   private JPanel panCenter;
   private String choix="Tous";

   public PanelConsulteHistorique(FenetrePrincipale f) {
      this.f = f;
      HistoriqueDAO histo = new HistoriqueDAO();
      this.listeHistorique = histo.findAll();
      this.construirePanel();
   }

   public PanelConsulteHistorique(FenetrePrincipale f, String str) {
      this.f = f;
      HistoriqueDAO histo = new HistoriqueDAO();
      //this.listeHistorique.clear();
      this.listeHistorique = histo.findByMateriel(str);

      this.construirePanel();
   }

   private void construirePanel() {

      this.setLayout(new BorderLayout());

      Color rouge = new Color(238, 49, 36);

      JPanel panelMain = new JPanel();
      panelMain.setLayout(new BorderLayout());

      //GridLayout gridNord = new GridLayout(1, 2);
      FlowLayout flowNord = new FlowLayout();
      flowNord.setAlignment(FlowLayout.LEFT);
      flowNord.setHgap(0);
      flowNord.setVgap(0);

      JPanel panNomColonne = new JPanel();
      panNomColonne.setLayout(flowNord);

      /*JPanel numN = new JPanel();
       numN.setLayout(new BorderLayout());
       JLabel num = new JLabel("Numéro");
       num.setHorizontalAlignment((int) CENTER_ALIGNMENT);
       numN.add(num,BorderLayout.CENTER);*/
      JPanel nomN = new JPanel();
      nomN.setLayout(new BorderLayout());
      JLabel nom = new JLabel("Nom du matériel");
      nom.setHorizontalAlignment((int) CENTER_ALIGNMENT);
      nomN.add(nom, BorderLayout.CENTER);

      JPanel dateN = new JPanel();
      dateN.setLayout(new BorderLayout());
      JLabel dte = new JLabel("date");
      dte.setHorizontalAlignment((int) CENTER_ALIGNMENT);
      dateN.add(dte, BorderLayout.CENTER);

      JPanel desN = new JPanel();
      desN.setLayout(new BorderLayout());
      JLabel des = new JLabel("Description");
      des.setHorizontalAlignment((int) CENTER_ALIGNMENT);
      desN.add(des, BorderLayout.CENTER);

      JPanel coin = new JPanel();

      //numN.setPreferredSize(new Dimension(100, 15));
      nomN.setPreferredSize(new Dimension(133, 15));
      dateN.setPreferredSize(new Dimension(100, 15));
      desN.setPreferredSize(new Dimension(300, 15));
      coin.setPreferredSize(new Dimension(16, 15));

      //numN.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
      nomN.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
      dateN.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
      desN.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
      coin.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));

      //panNomColonne.add(numN);
      panNomColonne.add(nomN);
      panNomColonne.add(dateN);
      panNomColonne.add(desN);
      panNomColonne.add(coin);

      panelMain.add(panNomColonne, BorderLayout.NORTH);

      panCenter = new JPanel();
      panCenter.setPreferredSize(new Dimension(555, 340));

      FlowLayout gridCenter = new FlowLayout();
      gridCenter.setAlignOnBaseline(false);
      gridCenter.setAlignment(FlowLayout.LEFT);

      gridCenter.setHgap(0);
      gridCenter.setVgap(0);
      panCenter.setLayout(gridCenter);

      for (Historique histo : this.listeHistorique) {

         JPanel pan = new JPanel();
         JPanel panId = new JPanel();
         JPanel panMat = new JPanel();
         JPanel panDate = new JPanel();
         JPanel panDesc = new JPanel();

         pan.setPreferredSize(new Dimension(550, 30));

         FlowLayout flow = new FlowLayout();
         flow.setAlignment(FlowLayout.LEFT);
         flow.setHgap(0);
         flow.setVgap(0);
         pan.setLayout(flow);

         //panId.setBorder(BorderFactory.createLineBorder(Color.black));
         panId.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
         panMat.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
         panDate.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
         panDesc.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));

         //panId.setPreferredSize(new Dimension(99, 30));
         panMat.setPreferredSize(new Dimension(132, 30));
         panDate.setPreferredSize(new Dimension(100, 30));
         panDesc.setPreferredSize(new Dimension(300, 30));

         //JLabel idHisto = new JLabel(Integer.toString(histo.getIdHistorique()));
         JLabel idMateriel = new JLabel(histo.getMateriel().getNomMateriel());
         JLabel idDate = new JLabel(new SimpleDateFormat("dd/MM/yyyy").format(histo.getDateMaj()));
         JLabel idDesc = new JLabel(histo.getDescription());

         //idHisto.setHorizontalAlignment((int) CENTER_ALIGNMENT);
         idMateriel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
         idDate.setHorizontalAlignment((int) CENTER_ALIGNMENT);
         idDesc.setHorizontalAlignment((int) CENTER_ALIGNMENT);

         //panId.add(idHisto);
         panMat.add(idMateriel);
         panDate.add(idDate);
         panDesc.add(idDesc);

         //pan.add(panId);
         pan.add(panMat);
         pan.add(panDate);
         pan.add(panDesc);

         panCenter.add(pan);
      }

      panCenter.setPreferredSize(new Dimension(547, 30 * this.listeHistorique.size()));
      JScrollPane scroll = new JScrollPane(panCenter, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

      if (this.listeHistorique.size() > 9) {
         scroll.setEnabled(true);
      } else {
         scroll.setEnabled(false);
      }

      panelMain.add(scroll, BorderLayout.WEST);

      JPanel panelNord = new JPanel();
      panelNord.setBackground(rouge);

      panelNord.setPreferredSize(new Dimension(this.getWidth(), 30));
      
      JLabel label = new JLabel("Tri par materiel : ");
      
      panelNord.add(label);
      panelNord.add(new ComboBoxModifHisto(this, this.f));

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
      this.removeAll();
      HistoriqueDAO h = new HistoriqueDAO();
      if (str.equals("Tous")) {
         this.listeHistorique = h.findAll();
         this.setChoix("Tous");
      } else {
         this.listeHistorique = h.findByMateriel(str);
         this.setChoix(m.find(str).getNomMateriel());
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
