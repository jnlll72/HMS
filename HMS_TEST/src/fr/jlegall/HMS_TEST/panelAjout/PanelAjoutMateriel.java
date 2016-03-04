
package fr.jlegall.HMS_TEST.panelAjout;

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
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAjoutMateriel extends JPanel implements ActionListener, MouseListener {

    private List<Materiel> listeMateriel;
    private List<Marque> listeMarque;
    private List<Salle> listeSalle;
    private List<TypeM> listeTypeM;

    private JTextField field;
    private JTextField nomMat;
    private JTextField numSerieT;
    private JLabel titre;
    private JLabel ajoutMat;
    private JLabel nomLabel;
    private JLabel etatLabel;
    private JLabel marqueLabel;
    private JLabel typeLabel;
    private JLabel salleLabel;
    private JLabel numSerie;

    private String nomM = "";
    private JPanel panelC;
    private JPanel panelN;
    private JPanel panelW;
    private JPanel panelE;
    private JPanel panelS;

    private ComboBoxMarque choixMarque;
    private ComboBoxSalle choixSalle;
    private ComboBoxEtat choixEtat;
    private ComboBoxType choixType;

    private FenetrePrincipale fen;

    public PanelAjoutMateriel(FenetrePrincipale fen) {
        this.fen = fen;
        MaterielDAO materiel = new MaterielDAO();
        MarqueDAO marque = new MarqueDAO();
        SalleDAO salle = new SalleDAO();
        TypeMDAO type = new TypeMDAO();

        //this.listeMateriel = materiel.findAll();

        this.listeMarque = marque.findAll();
        this.listeSalle = salle.findAll();
        this.listeTypeM = type.findAll();

        Color jaune = new Color(253, 181, 21);

        this.setLayout(new BorderLayout());
        this.panelN = new JPanel();
        this.add(panelN, BorderLayout.NORTH);
        this.panelN.setBackground(jaune);
        this.panelN.setPreferredSize(new Dimension(0, 60));
        this.panelS = new JPanel();
        this.add(panelS, BorderLayout.SOUTH);
        this.panelS.setBackground(jaune);
        this.panelS.setPreferredSize(new Dimension(0, 80));
        this.panelC = new JPanel();
        this.add(panelC, BorderLayout.CENTER);
        this.panelC.setBackground(jaune);
        this.panelW = new JPanel();
        this.add(panelW, BorderLayout.WEST);
        this.panelW.setBackground(jaune);
        this.panelW.setPreferredSize(new Dimension(125, 0));
        this.panelE = new JPanel();
        this.add(panelE, BorderLayout.EAST);
        this.panelE.setBackground(jaune);
        this.panelE.setPreferredSize(new Dimension(125, 0));

        choixMarque = new ComboBoxMarque(this);
        choixSalle = new ComboBoxSalle(this);
        choixEtat = new ComboBoxEtat(this);
        choixType = new ComboBoxType(this);

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

        field = new JTextField(10);
        this.field.setText("(CHAMPS VIDE)");
        this.field.setFont(new Font("Source Code Pro Black", Font.BOLD, 14));
        this.field.setForeground(Color.lightGray);
        this.field.setFont(this.field.getFont().deriveFont(Font.ITALIC));
        numSerieT = new JTextField(10);
        this.numSerieT.setText("(CHAMPS VIDE)");
        this.numSerieT.setFont(new Font("Source Code Pro Black", Font.ITALIC, 14));
        this.numSerieT.setForeground(Color.lightGray);

        field.addMouseListener(this);
        numSerieT.addMouseListener(this);

        titre = new JLabel("Nouveau matériel");
        this.titre.setFont(new Font("Source Code Pro Black", Font.BOLD, 24));
        this.titre.setForeground(Color.black);
        nomLabel = new JLabel("Nom materiel  :  ");
        this.nomLabel.setFont(new Font("Source Code Pro Black", Font.BOLD, 20));
        this.nomLabel.setForeground(Color.black);
        numSerie = new JLabel("Numéro de série  :  ");
        this.numSerie.setFont(new Font("Source Code Pro Black", Font.BOLD, 20));
        this.numSerie.setForeground(Color.black);
        etatLabel = new JLabel("        Etat  :  ");
        this.etatLabel.setFont(new Font("Source Code Pro Black", Font.BOLD, 20));
        this.etatLabel.setForeground(Color.black);
        marqueLabel = new JLabel("        Marque  :  ");
        this.marqueLabel.setFont(new Font("Source Code Pro Black", Font.BOLD, 20));
        this.marqueLabel.setForeground(Color.black);
        typeLabel = new JLabel("        Type  :  ");
        this.typeLabel.setFont(new Font("Source Code Pro Black", Font.BOLD, 20));
        this.typeLabel.setForeground(Color.black);
        salleLabel = new JLabel("          Salle  :  ");
        this.salleLabel.setFont(new Font("Source Code Pro Black", Font.BOLD, 20));
        this.salleLabel.setForeground(Color.black);

        JButton btnValid = new JButton("AJOUTER");
        btnValid.setPreferredSize(new Dimension(150, 25));
        btnValid.setFont(new Font("Source Code Pro Black", Font.BOLD, 20));
        btnValid.addActionListener(this);

        panelN.add(titre);
        panelC.setLayout(new FlowLayout());
        panelC.add(nomLabel);
        panelC.add(field);
        panelC.add(numSerie);
        panelC.add(numSerieT);
        panelC.add(typeLabel);
        panelC.add(choixType);
        panelC.add(marqueLabel);
        panelC.add(choixMarque);
        panelC.add(etatLabel);
        panelC.add(choixEtat);
        panelC.add(salleLabel);
        panelC.add(choixSalle);
        panelS.add(btnValid);

        /*String nomMarque = this.listeMateriel.get(0).getMarque().getNomMarque();
        String nomSalle = this.listeMateriel.get(0).getSalle().getNomSalle();
        boolean etat = this.listeMateriel.get(0).isEtat();
        String nomType = this.listeMateriel.get(0).getType().getNomTypeM();

        String idE;

        if (etat) {
            idE = "EN LIGNE";
        } else {
            idE = "HORS LIGNE";
        }
        this.field.setText(this.field.getText());
        this.getChoixMarque().setSelectedItem(nomMarque);
        this.getChoixSalle().setSelectedItem(nomSalle);
        this.getChoixEtat().setSelectedItem(idE);
        this.getChoixType().setSelectedItem(nomType);*/

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (!this.field.getText().equals("") && !this.field.getText().equals("(CHAMPS VIDE)")
               && !this.numSerieT.getText().equals("") && !this.numSerieT.getText().equals("(CHAMPS VIDE)")) {
            String nomMateriel = field.getText();
            String numSerie = numSerieT.getText();
            String etatMateriel = (String) this.getChoixEtat().getSelectedItem();
            Marque marque = this.trouveMarque((String) this.getChoixMarque().getSelectedItem());
            TypeM type = this.trouveType((String) this.getChoixType().getSelectedItem());
            Salle salle = this.trouveSalle((String) this.getChoixSalle().getSelectedItem());

            boolean idEtat = false;
            if (etatMateriel.equals("EN LIGNE")) {
                idEtat = true;
            }            
            Materiel matTemp = new Materiel(numSerie, nomMateriel, idEtat, marque, type, salle);
            MaterielDAO md = new MaterielDAO();
            md.create(matTemp);
            this.fen.refreshFrame();
        } else if(this.field.getText().equals("")){
            this.field.setText("(CHAMPS VIDE)");
            this.field.setFont(this.field.getFont().deriveFont(Font.ITALIC));
            this.field.setForeground(Color.LIGHT_GRAY);
        }else if (this.numSerieT.getText().equals("")){
            this.numSerieT.setText("(CHAMPS VIDE)");
            this.numSerieT.setFont(this.numSerieT.getFont().deriveFont(Font.ITALIC));
            this.numSerieT.setForeground(Color.LIGHT_GRAY);
        }
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
        if (this.field.getText().equals("(CHAMPS VIDE)")){
            this.field.setText("");
            this.field.setFont(this.field.getFont().deriveFont(Font.PLAIN));
            this.field.setForeground(Color.BLACK);
        } else{
            this.field.setText(this.field.getText());            
        }
        if(this.numSerieT.getText().equals("(CHAMPS VIDE)")){
            this.numSerieT.setText("");
            this.numSerieT.setFont(this.numSerieT.getFont().deriveFont(Font.PLAIN));
            this.numSerieT.setForeground(Color.BLACK);
        }else{
            this.numSerieT.setText(this.numSerieT.getText());
        }
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
