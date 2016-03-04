package fr.jlegall.HMS_TEST.panelConsulte;

import fr.jlegall.ProjetHMS.beans.Caracteristique;
import fr.jlegall.ProjetHMS.beans.Composant;
import fr.jlegall.ProjetHMS.beans.Materiel;
import fr.jlegall.ProjetHMS.daoMySql.ComposantDAO;
import fr.jlegall.ProjetHMS.daoMySql.MaterielDAO;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonConsulte extends JButton implements ActionListener {

   public ButtonConsulte(String string) {
      this.setText(string);
      this.setActionCommand(string);
      this.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent ae) {
      JFrame jframe = new JFrame();
      jframe.setSize(200, 300);
      jframe.setLocationRelativeTo(null);
      jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      FlowLayout flow = new FlowLayout();
      flow.setHgap(0);
      flow.setVgap(0);
      flow.setAlignOnBaseline(true);
      flow.setAlignment(FlowLayout.LEFT);
      
      jframe.setLayout(new FlowLayout());
      

      MaterielDAO matDAO = new MaterielDAO();

      List<Composant> listeComposant = new ArrayList<>();

      listeComposant = matDAO.findAllComposant(ae.getActionCommand());

      Materiel mat = matDAO.find(ae.getActionCommand());
      
      JPanel panNom = new JPanel();
      panNom.setPreferredSize(new Dimension(200, 30));
      JLabel nomMat = new JLabel(mat.getNomMateriel());
      panNom.add(nomMat);
      jframe.add(panNom);

      for (Composant c : listeComposant) {
         //System.out.println(c);
         jframe.add(new JLabel(c.getNomComposant() + " : "));
         
         ComposantDAO cDAO = new ComposantDAO();
         
         List<Caracteristique> listCarac = cDAO.findAllCarac(c.getIdComposant());
         
         for(Caracteristique carac : listCarac){
            jframe.add(new JLabel(carac.getNomCarac()));
            jframe.add(new JLabel(carac.getValeurCarac()));
         }
         
      }
      
      jframe.setVisible(true);
   }
}
