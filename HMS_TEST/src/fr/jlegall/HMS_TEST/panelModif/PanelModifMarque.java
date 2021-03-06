/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jlegall.HMS_TEST.panelModif;

import fr.jlegall.HMS_TEST.FenetrePrincipale;
import fr.jlegall.ProjetHMS.beans.Marque;
import fr.jlegall.ProjetHMS.daoMySql.MarqueDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jlegall
 */
public class PanelModifMarque extends JPanel implements ActionListener, MouseListener {

    private List<Marque> listeMarque;

    private JTextField textId;
    private JTextField textNom;

    private String idT = "";
    private String nomT = "";
    private List<JPanel> listePanel;

    private FenetrePrincipale fen;

    public PanelModifMarque(FenetrePrincipale fen) {
        this.fen = fen;
        MarqueDAO marque = new MarqueDAO();
        this.listeMarque = marque.findAll();
        listePanel = new ArrayList<>();

        construirePanel();
    }

    private void construirePanel() {
        this.setLayout(new GridLayout(1, 2));
        Color vert = new Color(87, 191, 147);

        JPanel panOuest = new JPanel();
        panOuest.setBackground(vert);
        panOuest.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        
        JLabel titre = new JLabel("Modifer marque  :   ");
        titre.setFont(new Font("Source Code Pro Black", Font.BOLD, 24));
        titre.setForeground(Color.black);

        ComboBoxMarqueModif choixSalle = new ComboBoxMarqueModif(this);

        for (Marque m : this.listeMarque) {

            choixSalle.addItem(m.getNomMarque());

        }

        choixSalle.addActionListener(this);

        panOuest.add(titre);
        panOuest.add(choixSalle);

        JPanel panEst = new JPanel();
        panEst.setBackground(vert);

        textId = new JTextField(this.idT);
        textId.setColumns(10);
        textId.setEditable(false);
        textNom = new JTextField(this.nomT);
        textNom.setColumns(10);

        textNom.addMouseListener(this);

        JLabel idlabel = new JLabel("ID marque : ");
        idlabel.setFont(new Font("Source Code Pro Black", Font.BOLD, 14));
        idlabel.setForeground(Color.black);
        JLabel nomlabel = new JLabel("Nom marque : ");
        nomlabel.setFont(new Font("Source Code Pro Black", Font.BOLD, 14));
        nomlabel.setForeground(Color.black);

        panEst.setLayout(new BorderLayout());

        JPanel bidon1 = new JPanel();
        bidon1.setPreferredSize(new Dimension(300, 50));
        bidon1.setBackground(vert);
        JPanel bidon2 = new JPanel();
        bidon2.setPreferredSize(new Dimension(30, 400));
        bidon2.setBackground(vert);
        JPanel bidon3 = new JPanel();
        bidon3.setPreferredSize(new Dimension(30, 400));
        bidon3.setBackground(vert);
        JPanel bidon4 = new JPanel();
        bidon4.setPreferredSize(new Dimension(300, 30));
        bidon4.setBackground(vert);

        panEst.add(bidon1, BorderLayout.NORTH);
        panEst.add(bidon2, BorderLayout.EAST);
        panEst.add(bidon3, BorderLayout.WEST);
        panEst.add(bidon4, BorderLayout.SOUTH);

        JPanel panc = new JPanel();
        panc.setBackground(vert);
        JPanel panIdSalle = new JPanel();
        panIdSalle.setBackground(vert);
        panIdSalle.add(idlabel);
        panIdSalle.add(this.textId);

        panc.add(panIdSalle);

        JPanel panNomSalle = new JPanel();
        panNomSalle.setBackground(vert);
        panNomSalle.add(nomlabel);
        panNomSalle.add(this.textNom);

        panc.add(panNomSalle);

        ButtonMarqueModif btnValid = new ButtonMarqueModif("MODIFIER", this);
        btnValid.setPreferredSize(new Dimension(150, 25));
        btnValid.setFont(new Font("Source Code Pro Black", Font.BOLD, 16));

        panc.add(btnValid);

        panEst.add(panc, BorderLayout.CENTER);
        this.listePanel.add(panOuest);
        this.listePanel.add(panEst);

        affichePanel();
    }

    public boolean setTextField(String str) {

        for (Marque m : this.listeMarque) {
            if (m.getNomMarque().equals(str)) {

                this.idT = Integer.toString(m.getIdMarque());
                this.nomT = m.getNomMarque();

                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.textId.setText(this.idT);
        this.textNom.setText(this.nomT);
    }

    private void affichePanel() {

        for (JPanel p : this.listePanel) {
            this.add(p);
        }
    }

    public String getIdT() {
        return idT;
    }

    public String getNomT() {
        return nomT;
    }

    public String getTextNom() {
        return textNom.getText();
    }

    public FenetrePrincipale getFen() {
        return fen;
    }

    public JTextField getTextNomField() {
        return textNom;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        this.textNom.selectAll();     
    }
    @Override
    public void mousePressed(MouseEvent me) {
    }
    @Override
    public void mouseReleased(MouseEvent me) {
    }
    @Override
    public void mouseEntered(MouseEvent me) {
    }
    @Override
    public void mouseExited(MouseEvent me) {
    }
}
