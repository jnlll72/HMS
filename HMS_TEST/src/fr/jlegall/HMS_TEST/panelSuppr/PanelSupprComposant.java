package fr.jlegall.HMS_TEST.panelSuppr;

import fr.jlegall.HMS_TEST.FenetrePrincipale;
import fr.jlegall.ProjetHMS.beans.Composant;
import fr.jlegall.ProjetHMS.daoMySql.ComposantDAO;
import fr.jlegall.ProjetHMS.daoMySql.MarqueDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelSupprComposant extends JPanel implements ActionListener {

    private JLabel labelSuppr;
    private JPanel panelN;
    private JPanel panelC;
    private JPanel panelW;
    private JPanel panelE;
    private JButton bouton;
    private ComboBoxComposantSuppr combo;
    private FenetrePrincipale fenetre;
    private List<Composant> listeComposant;
    private Composant composant;

    public PanelSupprComposant(FenetrePrincipale fenetre) {
        ComposantDAO composantDAO = new ComposantDAO();
        this.listeComposant = composantDAO.findAll();

        this.fenetre = fenetre;

        this.labelSuppr = new JLabel();
        this.labelSuppr.setText("Composant à supprimer : ");
        this.labelSuppr.setFont(new Font("Source Code Pro Black", Font.BOLD, 18));
        this.labelSuppr.setForeground(Color.black);
        this.combo = new ComboBoxComposantSuppr(this);

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
        this.panelW.setPreferredSize(new Dimension(180, 150));
        this.panelW.setBackground(bleu);

        this.panelE = new JPanel();
        this.add(this.panelE, BorderLayout.EAST);
        this.panelE.setPreferredSize(new Dimension(180, 150));
        this.panelE.setBackground(bleu);

        this.bouton = new JButton("SUPPRIMER");
        this.bouton.setPreferredSize(new Dimension(150, 25));
        this.bouton.setFont(new Font("Source Code Pro Black", Font.BOLD, 16));
        this.combo.setPreferredSize(new Dimension(150, 25));
        //this.field.addActionListener(this);
        this.panelC.add(labelSuppr);
        this.panelC.add(combo);
        this.panelC.add(bouton);

        for (Composant composant : this.listeComposant) {
            this.combo.addItem(composant.getNomComposant());
        }
        this.bouton.addActionListener(this);
    }

    public boolean setTextField(String str) {
        for (Composant c : this.listeComposant) {
            if (c.getNomComposant().equals(str)) {
                composant = new Composant(c.getIdComposant(), c.getNomComposant());
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane opt = new JOptionPane();
        int reponse = opt.showConfirmDialog(null,
                "Êtes-vous sûr de vouloir supprimer ce composant ?",
                "Confirmation",
                opt.YES_NO_OPTION,
                opt.QUESTION_MESSAGE);
        if (reponse == opt.YES_OPTION) {
            ComposantDAO composantDAO = new ComposantDAO();
            composantDAO.delete(composant);
            this.fenetre.refreshFrame();
        }
    }
}
