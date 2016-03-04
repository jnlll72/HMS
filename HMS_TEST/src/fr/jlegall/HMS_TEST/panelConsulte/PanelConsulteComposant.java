package fr.jlegall.HMS_TEST.panelConsulte;

import fr.jlegall.ProjetHMS.beans.Composant;
import fr.jlegall.ProjetHMS.daoMySql.ComposantDAO;
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

public class PanelConsulteComposant extends JPanel {

    private List<Composant> listeComposant;

    public PanelConsulteComposant() {
        ComposantDAO composant = new ComposantDAO();
        this.listeComposant = composant.findAll();
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
        JLabel num = new JLabel("Numéro du composant");
        num.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        numN.add(num, BorderLayout.CENTER);

        JPanel nomN = new JPanel();
        nomN.setLayout(new BorderLayout());
        JLabel nom = new JLabel("Nom du composant");
        nom.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        nomN.add(nom, BorderLayout.CENTER);

        JPanel coin = new JPanel();

        numN.setPreferredSize(new Dimension(267, 15));
        nomN.setPreferredSize(new Dimension(266, 15));
        coin.setPreferredSize(new Dimension(16, 15));

        numN.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        nomN.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
        coin.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));

        panNomColonne.add(numN);
        panNomColonne.add(nomN);
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

        for (Composant c : this.listeComposant) {

            JPanel pan = new JPanel();
            JPanel panId = new JPanel();
            JPanel panNom = new JPanel();

            pan.setPreferredSize(new Dimension(550, 30));
            FlowLayout flow = new FlowLayout();
            flow.setAlignment(FlowLayout.LEFT);
            flow.setHgap(0);
            flow.setVgap(0);
            pan.setLayout(flow);

            //panId.setBorder(BorderFactory.createLineBorder(Color.black));
            panId.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
            panNom.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));

            panId.setPreferredSize(new Dimension(266, 30));
            panNom.setPreferredSize(new Dimension(266, 30));

            JLabel idComposant = new JLabel(Integer.toString(c.getIdComposant()));
            JLabel nomComposant = new JLabel(c.getNomComposant());

            idComposant.setHorizontalAlignment((int) CENTER_ALIGNMENT);
            nomComposant.setHorizontalAlignment((int) CENTER_ALIGNMENT);

            panId.add(idComposant);
            panNom.add(nomComposant);

            pan.add(panId);
            pan.add(panNom);

            panCenter.add(pan);
        }

        panCenter.setPreferredSize(new Dimension(547, 30 * this.listeComposant.size()));
        JScrollPane scroll = new JScrollPane(panCenter, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        if (this.listeComposant.size() > 9) {
            scroll.setEnabled(true);
        } else {
            scroll.setEnabled(false);
        }

        panelMain.add(scroll, BorderLayout.WEST);

        JPanel panelNord = new JPanel();
        panelNord.setBackground(rouge);
        panelNord.setPreferredSize(new Dimension(this.getWidth(), 30));

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
    }
}
