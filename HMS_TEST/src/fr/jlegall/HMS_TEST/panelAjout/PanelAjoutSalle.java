package fr.jlegall.HMS_TEST.panelAjout;

import fr.jlegall.HMS_TEST.FenetrePrincipale;
import fr.jlegall.ProjetHMS.beans.Salle;
import fr.jlegall.ProjetHMS.daoMySql.SalleDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
//Class Ajout salle

public class PanelAjoutSalle extends JPanel implements ActionListener, MouseListener, KeyListener {
//Déclaration des objects 

    private JLabel ajoutSalle;
    private JPanel panelN;
    private JPanel panelC;
    private JPanel panelW;
    private JPanel panelE;
    private JTextField field;
    private JButton bouton;
//Déclaration de la FenetrePrincipale
    private FenetrePrincipale fenetre;
//Méthode Ajout salle

    public PanelAjoutSalle(FenetrePrincipale fenetre) {

        this.fenetre = fenetre;

        this.ajoutSalle = new JLabel();
        this.ajoutSalle.setText("Nom de la salle :");
        this.ajoutSalle.setFont(new Font("Source Code Pro Black", Font.BOLD, 20));
        this.ajoutSalle.setForeground(Color.black);
        this.field = new JTextField(10);
        this.field.setText("(CHAMPS VIDE)");
        this.field.setFont(new Font("Source Code Pro Black", Font.BOLD, 14));
        this.field.setForeground(Color.lightGray);
        this.field.setFont(this.field.getFont().deriveFont(Font.ITALIC));
        this.field.addMouseListener(this);

        this.setLayout(new FlowLayout());
        this.setLayout(new BorderLayout());
        Color jaune = new Color(253, 181, 21);        

        this.panelN = new JPanel();
        this.add(this.panelN, BorderLayout.NORTH);
        this.panelN.setPreferredSize(new Dimension(100, 100));
        this.panelN.setBackground(jaune);

        this.panelC = new JPanel();
        this.add(this.panelC, BorderLayout.CENTER);
        this.panelC.setPreferredSize(new Dimension(100, 80));
        this.panelC.setBackground(jaune);

        this.panelW = new JPanel();
        this.add(this.panelW, BorderLayout.WEST);
        this.panelW.setPreferredSize(new Dimension(200, 200));
        this.panelW.setBackground(jaune);

        this.panelE = new JPanel();
        this.add(this.panelE, BorderLayout.EAST);
        this.panelE.setPreferredSize(new Dimension(200, 200));
        this.panelE.setBackground(jaune);

        this.bouton = new JButton("AJOUTER");
        bouton.setPreferredSize(new Dimension(150, 25));
        bouton.setFont(new Font("Source Code Pro Black", Font.BOLD, 18));
        this.bouton.addActionListener(this);
        this.field.addKeyListener(this);

        this.panelC.add(ajoutSalle);
        this.panelC.add(field);
        this.panelC.add(bouton);

//        Border loweredetched = BorderFactory.createLineBorder(Color.black);
//        TitledBorder title;
//        title = BorderFactory.createTitledBorder("title");
//        panelC.setBorder(title);
//        title = BorderFactory.createTitledBorder(loweredetched, "title");
//        title.setTitleJustification(TitledBorder.CENTER);
//        panelC.setBorder(title);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!this.field.getText().equals("") && !this.field.getText().equals("(CHAMPS VIDE)")) {
            SalleDAO salleDao = new SalleDAO();
            String newSalle = field.getText();
            Salle salle = new Salle(0, newSalle);
            salleDao.create(salle);
            this.fenetre.refreshFrame();
        } else {
            this.field.setText("(CHAMPS VIDE)");
            this.field.setFont(this.field.getFont().deriveFont(Font.ITALIC));
            this.field.setForeground(Color.LIGHT_GRAY);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.field.getText().equals("(CHAMPS VIDE)")) {
            this.field.setText("");
            this.field.setFont(this.field.getFont().deriveFont(Font.PLAIN));
            this.field.setForeground(Color.BLACK);
        } else {
            this.field.setText(this.field.getText());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && !this.field.getText().equals("")) {
            SalleDAO salleDao = new SalleDAO();
            String newSalle = field.getText();
            Salle salle = new Salle(0, newSalle);
            salleDao.create(salle);
            this.fenetre.refreshFrame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
