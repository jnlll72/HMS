package fr.jlegall.HMS_TEST.panelSuppr;

import fr.jlegall.HMS_TEST.FenetrePrincipale;
import fr.jlegall.ProjetHMS.beans.Marque;
import fr.jlegall.ProjetHMS.beans.Materiel;
import fr.jlegall.ProjetHMS.daoMySql.MarqueDAO;
import fr.jlegall.ProjetHMS.daoMySql.MaterielDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelSupprMarque extends JPanel implements ActionListener {

    private JLabel labelSuppr;
    private JPanel panelN;
    private JPanel panelC;
    private JPanel panelW;
    private JPanel panelE;
    private JTextField field;
    private JButton bouton;
    private ComboBoxMarqueSuppr combo;

    private FenetrePrincipale fenetre;

    private List<Marque> listeMarque;

    private Marque marque;

    public PanelSupprMarque(FenetrePrincipale fenetre) {

        MarqueDAO marqueDAO = new MarqueDAO();
        this.listeMarque = marqueDAO.findAll();

        this.fenetre = fenetre;

        this.labelSuppr = new JLabel();
        this.labelSuppr.setText("Marque à supprimer : ");
        this.labelSuppr.setFont(new Font("Source Code Pro Black", Font.BOLD, 18));
        this.labelSuppr.setForeground(Color.black);
        this.combo = new ComboBoxMarqueSuppr(this);

        this.setLayout(new FlowLayout());
        this.setLayout(new BorderLayout());
        Color bleu = new Color(72, 185, 199);

        this.panelN = new JPanel();
        this.add(this.panelN, BorderLayout.NORTH);
        this.panelN.setPreferredSize(new Dimension(50, 50));
        this.panelN.setBackground(bleu);

        this.panelC = new JPanel();
        this.add(this.panelC, BorderLayout.CENTER);
        this.panelC.setPreferredSize(new Dimension(100, 80));
        this.panelC.setBackground(bleu);

        this.panelW = new JPanel();
        this.add(this.panelW, BorderLayout.WEST);
        this.panelW.setPreferredSize(new Dimension(200, 200));
        this.panelW.setBackground(bleu);

        this.panelE = new JPanel();
        this.add(this.panelE, BorderLayout.EAST);
        this.panelE.setPreferredSize(new Dimension(200, 200));
        this.panelE.setBackground(bleu);

        this.bouton = new JButton("SUPPRIMER");
        this.bouton.setPreferredSize(new Dimension(150, 25));
        this.bouton.setFont(new Font("Source Code Pro Black", Font.BOLD, 16));
        this.combo.setPreferredSize(new Dimension(150, 25));

        this.panelC.add(labelSuppr);
        this.panelC.add(combo);
        this.panelC.add(bouton);

        for (Marque marque : this.listeMarque) {
            this.combo.addItem(marque.getNomMarque());
        }
        this.bouton.addActionListener(this);

    }

    public boolean setTextField(String str) {

        for (Marque s : this.listeMarque) {
            if (s.getNomMarque().equals(str)) {

                marque = new Marque(s.getIdMarque(), s.getNomMarque());

                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        int nombre=0;
        MaterielDAO matDAO = new MaterielDAO();
        String nomMarque = marque.getNomMarque();
        matDAO.findAllByMarque(nomMarque);
        */
        JOptionPane opt = new JOptionPane();
        int reponse = opt.showConfirmDialog(null,
                "Êtes-vous sûr de vouloir supprimer cette marque ?",
                "Confirmation",
                opt.YES_NO_OPTION,
                opt.QUESTION_MESSAGE);
        if (reponse == opt.YES_OPTION) {
            MarqueDAO marqueDAO = new MarqueDAO();
            marqueDAO.delete(marque);
            this.fenetre.refreshFrame();
        }
    }
}
