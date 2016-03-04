/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jlegall.HMS_TEST.panelModif;

import fr.jlegall.HMS_TEST.FenetrePrincipale;
import fr.jlegall.ProjetHMS.beans.Marque;
import fr.jlegall.ProjetHMS.beans.Materiel;
import fr.jlegall.ProjetHMS.beans.Salle;
import fr.jlegall.ProjetHMS.beans.TypeM;
import fr.jlegall.ProjetHMS.daoMySql.MarqueDAO;
import fr.jlegall.ProjetHMS.daoMySql.MaterielDAO;
import fr.jlegall.ProjetHMS.daoMySql.SalleDAO;
import fr.jlegall.ProjetHMS.daoMySql.TypeMDAO;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jlegall
 */
public class PanelModifMateriel extends JPanel implements ActionListener, MouseListener {

    private List<Materiel> listeMateriel;
    private List<Marque> listeMarque;
    private List<Salle> listeSalle;
    private List<TypeM> listeTypeM;

    private JTextField textId;
    private JTextField textNom;

    private String idM = "";
    private String nomM = "";
    private List<JPanel> listePanel;

    private ComboBoxMarque choixMarque;
    private ComboBoxSalle choixSalle;
    private ComboBoxEtat choixEtat;
    private ComboBoxType choixType;

    private FenetrePrincipale fen;

    public PanelModifMateriel(FenetrePrincipale fen) {
        this.fen = fen;
        MaterielDAO materiel = new MaterielDAO();
        MarqueDAO marque = new MarqueDAO();
        SalleDAO salle = new SalleDAO();
        TypeMDAO type = new TypeMDAO();

        this.listeMateriel = materiel.findAll();

        this.listeMarque = marque.findAll();
        this.listeSalle = salle.findAll();
        this.listeTypeM = type.findAll();

        listePanel = new ArrayList<>();

        construirePanel();
    }

    private void construirePanel() {
        this.setLayout(new GridLayout(1, 2));
        Color vert = new Color(87, 191, 147);

        JPanel panOuest = new JPanel();
        panOuest.setBackground(vert);
        panOuest.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));

        JLabel titre = new JLabel("Modifer matériel  :  ");
        titre.setFont(new Font("Source Code Pro Black", Font.BOLD, 24));
        titre.setForeground(Color.black);
        
        ComboBoxMaterielModif choixMateriel = new ComboBoxMaterielModif(this);

        choixMarque = new ComboBoxMarque(this);
        choixSalle = new ComboBoxSalle(this);
        choixEtat = new ComboBoxEtat(this);
        choixType = new ComboBoxType(this);

        for (Materiel m : this.listeMateriel) {
            choixMateriel.addItem(m.getNomMateriel());
        }
        for (Marque ma : this.listeMarque) {
            choixMarque.addItem(ma.getNomMarque());
        }

        for (Salle s : this.listeSalle) {
            choixSalle.addItem(s.getNomSalle());
        }

        choixEtat.addItem((String) "EN LIGNE");
        choixEtat.addItem((String) "HORS LIGNE");

        for (TypeM t : this.listeTypeM) {
            choixType.addItem(t.getNomTypeM());
        }

        choixMateriel.addActionListener(this);

        panOuest.add(titre);
        panOuest.add(choixMateriel);
        
        JPanel panEst = new JPanel();
        panEst.setBackground(vert);

        textId = new JTextField(this.idM);
        textId.setColumns(10);
        textId.setEditable(false);
        textNom = new JTextField(this.nomM);
        textNom.setColumns(10);
        textNom.setForeground(Color.BLACK);

        textNom.addMouseListener(this);

        JLabel idlabel = new JLabel("Numéro de Série :");
        idlabel.setFont(new Font("Source Code Pro Black", Font.BOLD, 14));
        idlabel.setForeground(Color.black);
        JLabel nomlabel = new JLabel("Nom materiel : ");
        nomlabel.setFont(new Font("Source Code Pro Black", Font.BOLD, 14));
        nomlabel.setForeground(Color.black);
        JLabel etatlabel = new JLabel("Etat : ");
        etatlabel.setFont(new Font("Source Code Pro Black", Font.BOLD, 14));
        etatlabel.setForeground(Color.black);
        JLabel marquelabel = new JLabel("Marque : ");
        marquelabel.setFont(new Font("Source Code Pro Black", Font.BOLD, 14));
        marquelabel.setForeground(Color.black);
        JLabel typelabel = new JLabel("Type : ");
        typelabel.setFont(new Font("Source Code Pro Black", Font.BOLD, 14));
        typelabel.setForeground(Color.black);
        JLabel sallelabel = new JLabel("Salle : ");
        sallelabel.setFont(new Font("Source Code Pro Black", Font.BOLD, 14));
        sallelabel.setForeground(Color.black);

        panEst.setLayout(new BorderLayout());

        JPanel bidon1 = new JPanel();
        bidon1.setPreferredSize(new Dimension(300, 30));
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

        JPanel panIdMateriel = new JPanel();
        panIdMateriel.setBackground(vert);
        panIdMateriel.add(idlabel);
        panIdMateriel.add(this.textId);

        JPanel panNomMateriel = new JPanel();
        panNomMateriel.setBackground(vert);
        panNomMateriel.add(nomlabel);
        panNomMateriel.add(this.textNom);

        JPanel panEtatMateriel = new JPanel();
        panEtatMateriel.setBackground(vert);
        panEtatMateriel.add(etatlabel);
        panEtatMateriel.add(choixEtat);

        JPanel panMarqueMateriel = new JPanel();
        panMarqueMateriel.setBackground(vert);
        panMarqueMateriel.add(marquelabel);
        panMarqueMateriel.add(choixMarque);

        JPanel panTypeMateriel = new JPanel();
        panTypeMateriel.setBackground(vert);
        panTypeMateriel.add(typelabel);
        panTypeMateriel.add(choixType);

        JPanel panNomSalle = new JPanel();
        panNomSalle.setBackground(vert);
        panNomSalle.add(sallelabel);
        panNomSalle.add(choixSalle);

        panc.add(panIdMateriel);
        panc.add(panNomMateriel);
        panc.add(panEtatMateriel);
        panc.add(panMarqueMateriel);
        panc.add(panTypeMateriel);
        panc.add(panNomSalle);

        ButtonMaterielModif btnValid = new ButtonMaterielModif("MODIFIER", this);
        btnValid.setPreferredSize(new Dimension(150, 25));
        btnValid.setFont(new Font("Source Code Pro Black", Font.BOLD, 16));

        panc.add(btnValid);

        panEst.add(panc, BorderLayout.CENTER);
        this.listePanel.add(panOuest);
        this.listePanel.add(panEst);

        String nomMarque = this.listeMateriel.get(0).getMarque().getNomMarque();
        String nomSalle = this.listeMateriel.get(0).getSalle().getNomSalle();
        boolean etat = this.listeMateriel.get(0).isEtat();
        String nomType = this.listeMateriel.get(0).getType().getNomTypeM();

        String idE;

        if (etat) {
            idE = "EN LIGNE";
        } else {
            idE = "HORS LIGNE";
        }
        this.textNom.setText(this.listeMateriel.get(0).getNomMateriel());
        this.getChoixMarque().setSelectedItem(nomMarque);
        this.getChoixSalle().setSelectedItem(nomSalle);
        this.getChoixEtat().setSelectedItem(idE);
        this.getChoixType().setSelectedItem(nomType);

        affichePanel();
    }

    public boolean setTextField(String str) {

        for (Materiel m : this.listeMateriel) {
            if (m.getNomMateriel().equals(str)) {

                this.idM = m.getNumSerieMateriel();
                this.nomM = m.getNomMateriel();

                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.textId.setText(this.idM);
        this.textNom.setText(this.nomM);
    }

    private void affichePanel() {
        for (JPanel p : this.listePanel) {
            this.add(p);
        }
    }

    public String getIdT() {
        return idM;
    }

    public String getNomT() {
        return nomM;
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

    public ComboBoxMarque getChoixMarque() {
        return choixMarque;
    }

    public ComboBoxSalle getChoixSalle() {
        return choixSalle;
    }

    public ComboBoxEtat getChoixEtat() {
        return choixEtat;
    }

    public ComboBoxType getChoixType() {
        return choixType;
    }

    public Materiel trouveMateriel(String str) {
        Materiel tmp = null;
        for (Materiel m : this.listeMateriel) {
            if (m.getNomMateriel().equals(str)) {
                return m;
            }
        }
        return tmp;
    }

    public Marque trouveMarque(String str) {
        Marque tmp = null;
        for (Marque m : this.listeMarque) {
            if (m.getNomMarque().equals(str)) {
                return m;
            }
        }
        return tmp;
    }

    public TypeM trouveType(String str) {
        TypeM tmp = null;
        for (TypeM m : this.listeTypeM) {
            if (m.getNomTypeM().equals(str)) {
                return m;
            }
        }
        return tmp;
    }

    public Salle trouveSalle(String str) {
        Salle tmp = null;
        for (Salle m : this.listeSalle) {
            if (m.getNomSalle().equals(str)) {
                return m;
            }
        }
        return tmp;
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
